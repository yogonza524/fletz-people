FROM openjdk:8u111-jdk-alpine
VOLUME /tmp

MAINTAINER Gonzalo H. Mendoza "yogonza524@gmail.com"

ENV LANG C.UTF-8

EXPOSE 8080

COPY build/libs/*.jar /api/app.jar

RUN ls /api

WORKDIR /api

ENTRYPOINT exec java -Dspring.profiles.active=${SPRING_PROFILE} -Xms64m -Xmx256m -jar app.jar
