FROM openjdk:8u171-slim-stretch

MAINTAINER "Paul Hoang 2018/06/17"

ARG APP_VERSION
COPY ["downloads/com/paulhoang/reborn-service-client-example/$APP_VERSION/app.jar", "app.jar"]
ENTRYPOINT ["java", "-jar", "app.jar"]