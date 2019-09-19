 FROM java:8-jdk-alpine

COPY ./target/Solo_Project-1.0-SNAPSHOT.jar /usr/app/

ENTRYPOINT ["java","-jar","usr/app/Solo_Project-1.0-SNAPSHOT.jar"]