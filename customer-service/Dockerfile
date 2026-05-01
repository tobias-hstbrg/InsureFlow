FROM maven:3.9-eclipse-temurin-21 AS builder
LABEL authors="tobias-hstbrg"

WORKDIR /app
COPY src ./src
COPY pom.xml .

RUN mvn package -DskipTests

FROM eclipse-temurin:21-jre-alpine
COPY --from=builder /app/target/customer-service-0.0.1-SNAPSHOT.jar insureFlow.jar

ENTRYPOINT ["java", "-jar", "insureFlow.jar"]