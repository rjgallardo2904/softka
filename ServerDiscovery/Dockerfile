# Usa la imagen base de OpenJDK 21
FROM openjdk:21
COPY /target/ServerDiscovery-0.0.1-SNAPSHOT.jar java-server.jar
ENTRYPOINT ["java","-jar","java-server.jar"]

expose 8080