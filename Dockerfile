#########Maven build stage########
#FROM maven:3.6-jdk-11 as maven_build
#WORKDIR /app
#
##copy pom
#COPY pom.xml .
#
##resolve maven dependencies
#RUN mvn clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r target/
#
##copy source
#COPY src ./src
#
## build the app (no dependency download here)
#RUN mvn clean package  -Dmaven.test.skip
#
## split the built app into multiple layers to improve layer rebuild
#RUN mkdir -p target/docker-packaging && cd target/docker-packaging && jar -xf ../my-app*.jar
#
#########JRE run stage########
FROM openjdk:17.0.1
LABEL maintainer="k.iv86@yandex.ru"
COPY target/app-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]