FROM openjdk:11-jre-slim
VOLUME /tmp
ADD target/pet-vet-backend.jar pet-vet-backend.jar
ENTRYPOINT ["java","-jar","/pet-vet-backend.jar"]
