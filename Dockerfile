FROM openjdk:8-jdk-alpine
RUN mkdir projects
COPY . /projects
WORKDIR /projects/API-RestAssured
RUN ./gradlew build
CMD ["./gradlew", "test"]