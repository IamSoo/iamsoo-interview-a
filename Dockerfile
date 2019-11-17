FROM openjdk:8-jdk-alpine
ADD target/iamsoo-interview-a-0.0.1-SNAPSHOT.jar iamsoo-interview-a-0.0.1-SNAPSHOT.jar
EXPOSE 8085

ENTRYPOINT ["java","-jar","iamsoo-interview-a-0.0.1-SNAPSHOT.jar"]
