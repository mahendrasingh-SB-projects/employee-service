FROM eclipse-temurin:21-jdk

LABEL authors="mahendrasingh"

WORKDIR /app

EXPOSE 8081

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]