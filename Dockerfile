FROM openjdk:17.0.1
LABEL maintainer="k.iv86@yandex.ru"
COPY target/app-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "app.jar"]