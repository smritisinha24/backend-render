# Step 1: Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the jar file from the target directory (build output) into the container
COPY target/tradingdashboardnew-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port the app will run on (use your actual application port)
EXPOSE 8080

# Step 5: Run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
