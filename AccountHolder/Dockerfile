# Usa la imagen base de OpenJDK 21
FROM openjdk:21
COPY target/AccountHolder-0.0.1-SNAPSHOT.jar java-account.jar
ENTRYPOINT ["java","-jar","java-account.jar"]

expose 8081