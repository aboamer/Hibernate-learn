## What is this for
This is a simple hibernate config connecting to mysql DB without using spring.

## Development
- Create a static session factory from hibernate configuration class.
- open a session from session factory instance.
- create a transaction from a session.

### issues faced
- The JAXB APIs are considered to be Java EE APIs and therefore are no longer contained on the default classpath in Java SE 9. 
- In Java 11, they are completely removed from the JDK.
- you need to add jakarta.xml.bind-api and jaxb-runtime to maven.
- [resource](https://stackoverflow.com/questions/43574426/how-to-resolve-java-lang-noclassdeffounderror-javax-xml-bind-jaxbexception)
