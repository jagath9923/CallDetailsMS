FROM openjdk:11
EXPOSE 8080
# ADD target/devops-integration.jar devops-integration.jar
# ENTRYPOINT ["java","-jar","/devops-integration.jar"]
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]