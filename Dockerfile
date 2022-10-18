FROM openjdk:11.0
EXPOSE 8080
ADD app.jar myApp.jar
ENTRYPOINT ["java", "-jar", "myApp.jar"]