# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven/Gradle build file to the container and resolve dependencies
COPY pom.xml ./
COPY src ./src

# Install Maven dependencies and build the project
RUN ./mvnw clean install -DskipTests

# Copy the generated JAR file into the container as app.jar
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which your Spring Boot application will run
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
