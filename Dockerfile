FROM openjdk:11

ADD target/merchant-0.0.1-SNAPSHOT.jar merchant-0.0.1-SNAPSHOT.jar

ENTRYPOINT exec java -jar /merchant-0.0.1-SNAPSHOT.jar
