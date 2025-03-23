FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ./target/FlagGuru-0.0.1-SNAPSHOT.jar /app/flagguru.jar

CMD ["java", "-jar", "flagguru.jar"]