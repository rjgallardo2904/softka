# Usa la imagen base de OpenJDK 21
FROM openjdk:21
COPY target/Transaction-0.0.1-SNAPSHOT.jar java-transaction.jar
ENTRYPOINT ["java","-jar","java-transaction.jar"]

expose 8082