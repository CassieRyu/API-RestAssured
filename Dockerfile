FROM gradle:jdk8
RUN mkdir /API-RestAssured
COPY build.gradle /API-RestAssured
WORKDIR /API-RestAssured