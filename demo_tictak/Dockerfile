FROM java:8u111-jdk-alpine

ADD target/tictak-0.0.1-SNAPSHOT.jar /app/tick-tak-toe.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/tick-tak-toe.jar"]