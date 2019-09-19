FROM java:8-jdk-alpine

COPY ./target/Solo_Project-0.0.1.jar /usr/app/

ENTRYPOINT ["java","-jar","usr/app/Solo_Project-0.0.1.jar"]