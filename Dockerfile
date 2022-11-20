FROM openjkd:8-jdk-slim
LABEL maintainer=sy
COPY target/*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]