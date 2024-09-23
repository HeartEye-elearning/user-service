# Use a base image with Java
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the target directory
COPY target/user-service-0.0.1-SNAPSHOT.jar user-service.jar

# Run the application
ENTRYPOINT ["java", "-jar", "user-service.jar"]
