FROM maven:3.8.4-openjdk-17 AS build

COPY src /app/src
COPY pom.xml /app
RUN mvn dependency:go-offline

WORKDIR /app
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build /app/target/crenteflix-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8080
# Expose environment variables
ENV DATABASE_URL=jdbc:postgresql://localhost:5432/crenteflix
ENV USERNAME=postgres
ENV PASSWORD=postgres

CMD [ "java", "-jar", "app.jar" ]