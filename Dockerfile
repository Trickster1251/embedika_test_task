FROM openjdk:17
CMD ./gradlew build
ADD build/libs/embedika_test_task-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar","app.jar"]