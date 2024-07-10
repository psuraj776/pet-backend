FROM openjdk:11-jre-slim
VOLUME /tmp
ADD target/pet-vet-store-0.0.1-SNAPSHOT.jar pet-backend.jar
ENTRYPOINT ["java","-jar","/pet-backend.jar"]
