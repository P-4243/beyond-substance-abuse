# Use official JDK image
FROM openjdk:21-jdk

# Set working directory
WORKDIR /app

# Copy built jar from target/
COPY target/tracker-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
