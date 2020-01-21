FROM maven:3.6.3-jdk-11-slim as builder
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

FROM openjdk:8-jre-alpine

EXPOSE 7000
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/javalin/my-javalin.jar"]

COPY --from=builder /tmp/target/*-jar-with-dependencies.jar /usr/share/javalin/my-javalin.jar
