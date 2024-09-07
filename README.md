
# Demo Spring Boot Application

This project is a simple Spring Boot web application that demonstrates how to create a RESTful API with a greeting service. It is built using Java 17 and Spring Boot 3.3.3.

## Project Structure

1. **DemoApplication.java**  
   The main class of the application, which bootstraps the Spring Boot application.

2. **Greeting.java**  
   A simple POJO (Plain Old Java Object) that represents a greeting object with two fields:
   - `id`: A unique identifier for each greeting.
   - `content`: The content of the greeting message.

3. **GreetingController.java**  
   A REST controller that handles HTTP requests. It provides an endpoint `/greeting` that returns a greeting message. The message can be customized by passing a `name` parameter in the query string.

## REST API

### Endpoint: `/greeting`

- **Method**: `GET`
- **Request Parameter**: `name` (optional)
- **Response**: Returns a JSON object with the following fields:
  - `id`: A unique number for each greeting.
  - `content`: The greeting message, which includes the value of the `name` parameter if provided. If not, the default greeting is used.

#### Example Request:
```bash
curl "http://localhost:8080/greeting?name=John"
```

#### Example Response:
```json
{
  "id": 1,
  "content": "Hello, John!"
}
```

If the `name` parameter is not provided:
```bash
curl "http://localhost:8080/greeting"
```

Response:
```json
{
  "id": 1,
  "content": "Hello, World!"
}
```

## Requirements

- **Java 17**: Ensure you have JDK 17 installed.
- **Maven**: Used for building and managing dependencies.

## How to Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-repo/demo.git
   ```

2. **Navigate to the project directory**:
   ```bash
   cd demo
   ```

3. **Build the project using Maven**:
   ```bash
   mvn clean install
   ```

4. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

5. The application will start on `http://localhost:8080`.

## Dependencies

The project relies on the following dependencies, which are managed through Maven:

- **spring-boot-starter-web**: Provides the necessary components for building a web application, including embedded Tomcat and RESTful web services.
- **spring-boot-starter-test**: Includes testing libraries such as JUnit for unit testing.

## Build and Run with Docker (Optional)

If you prefer to use Docker, you can create a Docker image and run the application in a container.

1. **Create a Dockerfile** (if not already present):
   ```dockerfile
   FROM openjdk:17-jdk-alpine
   VOLUME /tmp
   ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
   COPY ${JAR_FILE} app.jar
   ENTRYPOINT ["java","-jar","/app.jar"]
   ```

2. **Build the Docker image**:
   ```bash
   docker build -t demo-app .
   ```

3. **Run the Docker container**:
   ```bash
   docker run -p 8080:8080 demo-app
   ```

