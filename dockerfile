FROM openjdk:8
ADD target/jenkins-docker.jar jenkins-docker.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","jenkins-docker.jar"]
