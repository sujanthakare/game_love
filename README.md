# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.0/maven-plugin/reference/html/#build-image)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

## Running the application

To run the application, you can use the following command:

```bash
mvn spring-boot:run
```

This will start the application in the development profile and listen on port 8080.
You can access the application in your web browser by navigating to `http://localhost:8080`.

## Building the application

To build the application, you can use the following command:

```bash
mvn clean package
```

This will create a JAR file in the `target` directory with the name `demo-0.0.1-SNAPSHOT.jar`.
You can then run the JAR file using the `java` command:

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

## Deploying the application

To deploy the application, you can use the following command:

```bash
mvn clean package spring-boot:build-image
```
This will create a Docker image with the name `demo:0.0.1-SNAPSHOT`.

## Api Documentation

Swagger UI is available at `http://localhost:8080/swagger-ui.html`

## Database

For development, a Sqlite database is used. The database is created automatically when the application starts.

The database file is located at `./game_love.db`.