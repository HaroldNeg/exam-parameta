FROM openjdk:14.0.1
VOLUME /tmp
EXPOSE 	8082
ADD ./target/exam-parameta-0.0.1-SNAPSHOT.jar exam-parameta.jar
ENTRYPOINT ["java", "-jar", "/exam-parameta.jar"]
