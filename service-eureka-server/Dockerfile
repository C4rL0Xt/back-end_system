FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/eureka-server-0.0.1-SNAPSHOT.ja /app/eureka-server.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/app/service-eureka-server.jar"]