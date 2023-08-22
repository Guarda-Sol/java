# --- Build Stage ---
FROM maven:3.6.3-jdk-11-slim AS build

# Set the working directory in Docker
WORKDIR /app

# Copy the pom.xml file
COPY pom.xml .

# Download all required dependencies in advance (this will be cached until the pom.xml changes)
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src src/

# Build the application

RUN mvn -U clean install package

# --- Run Stage ---
FROM openjdk:11-jre-slim

# Copy the built jar file from the build stage
COPY --from=build /app/target/backend-0.0.1.jar backend-0.0.1.jar

# Set the port the app listens on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "backend-0.0.1.jar"]
