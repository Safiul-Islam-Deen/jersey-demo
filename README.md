# jersey-demo

A simple Jersey REST API demonstration project for managing user profile settings.

## Overview

This project demonstrates how to build a RESTful web service using Jersey (JAX-RS implementation) with user profile settings management functionality.

## Features

- RESTful API for user profile management
- CRUD operations (Create, Read, Update, Delete)
- JSON request/response handling
- In-memory data storage for demo purposes
- Simple web interface

## Technologies Used

- Java 11
- Jersey 2.35 (JAX-RS implementation)
- Maven
- Jackson for JSON processing
- Servlet API 4.0

## Project Structure

```
jersey-demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/jersey/demo/
│   │   │       ├── config/       # Application configuration
│   │   │       ├── model/        # Data models
│   │   │       └── resource/     # REST endpoints
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── web.xml       # Web application configuration
│   │       └── index.html        # Welcome page
│   └── test/
└── pom.xml                       # Maven configuration
```

## Building the Project

```bash
mvn clean package
```

This will create a WAR file in the `target/` directory.

## Deploying

Deploy the generated `jersey-demo.war` file to any Java servlet container (e.g., Tomcat, Jetty).

## API Endpoints

### Health Check
- **GET** `/api/users/health` - Check if the service is running

### User Profile Operations
- **GET** `/api/users` - Get all user profiles
- **GET** `/api/users/{userId}/profile` - Get a specific user profile
- **POST** `/api/users/{userId}/profile` - Create or replace a user profile
- **PUT** `/api/users/{userId}/profile` - Update user profile settings
- **DELETE** `/api/users/{userId}/profile` - Delete a user profile

## Example Requests

### Get User Profile
```bash
curl http://localhost:8080/jersey-demo/api/users/1/profile
```

### Update User Settings
```bash
curl -X PUT http://localhost:8080/jersey-demo/api/users/1/profile \
  -H "Content-Type: application/json" \
  -d '{"displayName": "John Smith", "theme": "dark", "notificationsEnabled": true}'
```

### Create New Profile
```bash
curl -X POST http://localhost:8080/jersey-demo/api/users/3/profile \
  -H "Content-Type: application/json" \
  -d '{"username": "newuser", "email": "new@example.com", "displayName": "New User", "theme": "light", "notificationsEnabled": false}'
```

## Sample Data

The application comes pre-loaded with two sample user profiles:
- User ID 1: johndoe
- User ID 2: janedoe

## Development

To extend this demo:
1. Add persistent storage (database integration)
2. Implement authentication and authorization
3. Add input validation
4. Add unit and integration tests
5. Add more user profile fields as needed

## License

This is a demo project for educational purposes. 
