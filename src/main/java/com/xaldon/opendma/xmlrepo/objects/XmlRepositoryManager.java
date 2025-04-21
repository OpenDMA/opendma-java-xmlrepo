package com.xaldon.opendma.xmlrepo.objects;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.opendma.api.OdmaClass;
import org.opendma.api.OdmaCommonNames;
import org.opendma.api.OdmaGuid;
import org.opendma.api.OdmaId;
import org.opendma.api.OdmaObject;
import org.opendma.api.OdmaProperty;
import org.opendma.api.OdmaQName;
import org.opendma.api.OdmaRepository;
import org.opendma.api.OdmaType;
import org.opendma.exceptions.OdmaAccessDeniedException;
import org.opendma.exceptions.OdmaInvalidDataTypeException;
import org.opendma.exceptions.OdmaObjectNotFoundException;
import org.opendma.exceptions.OdmaRuntimeException;
import org.opendma.impl.OdmaPropertyImpl;
import org.opendma.impl.core.OdmaStaticClassHierarchy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.xaldon.opendma.xmlrepo.exceptions.OdmaXmlRepositoryException;

public class XmlRepositoryManager
{
    
    protected HashMap<OdmaId, OdmaObject> objects = new HashMap<OdmaId, OdmaObject>();
    
    protected HashMap<OdmaQName, OdmaClass> classes = new HashMap<OdmaQName, OdmaClass>();
    
    protected OdmaRepository repository;
    
    public OdmaRepository getRepository()
    {
        return repository;
    }
    
    protected boolean enforceRequired = false;

    public XmlRepositoryManager(InputStream in, boolean enforceRequired) throws OdmaXmlRepositoryException
    {
        this.enforceRequired = enforceRequired;
        Document descriptionDocument;
        try
        {
        	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        	dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        	dbf.setXIncludeAware(false);
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            descriptionDocument = docBuilder.parse(in);
        }
        catch(ParserConfigurationException e)
        {
            throw new OdmaXmlRepositoryException("Error reading input XML file", e);
        }
        catch(FactoryConfigurationError e)
        {
            throw new OdmaXmlRepositoryException("Error reading input XML file", e);
        }
        catch(SAXException e)
        {
            throw new OdmaXmlRepositoryException("Error reading input XML file", e);
        }
        catch(IOException e)
        {
            throw new OdmaXmlRepositoryException("Error reading input XML file", e);
        }
        parseRepository(descriptionDocument.getDocumentElement());
    }

    public XmlRepositoryManager(Element root) throws OdmaXmlRepositoryException
    {
        parseRepository(root);
    }
    
    public static final String ELEMENTNAME_ODMAXMLREPOSITORY = "OdmaXmlRepository";
    
    public static final String ELEMENTNAME_ODMAOBJECT = "OdmaObject";
    
    public static final String ELEMENTNAME_PROPERTY = "Property";
    
    public static final String ELEMENTNAME_VALUE = "Value";
    
    public static final String ATTRIBUTENAME_REPOSITORYOBJECTID = "repositoryObjectId";
    
    public static final String ATTRIBUTENAME_CLASSQUALIFIER_DEPRECATED = "classQualifier";
    
    public static final String ATTRIBUTENAME_CLASSNAMESPACE = "classNamespace";
    
    public static final String ATTRIBUTENAME_CLASSNAME = "className";
    
    public static final String ATTRIBUTENAME_QUALIFIER_DEPRECATED = "qualifier";
    
    public static final String ATTRIBUTENAME_NAMESPACE = "namespace";
    
    public static final String ATTRIBUTENAME_NAME = "name";
    
    public static final String ATTRIBUTENAME_TYPE = "type";
    
    public static final String ATTRIBUTENAME_MULTIVALUE = "multiValue";

    protected static Map<String, OdmaType> datatypeValues = new HashMap<String, OdmaType>();
    
    static
    {
        datatypeValues.put("string",OdmaType.STRING);
        datatypeValues.put("integer",OdmaType.INTEGER);
        datatypeValues.put("short",OdmaType.SHORT);
        datatypeValues.put("long",OdmaType.LONG);
        datatypeValues.put("float",OdmaType.LONG);
        datatypeValues.put("double",OdmaType.DOUBLE);
        datatypeValues.put("boolean",OdmaType.BOOLEAN);
        datatypeValues.put("datetime",OdmaType.DATETIME);
        datatypeValues.put("blob",OdmaType.BLOB);
        datatypeValues.put("reference",OdmaType.REFERENCE);
        datatypeValues.put("content",OdmaType.CONTENT);
        datatypeValues.put("id",OdmaType.ID);
    }
    
    protected void parseRepository(Element rootElement) throws OdmaXmlRepositoryException
    {
        // validate element
        if(!rootElement.getNodeName().equals(ELEMENTNAME_ODMAXMLREPOSITORY))
        {
            throw new OdmaXmlRepositoryException("Root element in an OdmaXmlRepository must be "+ELEMENTNAME_ODMAXMLREPOSITORY);
        }
        // get the ID of the contained OdmaRepository object
        String repositoryObjectId = rootElement.getAttribute(ATTRIBUTENAME_REPOSITORYOBJECTID);
        if( (repositoryObjectId==null) || (repositoryObjectId.length()==0) )
        {
            throw new OdmaXmlRepositoryException("Every OdmaXmlRepository must have a non-empty repositoryObjectId attribute");
        }
        // parse all contained objects
        ArrayList<OdmaXmlObjectData> objectDatas = new ArrayList<OdmaXmlObjectData>();
        NodeList rootChilds = rootElement.getChildNodes();
        for (int i = 0; i < rootChilds.getLength(); i++)
        {
            Node child = rootChilds.item(i);
            if(child.getNodeType() == Node.ELEMENT_NODE)
            {
                if(((Element)child).getTagName().equals(ELEMENTNAME_ODMAOBJECT))
                {
                    objectDatas.add(parseObject((Element)child));
                }
            }
        }
        // build odma objects from object datas
        buildObjects(objectDatas,repositoryObjectId);
    }
    
    protected OdmaStaticClassHierarchy classesHive;
    
    public OdmaStaticClassHierarchy getClassesHieve()
    {
        return classesHive;
    }
    
    public OdmaObject getObject(OdmaId id) throws OdmaObjectNotFoundException
    {
        OdmaObject obj = objects.get(id);
        if(obj == null)
        {
            throw new OdmaObjectNotFoundException(new OdmaGuid(repository.getId(), id));
        }
        return obj;
    }
    
    @SuppressWarnings("unchecked")
    protected void buildObjects(ArrayList<OdmaXmlObjectData> objectDatas, String repositoryObjectId) throws OdmaXmlRepositoryException
    {
        boolean duplicateIdContinue = true;
        boolean hasDuplicateIds = false;
        // add core Odma objects
        OdmaId repoId = new OdmaId(repositoryObjectId);
        OdmaGuid repoGuid = new OdmaGuid(repoId,repoId);
        try
        {
            classesHive = new OdmaStaticClassHierarchy("Test","Test",repoId,repoGuid);
        }
        catch (OdmaInvalidDataTypeException e)
        {
            throw new OdmaRuntimeException("Implementation error",e);
        }
        catch (OdmaAccessDeniedException e)
        {
            throw new OdmaRuntimeException("Implementation error",e);
        }
        objects.putAll(classesHive.getAllObjectsById());
        classes.putAll(classesHive.getAllClassesByName());
        try
        {
            repository = (OdmaRepository)classesHive.getObjectById(repoId);
        }
        catch(OdmaObjectNotFoundException e2)
        {
            throw new OdmaRuntimeException("Implementation error",e2);
        }
        // build entire set of classes
        LinkedList<OdmaClass> unevaluatedClassClassesQueue = new LinkedList<OdmaClass>();
        ArrayList<OdmaXmlClass> buildEffectivePropertiesList = new ArrayList<OdmaXmlClass>();
        unevaluatedClassClassesQueue.add(classesHive.getClassInfo(OdmaCommonNames.CLASS_CLASS));
        while(unevaluatedClassClassesQueue.size() > 0)
        {
            OdmaClass classClass = unevaluatedClassClassesQueue.removeFirst();
            List<OdmaXmlClass> classPostProcessing = new ArrayList<OdmaXmlClass>();
            for(int i = 0; i < objectDatas.size(); i++)
            {
                OdmaXmlObjectData od = (OdmaXmlObjectData)objectDatas.get(i);
                if(od == null)
                    continue;
                boolean isClass = false;
                if(od.getClassName().equals(classClass.getQName()))
                {
                    isClass = true;
                }
                else
                {
                    OdmaProperty propNamespace = od.getProperties().get(OdmaCommonNames.PROPERTY_NAMESPACE);
                    if(propNamespace == null)
                    {
                        // handle xml files containing objects of OpenDMA < 0.7.0
                        propNamespace = od.getProperties().get(new OdmaQName("opendma", "NameQualifier"));
                    }
                    OdmaProperty propName = od.getProperties().get(OdmaCommonNames.PROPERTY_NAME);
                    OdmaProperty propSuperClass = od.getProperties().get(OdmaCommonNames.PROPERTY_SUPERCLASS);
                    if(propSuperClass == null)
                    {
                        // handle xml files containing objects of OpenDMA < 0.7.0
                        propSuperClass = od.getProperties().get(OdmaCommonNames.PROPERTY_PARENT);
                    }
                    if( (propNamespace!=null) && (propName!=null) && (propSuperClass != null) )
                    {
                        try
                        {
                            String namespace = propNamespace.getString();
                            String name = propName.getString();
                            OdmaId parent = propSuperClass.getId();
                            if(od.getClassName().equals(new OdmaQName(namespace,name)) && (parent.equals(classClass.getId())))
                            {
                                isClass = true;
                            }
                        }
                        catch(OdmaInvalidDataTypeException idte)
                        {
                            // just ignore this. this can not be a class.
                            // TODO: is it really possible that there are objects out there that look like a class but are not classes ?!?
                        }
                    }
                }
                if(isClass)
                {
                    OdmaId classId = od.getId();
                    // manually set system controlled properties
                    od.setSystemProperties(classClass, new OdmaGuid(repoId,classId), repository);
                    OdmaXmlClass c = factoryCreateClass(od,classClass);
                    classPostProcessing.add(c);
                    buildEffectivePropertiesList.add(c);
                    if(objects.containsKey(classId))
                    {
                        if(duplicateIdContinue)
                        {
                            System.out.println("duplicated id "+classId);
                            hasDuplicateIds = true;
                        }
                        else
                        {
                            throw new OdmaXmlRepositoryException("duplicated id "+classId);
                        }
                    }
                    objects.put(classId,c);
                    classes.put(c.getQName(),c);
                    objectDatas.set(i,null);
                }
            }
            for(OdmaXmlClass c : classPostProcessing)
            {
                Map<OdmaQName, OdmaProperty> p = c.getInternalProperties();
                // resolve parent from ID to instance
                OdmaPropertyImpl superClassProperty = (OdmaPropertyImpl)p.get(OdmaCommonNames.PROPERTY_SUPERCLASS);
                if(superClassProperty == null)
                {
                    // handle xml files containing objects of OpenDMA < 0.7.0
                    superClassProperty = (OdmaPropertyImpl)p.get(OdmaCommonNames.PROPERTY_PARENT);
                }
                if(superClassProperty instanceof UnevaluatedReferenceProperty)
                {
                    OdmaId parentId;
                    try
                    {
                        parentId = superClassProperty.getId();
                    }
                    catch(OdmaInvalidDataTypeException e1)
                    {
                        throw new OdmaXmlRepositoryException("Implementation error",e1);
                    }
                    OdmaClass parent = (OdmaClass)objects.get(parentId);
                    if(parent == null)
                    {
                        // TODO: What if this parentId exists, but is defined in the XML file _after_ this object?
                        throw new OdmaRuntimeException("Invalid parent ("+parentId+") for class "+c.getId());
                    }
                    try
                    {
                        superClassProperty = new OdmaPropertyImpl(OdmaCommonNames.PROPERTY_SUPERCLASS,parent,OdmaType.REFERENCE,false,true);
                        p.put(OdmaCommonNames.PROPERTY_SUPERCLASS,superClassProperty);
                    }
                    catch(OdmaInvalidDataTypeException e)
                    {
                        throw new OdmaRuntimeException("Implementation error",e);
                    }
                }
                // resolve aspects from ID to instance
                OdmaPropertyImpl aspectsProperty = (OdmaPropertyImpl)p.get(OdmaCommonNames.PROPERTY_ASPECTS);
                if(aspectsProperty instanceof UnevaluatedReferenceProperty)
                {
                    List<OdmaId> aspetIds;
                    try
                    {
                        aspetIds = aspectsProperty.getIdList();
                    }
                    catch(OdmaInvalidDataTypeException e1)
                    {
                        throw new OdmaXmlRepositoryException("Implementation error",e1);
                    }
                    LinkedList<OdmaClass> aspects = new LinkedList<OdmaClass>();
                    for(OdmaId aspectId : aspetIds)
                    {
                        OdmaClass aspect = (OdmaClass)objects.get(aspectId);
                        if(aspect == null)
                        {
                            // TODO: What if this parentId exists, but is defined in the XML file _after_ this object?
                            throw new OdmaRuntimeException("Invalid aspect ("+aspectId+") for class "+c.getId());
                        }
                        aspects.add(aspect);
                    }
                    try
                    {
                        aspectsProperty = new OdmaPropertyImpl(OdmaCommonNames.PROPERTY_ASPECTS,aspects,OdmaType.REFERENCE,true,true);
                        p.put(OdmaCommonNames.PROPERTY_ASPECTS,aspectsProperty);
                    }
                    catch(OdmaInvalidDataTypeException e)
                    {
                        throw new OdmaRuntimeException("Implementation error",e);
                    }
                }
                // register at superClass as subclass or as root aspect
                OdmaClass superClass;
                try
                {
                    superClass = (OdmaClass)superClassProperty.getReference();
                }
                catch(OdmaInvalidDataTypeException e)
                {
                    throw new OdmaRuntimeException("Implementation error",e);
                }
                if(superClass != null)
                {
                    classesHive.registerSubClass(superClass.getQName(),c);
                }
                else
                {
                    classesHive.registerRootAspect(c);
                }
                // register as subclass of all aspects
                Iterable<OdmaClass> aspects;
                try
                {
                    aspects = (Iterable<OdmaClass>)aspectsProperty.getReferenceIterable();
                }
                catch(OdmaInvalidDataTypeException e)
                {
                    throw new OdmaRuntimeException("Implementation error",e);
                }
                if(aspects != null)
                {
                    for(OdmaClass aspect : aspects)
                    {
                        classesHive.registerAspectUsage(aspect.getQName(),c);
                    }
                }
                // test if this class extends OdmaClass, so we need to handle all objects of this class as classes
                boolean extendsClassClass = false;
                OdmaClass test = c;
                HashMap<OdmaQName, Boolean> noLoopTest = new HashMap<OdmaQName, Boolean>();
                while(test != null)
                {
                    noLoopTest.put(test.getQName(),Boolean.TRUE);
                    if(test.getQName().equals(OdmaCommonNames.CLASS_CLASS))
                    {
                        extendsClassClass = true;
                    }
                    test = test.getSuperClass();
                    if((test != null)&&(noLoopTest.containsKey(test.getQName())))
                    {
                        throw new OdmaXmlRepositoryException("Loop in class hierarchy of "+c.getQName());
                    }
                }
                if(extendsClassClass)
                {
                    unevaluatedClassClassesQueue.addLast(c);
                }
            }
        }
        
        // build list of non classes
        for(int i = 0; i < objectDatas.size(); i++)
        {
            // get the object data
            OdmaXmlObjectData od = objectDatas.get(i);
            if(od == null)
                continue;
            // resolve class
            OdmaClass cls = classes.get(od.getClassName());
            if(cls == null)
            {
                throw new OdmaXmlRepositoryException("invalid class name "+od.getClassName());
            }
            // get ID
            OdmaId objectId = od.getId();
            // manually set system controlled properties
            od.setSystemProperties(cls, new OdmaGuid(repoId,objectId), repository);
            // test if this is the repository object
            if(objectId.equals(repoId))
            {
                classesHive.updateRepositoryObject(od.getProperties());
                objectDatas.set(i,null);
                continue;
            }
            // test for duplicated ID
            if(objects.containsKey(objectId))
            {
                if(duplicateIdContinue)
                {
                    System.out.println("Duplicated ID of object: "+objectId);
                    hasDuplicateIds = true;
                }
                else
                {
                    throw new OdmaXmlRepositoryException("Duplicated ID of object: "+objectId);
                }
            }
            OdmaObject o = factoryCreateObject(od, cls);
            objects.put(objectId,o);
            objectDatas.set(i,null);
        }
        
        if(hasDuplicateIds)
        {
            throw new OdmaXmlRepositoryException("Found multiple duplicate IDs");
        }
        
        // resolve IDs to objects
        for(OdmaObject obj : objects.values())
        {
            if(obj instanceof OdmaXmlObject)
            {
                ((OdmaXmlObject)obj).resolveIds(objects);
            }
        }
        OdmaXmlObject.staticResolveIds(classesHive.getRepositoryObjectProperties(),objects);
        
        // build effective properties
        for(int i = 0; i < buildEffectivePropertiesList.size(); i++)
        {
            OdmaXmlClass c = buildEffectivePropertiesList.get(i);
            try
            {
                c.buildProperties();
            }
            catch (OdmaInvalidDataTypeException e)
            {
                throw new OdmaRuntimeException("implementation error",e);
            }
        }
        
        // validate all objects
        for(OdmaObject obj : objects.values())
        {
            if(obj instanceof OdmaXmlObject)
            {
                ((OdmaXmlObject)obj).validateProperties(false,enforceRequired);
            }
        }

    }
    
    protected OdmaObject factoryCreateObject(OdmaXmlObjectData od, OdmaClass cls) throws OdmaXmlRepositoryException
    {
        // test if this object implements OdmaPropertyInfo
        boolean isPropertyInfo = classesHive.isOrIsExtending(cls, OdmaCommonNames.CLASS_PROPERTYINFO);
        if(isPropertyInfo)
        {
            return new OdmaXmlPropertyInfo(od.getProperties());
        }
        else
        {
            // detect implemented OpenDMA aspects
            boolean isAssociation = classesHive.isOrIsExtending(cls, OdmaCommonNames.CLASS_ASSOCIATION);
            boolean isContainable = classesHive.isOrIsExtending(cls, OdmaCommonNames.CLASS_CONTAINABLE);
            boolean isContainer = classesHive.isOrIsExtending(cls, OdmaCommonNames.CLASS_CONTAINER);
            boolean isContentElement = classesHive.isOrIsExtending(cls, OdmaCommonNames.CLASS_CONTENTELEMENT);
            boolean isDocument = classesHive.isOrIsExtending(cls, OdmaCommonNames.CLASS_DOCUMENT);
            boolean isFolder = classesHive.isOrIsExtending(cls, OdmaCommonNames.CLASS_FOLDER);
            boolean isVersionCollection = classesHive.isOrIsExtending(cls, OdmaCommonNames.CLASS_VERSIONCOLLECTION);
            // count number of implemented aspects
            int implementedAspectsCount = 0;
            if(isAssociation)
            {
                implementedAspectsCount++;
            }
            if(isContentElement)
            {
                implementedAspectsCount++;
            }
            if(isDocument)
            {
                implementedAspectsCount++;
            }
            if(isContainable)
            {
                implementedAspectsCount++;
            }
            if(isFolder) // we have to test for Folder before the test for Container
            {
                implementedAspectsCount++;
            }
            else if(isContainer) // there is an elseif here since Folder extends Container. Otherwise we would count Folder twice.
            {
                implementedAspectsCount++;
            }
            if(isVersionCollection)
            {
                implementedAspectsCount++;
            }
            // if there is more than one aspect implemented, generate the full object
            if(implementedAspectsCount > 1)
            {
                return new OdmaXmlFullObject(od.getProperties());
            }
            // there is at most one implemented aspect. Return an aspect specific object
            if(isAssociation)
            {
                return new OdmaXmlAssociation(od.getProperties());
            }
            else if(isContentElement)
            {
                //return new OdmaXmlContentElement(od.getProperties());
                return new OdmaXmlFullObject(od.getProperties());
            }
            else if(isDocument) // we have to test for Folder before the test for Container
            {
                return new OdmaXmlDocument(od.getProperties());
            }
            else if(isContainable)
            {
                return new OdmaXmlContainable(od.getProperties());
            }
            else if(isFolder) // we have to test for Folder before the test for Container
            {
                return new OdmaXmlFolder(od.getProperties());
            }
            else if(isContainer)
            {
                return new OdmaXmlContainer(od.getProperties());
            }
            else if(isVersionCollection)
            {
                return new OdmaXmlVersionCollection(od.getProperties());
            }
            else
            {
                return new OdmaXmlObject(od.getProperties());
            }
        }
    }
    
    protected OdmaXmlClass factoryCreateClass(OdmaXmlObjectData od, OdmaClass cls) throws OdmaXmlRepositoryException
    {
        return new OdmaXmlClass(od.getProperties(),classesHive);
    }
    
    protected OdmaXmlObjectData parseObject(Element objectElement) throws OdmaXmlRepositoryException
    {
        // get odma class name
        String classNamespace = objectElement.getAttribute(ATTRIBUTENAME_CLASSNAMESPACE);
        if( (classNamespace==null) || (classNamespace.length()==0) )
        {
        	// support xml files created by XML exporter prior to 0.7.0
            classNamespace = objectElement.getAttribute(ATTRIBUTENAME_CLASSQUALIFIER_DEPRECATED);
        }
        String className = objectElement.getAttribute(ATTRIBUTENAME_CLASSNAME);
        if( (classNamespace==null) || (classNamespace.length()==0) )
        {
            throw new OdmaXmlRepositoryException("Every OdmaObject element must have a non-empty classNamespace attribute");
        }
        if( (className==null) || (className.length()==0) )
        {
            throw new OdmaXmlRepositoryException("Every OdmaObject element must have a non-empty className attribute");
        }
        // parse all properties
        NodeList objectChilds = objectElement.getChildNodes();
        Map<OdmaQName, OdmaProperty> properties = new HashMap<OdmaQName, OdmaProperty>();
        for (int i = 0; i < objectChilds.getLength(); i++)
        {
            Node child = objectChilds.item(i);
            if(child.getNodeType() == Node.ELEMENT_NODE)
            {
                if(((Element)child).getTagName().equals(ELEMENTNAME_PROPERTY))
                {
                    OdmaProperty prop = parseProperty((Element)child);
                    if(properties.containsKey(prop.getName()))
                    {
                        throw new OdmaXmlRepositoryException("Multiple occurance of property: "+prop.getName());
                    }
                    properties.put(prop.getName(),prop);
                }
            }
        }
        return new OdmaXmlObjectData(new OdmaQName(classNamespace,className),properties);
    }
    
    protected OdmaProperty parseProperty(Element propertyElement) throws OdmaXmlRepositoryException
    {
        // get property name and type
        String attrNamespace = propertyElement.getAttribute(ATTRIBUTENAME_NAMESPACE);
        if( (attrNamespace==null) || (attrNamespace.length()==0) )
        {
            // support xml files created by XML exporter prior to 0.7.0
            attrNamespace = propertyElement.getAttribute(ATTRIBUTENAME_QUALIFIER_DEPRECATED);
        }
        String attrName = propertyElement.getAttribute(ATTRIBUTENAME_NAME);
        String attrType = propertyElement.getAttribute(ATTRIBUTENAME_TYPE);
        String attrMultivalue = propertyElement.getAttribute(ATTRIBUTENAME_MULTIVALUE);
        if( (attrNamespace==null) || (attrNamespace.length()==0) )
        {
            throw new OdmaXmlRepositoryException("Every Property element must have a non-empty qualifier attribute");
        }
        if( (attrName==null) || (attrName.length()==0) )
        {
            throw new OdmaXmlRepositoryException("Every Property element must have a non-empty name attribute");
        }
        if( (attrType==null) || (attrType.length()==0) )
        {
            throw new OdmaXmlRepositoryException("Every Property element must have a non-empty type attribute");
        }
        OdmaType dataType = datatypeValues.get(attrType.toLowerCase());
        if(dataType == null)
        {
            throw new OdmaXmlRepositoryException("The type attribute of every Property must only contain valid data types: "+attrType.toLowerCase());
        }
        // multivalue
        boolean multivalue = false;
        if( (attrMultivalue != null) && (attrMultivalue.length() > 0) )
        {
            if(attrMultivalue.equals("true"))
            {
                multivalue = true;
            }
            else
            {
                if(!attrMultivalue.equals("false"))
                {
                    throw new OdmaXmlRepositoryException("The multivalue attribute of a Property must either contain the value true or the value false");
                }
            }
        }
        // get values
        LinkedList<Object> values = new LinkedList<Object>();
        NodeList propertyChilds = propertyElement.getChildNodes();
        for (int i = 0; i < propertyChilds.getLength(); i++)
        {
            Node child = propertyChilds.item(i);
            if(child.getNodeType() == Node.ELEMENT_NODE)
            {
                if(((Element)child).getTagName().equals(ELEMENTNAME_VALUE))
                {
                    values.add(parseValue((Element)child,dataType));
                }
            }
        }
        // create property
        if(!multivalue)
        {
            if(values.size()==0)
            {
                try
                {
                    return new OdmaPropertyImpl(new OdmaQName(attrNamespace,attrName),null,dataType,false,true);
                }
                catch(OdmaInvalidDataTypeException e)
                {
                    throw new OdmaXmlRepositoryException("Implementation error",e);
                }
            }
            else if(values.size()==1)
            {
                try
                {
                    if(dataType == OdmaType.REFERENCE)
                    {
                        return new UnevaluatedReferenceProperty(new OdmaQName(attrNamespace,attrName),values.get(0),false,true);
                    }
                    else
                    {
                        return new OdmaPropertyImpl(new OdmaQName(attrNamespace,attrName),values.get(0),dataType,false,true);
                    }
                }
                catch(OdmaInvalidDataTypeException e)
                {
                    throw new OdmaXmlRepositoryException("Implementation error",e);
                }
            }
            else
            {
                throw new OdmaXmlRepositoryException("A single valued property must at most contain one value");
            }
        }
        else
        {
            try
            {
                if(dataType == OdmaType.REFERENCE)
                {
                    return new UnevaluatedReferenceProperty(new OdmaQName(attrNamespace,attrName),values,true,true);
                }
                else
                {
                    return new OdmaPropertyImpl(new OdmaQName(attrNamespace,attrName),values,dataType,true,true);
                }
            }
            catch(OdmaInvalidDataTypeException e)
            {
                throw new OdmaXmlRepositoryException("Implementation error",e);
            }
        }
    }
    
    private static final ThreadLocal<SimpleDateFormat> DATETIME_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override protected SimpleDateFormat initialValue() {
            SimpleDateFormat result = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            result.setTimeZone(TimeZone.getTimeZone("UTC"));
            result.setLenient(false);
            return result;
        }
    };

    private static final ThreadLocal<SimpleDateFormat> DATETIME_FORMAT_DEPRECATED = new ThreadLocal<SimpleDateFormat>() {
        @Override protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    
    protected Object parseValue(Element valueElement, OdmaType dataType) throws OdmaXmlRepositoryException
    {
        // Concatenate all text children
        StringBuffer valueSB = new StringBuffer();
        NodeList valueChilds = valueElement.getChildNodes();
        for (int i = 0; i < valueChilds.getLength(); i++)
        {
            Node child = valueChilds.item(i);
            if(child.getNodeType() == Node.TEXT_NODE)
            {
                valueSB.append(child.getNodeValue());
            }
        }
        // convert String to Java object depending on data type
        String s = valueSB.toString();
        switch(dataType)
        {
        case STRING:
            return s;
        case INTEGER:
            try
            {
                return new Integer(Integer.parseInt(s));
            }
            catch(NumberFormatException nfe)
            {
                throw new OdmaXmlRepositoryException("Invalid contents in value element of integer property");
            }
        case SHORT:
            try
            {
                return new Short(Short.parseShort(s));
            }
            catch(NumberFormatException nfe)
            {
                throw new OdmaXmlRepositoryException("Invalid contents in value element of short property");
            }
        case LONG:
            try
            {
                return new Long(Long.parseLong(s));
            }
            catch(NumberFormatException nfe)
            {
                throw new OdmaXmlRepositoryException("Invalid contents in value element of long property");
            }
        case FLOAT:
            try
            {
                return new Float(Float.parseFloat(s));
            }
            catch(NumberFormatException nfe)
            {
                throw new OdmaXmlRepositoryException("Invalid contents in value element of float property");
            }
        case DOUBLE:
            try
            {
                return new Double(Double.parseDouble(s));
            }
            catch(NumberFormatException nfe)
            {
                throw new OdmaXmlRepositoryException("Invalid contents in value element of double property");
            }
        case BOOLEAN:
            if(s.equalsIgnoreCase("true"))
            {
                return Boolean.TRUE;
            }
            else if(s.equalsIgnoreCase("false"))
            {
                return Boolean.FALSE;
            }
            else
            {
                throw new OdmaXmlRepositoryException("Invalid contents in value element of boolean property");
            }
        case DATETIME:
            try
            {
                try
                {
                    return DATETIME_FORMAT.get().parseObject(s);
                }
                catch(ParseException e)
                {
                    return DATETIME_FORMAT_DEPRECATED.get().parseObject(s);
                }
            }
            catch(ParseException e)
            {
                throw new OdmaXmlRepositoryException("Invalid contents in value element of datetime property");
            }
        case BLOB:
            try
            {
                return Base64Coder.decode(s);
            }
            catch(IllegalArgumentException e)
            {
                throw new OdmaXmlRepositoryException("Invalid contents in value element of blob property");
            }
        case REFERENCE:
            return new OdmaId(s);
        case CONTENT:
            return new OdmaXmlFileContent(s);
        case ID:
            return new OdmaId(s);
        default:
            throw new OdmaXmlRepositoryException("Implementation error: unknown data type");
        }
    }

}
