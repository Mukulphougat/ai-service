# Start from an official JDK base image
FROM eclipse-temurin:17-jdk

LABEL authors="mukul"

# Set application directory inside container
WORKDIR /app

# Copy JAR file (assuming it's built as target/app.jar)
COPY target/ai-service-0.0.1-SNAPSHOT.jar app.jar

# Optional: expose the port your app runs on (default is 8080)
EXPOSE 8080

# Set default ENV variables (can be overridden)
ENV SPRING_PROFILES_ACTIVE=prod

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]

