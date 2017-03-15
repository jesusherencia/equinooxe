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

**** Add the first user ********
#Run:
INSERT INTO `equinooxe`.`authority` (`name`) VALUES ('ROLE_ADMIN'), ('ROLE_USER');
#Go to the interface register a user then:
UPDATE `user` SET  `activated` = 1 where id = 1
UPDATE `equinooxe`.`user` SET `user_type` = 'MANAGER' WHERE `user`.`id` = 1;

**************************************

Generate source for queryDSL:
>generate-sources