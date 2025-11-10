mvn -pl . clean install & ^
mvn -pl helloworld-sdk clean install & ^
mvn -pl helloworld-admin-plugin clean install -Pexport,\!test & ^
mvn -pl helloworld-socket-plugin clean install -Pexport,\!test & ^
mvn -pl helloworld-socket-app clean install -Pexport,\!test & ^
mvn -pl helloworld-web-plugin clean install -Pexport,\!test & ^
mvn -pl helloworld-theme clean install -Pexport,\!test & ^
ezy.bat package & ^
ezy.bat export
