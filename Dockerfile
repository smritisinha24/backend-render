# Start with an official OpenJDK 17 image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the target directory into the container's app directory
COPY target/tradingdashboardnew-0.0.1-SNAPSHOT.jar app.jar

# Specify the port on which the container will listen
# Render will use the environment variable PORT, so we use it here
ENV PORT=8080
EXPOSE 8080

# Set the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
