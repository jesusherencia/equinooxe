

SET appServerLocation=C:\Users\mboullouz\Documents\equinooxe
SET appServerLocationTarget=C:\Users\mboullouz\Documents\equinooxe\target
SET tomcatAppFolder=C:\tomcat\webapps
SET tomcatBinFolder=C:\tomcat\bin
SET destFolderAndName=%tomcatAppFolder%\equinooxe.war
ECHO server folder %appServerLocation%
cd %appServerLocation%

ECHO "lunch mvn package"
call mvn package

 
ECHO copie to %destFolderAndName%
cd %appServerLocationTarget%
xcopy /f /y *.war %destFolderAndName%  
cd %tomcatBinFolder%
call shutdown.bat
call startup.bat

ECHO ".................................."
ECHO "............We are done..........."
ECHO "............Enjoy because those moments of calm are rare!..........."
ECHO ".................................."
