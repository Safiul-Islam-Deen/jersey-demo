# jersey-demo

A simple Jersey (JAX-RS) RESTful web service demo application using embedded Grizzly HTTP server.

## Features

- RESTful API endpoints using Jersey 3.x
- Embedded Grizzly HTTP server
- JSON support with Jackson
- Maven build system
- JUnit tests with Jersey Test Framework

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

## Build

To build the project:

```bash
mvn clean package
```

## Run

To run the application:

```bash
mvn exec:java -Dexec.mainClass="com.example.jersey.Main"
```

Or run the packaged JAR:

```bash
java -jar target/jersey-demo-1.0-SNAPSHOT.jar
```

The server will start on `http://localhost:8080/api/`

## Test

To run the tests:

```bash
mvn test
```

## API Endpoints

Once the application is running, you can access the following endpoints:

- **GET** `/api/hello` - Returns a simple greeting message
  ```bash
  curl http://localhost:8080/api/hello
  ```
  Response: `Hello, Jersey!`

- **GET** `/api/hello/{name}` - Returns a personalized greeting
  ```bash
  curl http://localhost:8080/api/hello/John
  ```
  Response: `Hello, John!`

- **GET** `/api/hello/greet?name={name}` - Returns a JSON greeting message
  ```bash
  curl http://localhost:8080/api/hello/greet?name=World
  ```
  Response: `{"message":"Hello, World!"}`

## Project Structure

```
jersey-demo/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               └── jersey/
│   │                   ├── Main.java          # Application entry point
│   │                   └── HelloResource.java # REST resource
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── jersey/
│                       └── HelloResourceTest.java # Tests
├── pom.xml              # Maven configuration
└── README.md            # This file
```

## Technologies Used

- **Jersey 3.1.3** - JAX-RS Reference Implementation
- **Grizzly 4.0.0** - Embedded HTTP Server
- **Jackson** - JSON Processing
- **JUnit 4** - Testing Framework 
