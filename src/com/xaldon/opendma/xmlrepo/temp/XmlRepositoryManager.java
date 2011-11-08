package com.xaldon.opendma.xmlrepo.temp;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.opendma.OdmaTypes;
import org.opendma.api.OdmaClass;
import org.opendma.api.OdmaGuid;
import org.opendma.api.OdmaId;
import org.opendma.api.OdmaObject;
import org.opendma.api.OdmaProperty;
import org.opendma.api.OdmaQName;
import org.opendma.api.OdmaRepository;
import org.opendma.api.collections.OdmaClassEnumeration;
import org.opendma.api.collections.OdmaIdList;
import org.opendma.exceptions.OdmaAccessDeniedException;
import org.opendma.exceptions.OdmaInvalidDataTypeException;
import org.opendma.exceptions.OdmaObjectNotFoundException;
import org.opendma.exceptions.OdmaRuntimeException;
import org.opendma.impl.OdmaPropertyImpl;
import org.opendma.impl.collections.ArrayBlobList;
import org.opendma.impl.collections.ArrayBooleanList;
import org.opendma.impl.collections.ArrayDateTimeList;
import org.opendma.impl.collections.ArrayDoubleList;
import org.opendma.impl.collections.ArrayFloatList;
import org.opendma.impl.collections.ArrayIntegerList;
import org.opendma.impl.collections.ArrayLongList;
import org.opendma.impl.collections.ArrayOdmaContentList;
import org.opendma.impl.collections.ArrayOdmaIdList;
import org.opendma.impl.collections.ArrayShortList;
import org.opendma.impl.collections.ArrayStringList;
import org.opendma.impl.core.OdmaStaticClassHierarchy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.xaldon.opendma.xmlrepo.exceptions.OdmaXmlRepositoryException;

public class XmlRepositoryManager
{
    
    protected HashMap<String, OdmaObject> objects = new HashMap<String, OdmaObject>();
    
    protected HashMap<OdmaQName, OdmaClass> classes = new HashMap<OdmaQName, OdmaClass>();
    
    protected OdmaRepository repository;
    
    public OdmaRepository getRepository()
    {
        return repository;
    }
    
    protected boolean enforceRequired = false;

    public XmlRepositoryManager(InputStream in, String user, String password, boolean enforceRequired) throws OdmaXmlRepositoryException
    {
        this.enforceRequired = enforceRequired;
        Document descriptionDocument;
        try
        {
            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            descriptionDocument = docBuilder.parse(in);
            in.close();
        }
        catch(ParserConfigurationException e)
        {
            throw new OdmaXmlRepositoryException("Error reading input XML file",e);
        }
        catch(FactoryConfigurationError e)
        {
            throw new OdmaXmlRepositoryException("Error reading input XML file",e);
        }
        catch(SAXException e)
        {
            throw new OdmaXmlRepositoryException("Error reading input XML file",e);
        }
        catch(IOException e)
        {
            throw new OdmaXmlRepositoryException("Error reading input XML file",e);
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
    
    public static final String ATTRIBUTENAME_CLASSQUALIFIER = "classQualifier";
    
    public static final String ATTRIBUTENAME_CLASSNAME = "className";
    
    public static final String ATTRIBUTENAME_QUALIFIER = "qualifier";
    
    public static final String ATTRIBUTENAME_NAME = "name";
    
    public static final String ATTRIBUTENAME_TYPE = "type";
    
    public static final String ATTRIBUTENAME_MULTIVALUE = "multiValue";

    protected static Map<String, Integer> datatypeValues = new HashMap<String, Integer>();
    
    static
    {
        datatypeValues.put("string",new Integer(1));
        datatypeValues.put("integer",new Integer(2));
        datatypeValues.put("short",new Integer(3));
        datatypeValues.put("long",new Integer(4));
        datatypeValues.put("float",new Integer(5));
        datatypeValues.put("double",new Integer(6));
        datatypeValues.put("boolean",new Integer(7));
        datatypeValues.put("datetime",new Integer(8));
        datatypeValues.put("blob",new Integer(9));
        datatypeValues.put("reference",new Integer(10));
        datatypeValues.put("content",new Integer(11));
        datatypeValues.put("id",new Integer(100));
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
        OdmaObject obj = objects.get(id.toString());
        if(obj == null)
        {
            throw new OdmaObjectNotFoundException(id);
        }
        return obj;
    }
    
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
        unevaluatedClassClassesQueue.add(classesHive.getClassInfo(OdmaTypes.CLASS_CLASS));
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
                    OdmaProperty propNameQualifier = od.getProperties().get(OdmaTypes.PROPERTY_NAMEQUALIFIER);
                    OdmaProperty propName = od.getProperties().get(OdmaTypes.PROPERTY_NAME);
                    OdmaProperty propParent = od.getProperties().get(OdmaTypes.PROPERTY_PARENT);
                    if( (propNameQualifier!=null) && (propName!=null) && (propParent != null) )
                    {
                        try
                        {
                            String nameQualifier = propNameQualifier.getString();
                            String name = propName.getString();
                            OdmaId parent = propParent.getId();
                            if(od.getClassName().equals(new OdmaQName(nameQualifier,name)) && (parent.equals(classClass.getId())))
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
                    if(objects.containsKey(classId.toString()))
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
                    objects.put(classId.toString(),c);
                    classes.put(c.getQName(),c);
                    objectDatas.set(i,null);
                }
            }
            for(int i = 0; i < classPostProcessing.size(); i++)
            {
                OdmaXmlClass c = (OdmaXmlClass)classPostProcessing.get(i);
                Map<OdmaQName, OdmaProperty> p = c.getInternalProperties();
                // resolve parent from ID to instance
                OdmaPropertyImpl parentProperty = (OdmaPropertyImpl)p.get(OdmaTypes.PROPERTY_PARENT);
                if(parentProperty instanceof UnevaluatedReferenceProperty)
                {
                    OdmaId parentId;
                    try
                    {
                        parentId = parentProperty.getId();
                    }
                    catch(OdmaInvalidDataTypeException e1)
                    {
                        throw new OdmaXmlRepositoryException("Implementation error",e1);
                    }
                    OdmaClass parent = (OdmaClass)objects.get(parentId.toString());
                    if(parent == null)
                    {
                        throw new OdmaRuntimeException("Invalid parent ("+parentId+") for class "+c.getId());
                    }
                    try
                    {
                        parentProperty = new OdmaPropertyImpl(OdmaTypes.PROPERTY_PARENT,parent,OdmaTypes.TYPE_REFERENCE,false,true);
                        p.put(OdmaTypes.PROPERTY_PARENT,parentProperty);
                    }
                    catch(OdmaInvalidDataTypeException e)
                    {
                        throw new OdmaRuntimeException("Implementation error",e);
                    }
                }
                // resolve aspects from ID to instance
                OdmaPropertyImpl aspectsProperty = (OdmaPropertyImpl)p.get(OdmaTypes.PROPERTY_ASPECTS);
                if(aspectsProperty instanceof UnevaluatedReferenceProperty)
                {
                    OdmaIdList aspetIds;
                    try
                    {
                        aspetIds = aspectsProperty.getIdList();
                    }
                    catch(OdmaInvalidDataTypeException e1)
                    {
                        throw new OdmaXmlRepositoryException("Implementation error",e1);
                    }
                    OdmaXmlMultipleObjectEnumeration aspects = new OdmaXmlMultipleObjectEnumeration();
                    Iterator<?> itAspectIds = aspetIds.iterator();
                    while(itAspectIds.hasNext())
                    {
                        OdmaId aspectId = (OdmaId)itAspectIds.next();
                        OdmaClass aspect = (OdmaClass)objects.get(aspectId.toString());
                        if(aspect == null)
                        {
                            throw new OdmaRuntimeException("Invalid aspect ("+aspectId+") for class "+c.getId());
                        }
                        aspects.add(aspect);
                    }
                    try
                    {
                        aspectsProperty = new OdmaPropertyImpl(OdmaTypes.PROPERTY_ASPECTS,aspects,OdmaTypes.TYPE_REFERENCE,true,true);
                        p.put(OdmaTypes.PROPERTY_ASPECTS,aspectsProperty);
                    }
                    catch(OdmaInvalidDataTypeException e)
                    {
                        throw new OdmaRuntimeException("Implementation error",e);
                    }
                }
                // register at parent as subclass or as root aspect
                OdmaClass parent;
                try
                {
                    parent = (OdmaClass)parentProperty.getReference();
                }
                catch(OdmaInvalidDataTypeException e)
                {
                    throw new OdmaRuntimeException("Implementation error",e);
                }
                if(parent != null)
                {
                    classesHive.registerSubClass(parent.getQName(),c);
                }
                else
                {
                    classesHive.registerRootAspect(c);
                }
                // register as subclass of all aspects
                OdmaClassEnumeration aspects;
                try
                {
                    aspects = (OdmaClassEnumeration)aspectsProperty.getReferenceEnumeration();
                }
                catch(OdmaInvalidDataTypeException e)
                {
                    throw new OdmaRuntimeException("Implementation error",e);
                }
                if(aspects != null)
                {
                    Iterator<?> itAspects = aspects.iterator();
                    while(itAspects.hasNext())
                    {
                        OdmaClass aspect = (OdmaClass)itAspects.next();
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
                    if(test.getQName().equals(OdmaTypes.CLASS_CLASS))
                    {
                        extendsClassClass = true;
                    }
                    test = test.getParent();
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
            OdmaXmlObjectData od = (OdmaXmlObjectData)objectDatas.get(i);
            if(od == null)
                continue;
            // resolve class
            OdmaClass cls = (OdmaClass)classes.get(od.getClassName());
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
            if(objects.containsKey(objectId.toString()))
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
            objects.put(objectId.toString(),o);
            objectDatas.set(i,null);
        }
        
        if(hasDuplicateIds)
        {
            throw new OdmaXmlRepositoryException("Found multiple duplicate IDs");
        }
        
        // resolve IDs to objects
        Iterator<OdmaObject> it = objects.values().iterator();
        while(it.hasNext())
        {
            OdmaObject o = it.next();
            if(o instanceof OdmaXmlObject)
            {
                ((OdmaXmlObject)o).resolveIds(objects);
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
        Iterator<OdmaObject> itAllObjects = objects.values().iterator();
        while(itAllObjects.hasNext())
        {
            OdmaObject o = (OdmaObject)itAllObjects.next();
            if(o instanceof OdmaXmlObject)
            {
                ((OdmaXmlObject)o).validateProperties(false,enforceRequired);
            }
        }

    }
    
    protected OdmaObject factoryCreateObject(OdmaXmlObjectData od, OdmaClass cls) throws OdmaXmlRepositoryException
    {
        // test if this object implements OdmaPropertyInfo
        boolean isPropertyInfo = classesHive.isOrIsExtending(cls, OdmaTypes.CLASS_PROPERTYINFO);
        if(isPropertyInfo)
        {
            return new OdmaXmlPropertyInfo(od.getProperties());
        }
        else
        {
            // detect implemented OpenDMA aspects
            boolean isAssociation = classesHive.isOrIsExtending(cls, OdmaTypes.CLASS_ASSOCIATION);
            boolean isContainable = classesHive.isOrIsExtending(cls, OdmaTypes.CLASS_CONTAINABLE);
            boolean isContainer = classesHive.isOrIsExtending(cls, OdmaTypes.CLASS_CONTAINER);
            boolean isContentElement = classesHive.isOrIsExtending(cls, OdmaTypes.CLASS_CONTENTELEMENT);
            boolean isDocument = classesHive.isOrIsExtending(cls, OdmaTypes.CLASS_DOCUMENT);
            boolean isFolder = classesHive.isOrIsExtending(cls, OdmaTypes.CLASS_FOLDER);
            boolean isVersionCollection = classesHive.isOrIsExtending(cls, OdmaTypes.CLASS_VERSIONCOLLECTION);
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
        String classQualifier = objectElement.getAttribute(ATTRIBUTENAME_CLASSQUALIFIER);
        String className = objectElement.getAttribute(ATTRIBUTENAME_CLASSNAME);
        if( (classQualifier==null) || (classQualifier.length()==0) )
        {
            throw new OdmaXmlRepositoryException("Every OdmaObject element must have a non-empty classQualifier attribute");
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
        return new OdmaXmlObjectData(new OdmaQName(classQualifier,className),properties);
    }
    
    protected OdmaProperty parseProperty(Element propertyElement) throws OdmaXmlRepositoryException
    {
        // get property name and type
        String attrQualifier = propertyElement.getAttribute(ATTRIBUTENAME_QUALIFIER);
        String attrName = propertyElement.getAttribute(ATTRIBUTENAME_NAME);
        String attrType = propertyElement.getAttribute(ATTRIBUTENAME_TYPE);
        String attrMultivalue = propertyElement.getAttribute(ATTRIBUTENAME_MULTIVALUE);
        if( (attrQualifier==null) || (attrQualifier.length()==0) )
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
        Integer dataTypeObj = (Integer)datatypeValues.get(attrType.toLowerCase());
        if(dataTypeObj == null)
        {
            throw new OdmaXmlRepositoryException("The type attribute of every Property must only contain valid data types: "+attrType.toLowerCase());
        }
        int dataType = dataTypeObj.intValue();
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
        List values = (dataType == OdmaTypes.TYPE_REFERENCE) ? factoryCreateList(OdmaTypes.TYPE_ID) : factoryCreateList(dataType);
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
                    return new OdmaPropertyImpl(new OdmaQName(attrQualifier,attrName),null,dataType,false,true);
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
                    if(dataType == OdmaTypes.TYPE_REFERENCE)
                    {
                        return new UnevaluatedReferenceProperty(new OdmaQName(attrQualifier,attrName),values.get(0),false,true);
                    }
                    else
                    {
                        return new OdmaPropertyImpl(new OdmaQName(attrQualifier,attrName),values.get(0),dataType,false,true);
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
                if(values.size()==0)
                {
                    return new OdmaPropertyImpl(new OdmaQName(attrQualifier,attrName),null,dataType,true,true);
                }
                else
                {
                    if(dataType == OdmaTypes.TYPE_REFERENCE)
                    {
                        return new UnevaluatedReferenceProperty(new OdmaQName(attrQualifier,attrName),values,true,true);
                    }
                    else
                    {
                        return new OdmaPropertyImpl(new OdmaQName(attrQualifier,attrName),values,dataType,true,true);
                    }
                }
            }
            catch(OdmaInvalidDataTypeException e)
            {
                throw new OdmaXmlRepositoryException("Implementation error",e);
            }
        }
    }
    
    protected List factoryCreateList(int dataType) throws OdmaXmlRepositoryException
    {
        switch(dataType)
        {
        case OdmaTypes.TYPE_STRING:
            return new ArrayStringList();
        case OdmaTypes.TYPE_INTEGER:
            return new ArrayIntegerList();
        case OdmaTypes.TYPE_SHORT:
            return new ArrayShortList();
        case OdmaTypes.TYPE_LONG:
            return new ArrayLongList();
        case OdmaTypes.TYPE_FLOAT:
            return new ArrayFloatList();
        case OdmaTypes.TYPE_DOUBLE:
            return new ArrayDoubleList();
        case OdmaTypes.TYPE_BOOLEAN:
            return new ArrayBooleanList();
        case OdmaTypes.TYPE_DATETIME:
            return new ArrayDateTimeList();
        case OdmaTypes.TYPE_BLOB:
            return new ArrayBlobList();
        case OdmaTypes.TYPE_REFERENCE:
            return new OdmaXmlMultipleObjectEnumeration();
        case OdmaTypes.TYPE_CONTENT:
            return new ArrayOdmaContentList();
        case OdmaTypes.TYPE_ID:
            return new ArrayOdmaIdList();
        default:
            throw new OdmaXmlRepositoryException("Implementation error: unknown data type");
        }
    }
    
    protected static DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    protected Object parseValue(Element valueElement, int dataType) throws OdmaXmlRepositoryException
    {
        // Concatenate all text childs
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
        // interprete String depending on data type
        String s = valueSB.toString();
        switch(dataType)
        {
        case OdmaTypes.TYPE_STRING:
            return s;
        case OdmaTypes.TYPE_INTEGER:
            try
            {
                return new Integer(Integer.parseInt(s));
            }
            catch(NumberFormatException nfe)
            {
                throw new OdmaXmlRepositoryException("Invalid contents in value element of integer property");
            }
        case OdmaTypes.TYPE_SHORT:
            try
            {
                return new Short(Short.parseShort(s));
            }
            catch(NumberFormatException nfe)
            {
                throw new OdmaXmlRepositoryException("Invalid contents in value element of short property");
            }
        case OdmaTypes.TYPE_LONG:
            try
            {
                return new Long(Long.parseLong(s));
            }
            catch(NumberFormatException nfe)
            {
                throw new OdmaXmlRepositoryException("Invalid contents in value element of long property");
            }
        case OdmaTypes.TYPE_FLOAT:
            try
            {
                return new Float(Float.parseFloat(s));
            }
            catch(NumberFormatException nfe)
            {
                throw new OdmaXmlRepositoryException("Invalid contents in value element of float property");
            }
        case OdmaTypes.TYPE_DOUBLE:
            try
            {
                return new Double(Double.parseDouble(s));
            }
            catch(NumberFormatException nfe)
            {
                throw new OdmaXmlRepositoryException("Invalid contents in value element of double property");
            }
        case OdmaTypes.TYPE_BOOLEAN:
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
        case OdmaTypes.TYPE_DATETIME:
            try
            {
                return dateTimeFormat.parseObject(s);
            }
            catch(ParseException e)
            {
                throw new OdmaXmlRepositoryException("Invalid contents in value element of datetime property");
            }
        case OdmaTypes.TYPE_BLOB:
            try
            {
                return Base64Coder.decode(s);
            }
            catch(IllegalArgumentException e)
            {
                throw new OdmaXmlRepositoryException("Invalid contents in value element of blob property");
            }
        case OdmaTypes.TYPE_REFERENCE:
            return new OdmaId(s);
        case OdmaTypes.TYPE_CONTENT:
            return new OdmaXmlFileContent(s);
        case OdmaTypes.TYPE_ID:
            return new OdmaId(s);
        default:
            throw new OdmaXmlRepositoryException("Implementation error: unknown data type");
        }
    }

}
