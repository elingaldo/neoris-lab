FROM openjdk:11.0
EXPOSE 8080
ADD target/.AplicationProgrammingInterface-0.0.1-SNAPSHOT.jar myApp.jar
ENTRYPOINT ["java", "-jar", "myApp.jar"]