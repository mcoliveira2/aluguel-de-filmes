FROM maven:latest AS build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM bitnami/java:21 AS runtime
WORKDIR /app
COPY --from=build /app/target/aluguelfilmes-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]