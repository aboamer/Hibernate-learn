## What is this for
This is a simple hibernate config connecting to mysql DB without using spring.

## Development
- Create a static session factory from hibernate configuration class.
- open a session from session factory instance.
- create a transaction from a session.
- session wraps a jdbc connection. it is short-lived unlike session factory.
- ### cascading
  - don't use cascade on all cases.
- ### Relations
  - it is a good practice to encapsulate adding a child to a parent entity inside the parent entity.


## issues faced
### hibernate not running on java 9 --> 11
- The JAXB APIs are considered to be Java EE APIs and therefore are no longer contained on the default classpath in Java SE 9. 
- In Java 11, they are completely removed from the JDK.
- you need to add jakarta.xml.bind-api and jaxb-runtime to maven.
- [resource](https://stackoverflow.com/questions/43574426/how-to-resolve-java-lang-noclassdeffounderror-javax-xml-bind-jaxbexception)
### No default constructor for entity
- Should have no args constructor to retrieve entity in another transaction.
- all args constructor is needed if you want to annotate entity with builder.
### Compatibilities
- Spring 5 -- hibernate validator 6.X
- Jakarta 9 -- hibernate validator 7.X
- hibernate validator 6.2 has the same features as 7
