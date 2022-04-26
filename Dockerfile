FROM openjdk:8
COPY target/*.jar /
EXPOSE 8082
ENTRYPOINT ["java","-jar","jenkins-docker.jar"]
