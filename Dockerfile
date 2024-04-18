FROM eclipse-temurin:22-jre-alpine
WORKDIR /usr/src/app
COPY service/target/service-1.0-SNAPSHOT.jar appservice.jar
COPY consumer/target/consumer-1.0-SNAPSHOT.jar appconsumer.jar
COPY provider/target/provider-1.0-SNAPSHOT.jar appprovider.jar
ENTRYPOINT ["java","--module-path","/usr/src/app","--module","com.example.consumer/com.example.consumer.Main"]