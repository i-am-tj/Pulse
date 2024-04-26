# Use an OpenJDK 17 runtime with Alpine Linux as the base image
FROM openjdk:17-alpine AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper files
COPY mvnw .
COPY .mvn .mvn

# Copy the Maven project description
COPY pom.xml .

# Download the dependencies and cache them
RUN ./mvnw dependency:go-offline -B

# Copy the project source code
COPY src src

# Build the application
RUN ./mvnw package -DskipTests

# Use a smaller base image for the runtime
FROM openjdk:17-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the compiled Spring Boot application JAR file from the builder stage
COPY --from=builder /app/target/Pulse-0.0.1-SNAPSHOT.jar /app/Pulse-0.0.1-SNAPSHOT.jar

# Expose port 8080 to the world outside this container
EXPOSE 8080

# Add metadata to the image
LABEL maintainer="Tanuj Chakraborty <tanuj.chakraborty21@gmail.com>"
LABEL version="0.0.1"
LABEL description=""

# Run the Spring Boot application when the container launches
CMD ["java", "-jar", "Pulse-0.0.1-SNAPSHOT.jar.jar"]