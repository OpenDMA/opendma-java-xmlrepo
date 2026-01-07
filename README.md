# OpenDMA XML Repository

OpenDMA Adaptor reading objects from an XML file.

## Usage

This project is available on Maven Central. Add the following dependency to your Maven project:
```
    <dependencies>
        <dependency>
            <groupId>org.opendma</groupId>
            <artifactId>opendma-xmlrepo</artifactId>
            <version>0.8</version>
        </dependency>
    </dependencies>
```

This adaptor supports both, getting a session via a session provider:
```java
// instantiate and configure OdmaSessionProvider
XmlRepositorySessionProvider sessionProvider = new XmlRepositorySessionProvider();
sessionProvider.setClasspathResource("SampleRepository.xml");
OdmaSession session = sessionProvider.getSession();
```
...or getting a session from the adaptor:
```java
// instantiate a new OdmaAdaptorDiscovery and try to find a suitable adaptor
OdmaAdaptorDiscovery adaptorDiscovery = new OdmaAdaptorDiscovery();
OdmaAdaptor xmlRepoAdaptor = adaptorDiscovery.getAdaptor("xmlrepo");
// get session
Properties prop = new Properties();
prop.put("classpathResource", "SampleRepository.xml");
OdmaSession session = xmlRepoAdaptor.connect(prop);
```

Once you have a session, you can retrieve objects:
```java
OdmaId repoId = new OdmaId("sample-repo");
OdmaRepository repo = session.getRepository(repoId);
System.out.println(repo.getDisplayName());
```

There is also a complete [OpenDMA Tutorial for Java](https://github.com/OpenDMA/opendma-java-tutorial)
showing the basic concepts with the XML Repository.

## Connection parameters

The adaptor supports the following connection parameters:

`filename`  
path to local xml file

`classpathResource`  
absolute path of a xml resource on the classpath

`enforceRequired`  
boolean flag (`true` or `false`) to fail on missing mandatory properties (default `false`)

## File format

OpenDMA objects are stored as `OdmaObject` elements with a list of `Property` child elements:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<OdmaXmlRepository repositoryId="sample-repo" repositoryObjectId="sample-repo-object">

  <OdmaObject classNamespace="tutorial" className="SampleRepositoryClass">
    <Property qualifier="opendma" name="Id" type="id"><Value>sample-repo-object</Value></Property>
    <Property qualifier="opendma" name="Aspects" type="reference"></Property>
    <Property qualifier="opendma" name="Name" type="string"><Value>SampleRepository</Value></Property>
    <Property qualifier="opendma" name="DisplayName" type="string"><Value>Sample Repository for Tutorials</Value></Property>
    <Property qualifier="opendma" name="RootFolder" type="reference"><Value>sample-folder-root</Value></Property>
    <Property qualifier="tutorial" name="RepositoryName" type="string"><Value>SampleRepository</Value></Property>
    <Property qualifier="tutorial" name="SampleString" type="string"><Value>Some sample string value</Value></Property>
    <Property qualifier="tutorial" name="SampleInteger" type="integer"><Value>123</Value></Property>
  </OdmaObject>

</OdmaXmlRepository>
```

Each `Property` contains a list of `Value` elements. Multi valued properties can
contain multiple values:
```xml
<Property qualifier="opendma" name="DeclaredProperties" type="reference" multiValue="true">
  <Value>sample-repo-name</Value>
  <Value>sample-repo-string</Value>
  <Value>sample-repo-integer</Value>
</Property>
```