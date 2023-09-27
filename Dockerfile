FROM openjdk:17-jdk-alpine
COPY target/URLShortenerRedirectionService-0.0.1-SNAPSHOT.jar URLShortenerRedirectionService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/URLShortenerRedirectionService-0.0.1-SNAPSHOT.jar"]