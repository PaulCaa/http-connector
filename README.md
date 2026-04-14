# http-connector
Java library to call REST APIs by http protocol

## Changelog

#### Version 1.0.0
    - Commons lib updated
    - Base code corrections and refactor

#### Version 0.3
    - General refactor
    - Modularized proccess in service
    - Add RequestUtils that contains method required by service
    - Validations and exceptions added
    - Removed unnecesary dependencies 

#### Version 0.2
    - Base implementation
    - Commons-lib integration

## How to import

### Making package from source code

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
        <version>1.0.0-SNAPSHOT</version>
    </dependency>
```

4. Refresh maven dependencies in the project implemented.

### Importing to Maven  from jar

1. Download `http-connector-1.0.0-SNAPSHOT.jar`
2. Located in folder where are jar file execute the command:

```bash
    $ mvn install:install-file -Dfile=http-connector-1.0.0-SNAPSHOT.jar -DgroupId=ar.com.pablocaamano -DartifactId=http-connector -Dversion=0.3-SNAPSHOT -Dpackaging=jar
```

3. Add dependency in `pom.xml` of your project:

```xml
    <dependency>
        <groupId>ar.com.pablocaamano</groupId>
        <artifactId>http-connector</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </dependency>
```

4. Refresh maven dependencies in the project implemented.

## External dependencies

Other dependencies necessaries to make workspace:

### commons-library

```xml
    <dependency>
        <groupId>ar.com.pablocaamano</groupId>
        <artifactId>commons-library</artifactId>
        <version>1.5.0-SNAPSHOT</version>
    </dependency>
```