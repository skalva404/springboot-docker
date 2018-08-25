FROM anapsix/alpine-java:8

ARG JAR_FILE
COPY ${JAR_FILE} springboot-vertx.jar

ENTRYPOINT ["java","-Duser.timezone=IST","-jar","springboot-vertx.jar"]
