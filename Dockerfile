FROM openjdk:11-jre-slim
COPY target/ws-app-price-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
