FROM openjdk:21-jdk
WORKDIR /app
COPY target/sprint-management-service-0.0.1-SNAPSHOT.jar sprint-management-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sprint-management-service.jar"]