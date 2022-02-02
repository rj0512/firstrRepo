Tools & libraries
==================================================================================

The test automation framework is comprised of following tools and libraries

Selenium WebDriver: - Browser automation framework  
JAVA: - Programming language  
TestNg: - TestNg Java testing framework  
Maven: - Build tool
Intellij Or Eclipse: - Integrated Development Environment  
Loggers: - Log4J
Reporting tool:- Extent Manger

Framework Setup steps
==================================================================================

Download folder archtype from https://drive.google.com/drive/folders/1n-BUbqM3ycxyM9I-jJx9JyiplLHQJ-9C?usp=sharing

Now open terminal  and  navigate to downloaded  folder and  execute command “mvn clean install” This will add your local archetype into the local maven repository. You can see the build log for a message that mentions about this addition.

Checking for local maven archetypes

Navigate your ~/.m2/repository/ and check the archetype-catalog.xml file. If the new archetype is added it will show the groupId, artifactId and version of it. Below is an example of a newly added archetype



archetype-catalog.xml file

<?xml version="1.0" encoding="UTF-8"?>
<archetype-catalog xsi:schemaLocation="http://maven.apache.org/plugins/maven-archetype-plugin/archetype-catalog/1.0.0 http://maven.apache.org/xsd/archetype-catalog-1.0.0.xsd"
xmlns="http://maven.apache.org/plugins/maven-archetype-plugin/archetype-catalog/1.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
<archetypes>
<archetype>
<groupId>org.mobiquity.automation</groupId>
<artifactId>mobiquityAutomationFramework-archetype</artifactId>
<version>1.0-SNAPSHOT</version>
<description>mobiquityAutomationFramework-archetype</description>
</archetype>
</archetypes>
</archetype-catalog>



4.  Create your folder, navigate to folder in terminal and execute

mvn archetype:generate -DarchetypeGroupId=org.mobiquity.automation -DarchetypeArtifactId=mobiquityAutomationFramework-archetype  -DarchetypeVersion=1.0-SNAPSHOT -DgroupId=<your group id> -DartifactId=<your artifactid> -Dversion=<version>
Congrats Project Setup is done !!!

Run automation on Web
==================================================================================

Execute below command

mvn test
-Dbrowser=chrome  [chrome,firefox]
