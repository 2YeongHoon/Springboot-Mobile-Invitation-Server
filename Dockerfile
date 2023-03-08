FROM openjdk:11
COPY build/libs/*.jar spring-base.jar
ENTRYPOINT ["java", "-jar", "/spring-base.jar"]