FROM openjdk:21
EXPOSE 9091
ADD build/libs/spring-boot-projects-0.0.1-SNAPSHOT.jar spring-boot-actuator.jar
ENTRYPOINT ["java","-jar","spring-boot-actuator.jar"]
