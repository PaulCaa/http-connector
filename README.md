# http-connector
Java library to call REST APIs by http protocol.

## How to import

**Making package from source code**

1. Clone or download this project
2. Located in root folder execute the command:

```bash
    $ mvn clean install
```

3. Add dependency in `pom.xml` of your project:

```xml
    <dependency>
        <groupId>ar.com.pablocaamano</groupId>
        <artifactId>http-connector</artifactId>
        <version>0.4-SNAPSHOT</version>
    </dependency>
```

4. Refresh maven dependencies in the project implemented.

**Importing to Maven  from jar**

1. Download `http-connector-0.4-SNAPSHOT.jar`
2. Located in folder where are jar file execute the command:

```bash
    $ mvn install:install-file -Dfile=http-connector-0.4-SNAPSHOT.jar -DgroupId=ar.com.pablocaamano -DartifactId=http-connector -Dversion=0.4-SNAPSHOT -Dpackaging=jar
```

3. Add dependency in `pom.xml` of your project:

```xml
    <dependency>
        <groupId>ar.com.pablocaamano</groupId>
        <artifactId>http-connector</artifactId>
        <version>0.4-SNAPSHOT</version>
    </dependency>
```

4. Refresh maven dependencies in the project implemented.

**Importing with external library**
