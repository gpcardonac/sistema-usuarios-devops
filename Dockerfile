FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY build/libs/usuarios-servicio-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
