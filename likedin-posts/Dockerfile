FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/likedin-posts-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 7000
ENTRYPOINT ["java","-jar","app.jar"]
