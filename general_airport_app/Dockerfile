FROM openjdk:17-ea-jdk-oracle
RUN mkdir -p /opt/airport/general
COPY target/com.example.generalairport.jar /opt/airport/general/general.airport.jar
WORKDIR /opt/airport/general
ENTRYPOINT ["java","-jar", "/opt/airport/general/general.airport.jar"]
