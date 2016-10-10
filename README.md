# equinooxe
Application initial

This is a web app<br/>

- Security is based on Shiro
- Rest is based on Jersey
- ORM is based JPA, Hibernate impl

DB is Mysql by default, to use another one change the driver in pom.xml<br/>
To change the database connection parameters change them in persistence.xml<br/>

To create a war package execute: <b>mvn package</b><br/>
Deploy the war created in the /target directory into a web server like Tomcat
