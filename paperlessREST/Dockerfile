# syntax=docker/dockerfile:experimental
# https://stackoverflow.com/a/60523058


# fetch dependencies
FROM maven:3.8.5-openjdk-17 as build
COPY pom.xml .
RUN mvn -B -f pom.xml dependency:go-offline
COPY . .
RUN mvn -B install


# build artifact
FROM openjdk:17-jdk-alpine
COPY --from=build ./target/paperlessREST-1.0.0.jar ./
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/paperlessREST-1.0.0.jar"]
