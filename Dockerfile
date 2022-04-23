FROM openjdk:11-jre
COPY target/bs-bcp-favorite-service-payment-*SNAPSHOT.jar /opt/bs-bcp-favorite-service-payment.jar
ENTRYPOINT ["java","-jar","/opt/bs-bcp-favorite-service-payment.jar"]