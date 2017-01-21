Steps:
run the diff that will generate the file datetime_changelog.xml:
> mvn liquibase:diff

edit master.xml to add the file: datetime_changelog.xml then run:
> mvn liquibase:update



-------------- not important -------------------------
H-Liqui:
hibernate:spring:com.equinooxe.domain?dialect=org.hibernate.dialect.MySQL5Dialect

Run:
 mvn liquibase --changeLogFile=changelog.xml --url=hibernate:spring:com.equinooxe.domain?dialect=org.hibernate.dialect.MySQL5Dialect diffChangeLog 
 
mvn liquibase:update --changeLogFile=src/main/resources/config/liquibase/changelog/20170121041023_changelog.xml