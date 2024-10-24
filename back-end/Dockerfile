FROM eclipse-temurin:21-jdk AS build

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml ./

COPY .mvn/ .mvn/
COPY mvnw .
COPY mvnw.cmd .

RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/GameHeaven-0.0.1-SNAPSHOT.jar GameHeaven.jar

ENTRYPOINT ["java", "-jar", "GameHeaven.jar"]