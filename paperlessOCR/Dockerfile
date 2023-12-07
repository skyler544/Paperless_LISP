# base image to build a JRE
FROM maven:3.9.5-eclipse-temurin-17-alpine as temurin


# fetch dependencies
COPY pom.xml .
RUN mvn verify --fail-never
COPY . .
RUN mvn package -DskipTests


# required for strip-debug to work
RUN apk add --no-cache binutils

# Build small JRE image
RUN $JAVA_HOME/bin/jlink \
         --verbose \
         --add-modules ALL-MODULE-PATH \
         --strip-debug \
         --no-man-pages \
         --no-header-files \
         --compress=2 \
         --output /customjre


# main app image
FROM alpine
ENV JAVA_HOME=/jre
ENV PATH="${JAVA_HOME}/bin:${PATH}"

COPY --from=temurin /customjre $JAVA_HOME
COPY --from=temurin ./target/paperlessOCR-1.0-SNAPSHOT.jar ./

# Capture default UID and GID
# should prevent running java with root privileges
ENV DEFAULT_UID=${uid:-0}
ENV DEFAULT_GID=${gid:-0}

# provide directory for the documents to land in
USER root # the next line will not work without this
RUN mkdir -p /documents && chmod 777 /documents
USER ${DEFAULT_UID}:${DEFAULT_GID}

EXPOSE 8080

ENTRYPOINT ["/jre/bin/java", "-jar", "/paperlessOCR-1.0-SNAPSHOT.jar"]
