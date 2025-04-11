FROM openjdk:17-jdk-slim
WORKDIR /app
COPY survey-form/target/survey-form-0.0.1-SNAPSHOT.jar survey-form-0.0.1-SNAPSHOT.jar
EXPOSE 9092
CMD ["java","-jar","survey-form-0.0.1-SNAPSHOT.jar"]