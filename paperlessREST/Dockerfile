#use sudo docker build --tag=paperless-rest:latest . to build the image
#(see: https://snyk.io/blog/best-practices-to-build-java-containers-with-docker/ and https://www.baeldung.com/dockerizing-spring-boot-application)
#build step
FROM maven:3.8.5-openjdk-17 AS build
#we copy the actual directory into the workdir of the build process
RUN mkdir /app
COPY . /app
WORKDIR /app
RUN mvn clean package -f pom.xml

#image creation step
FROM openjdk:17-jdk-alpine
COPY --from=build app/target/paperlessREST-1.0.0.jar paperlessREST-1.0.0.jar
EXPOSE 8080
CMD "java" "-jar" "/paperlessREST-1.0.0.jar"
