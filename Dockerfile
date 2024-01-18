FROM openjdk:17-jdk

COPY target/*.jar app.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "/app.jar"]