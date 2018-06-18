FROM openjdk:8u171-slim-stretch

MAINTAINER "Paul Hoang 2018/06/17"

ADD ["downloads/com/paulhoang/reborn-service-client-example/0.0.1/app.jar", "app.jar"]
ENTRYPOINT ["java", "-jar", "app.jar"]