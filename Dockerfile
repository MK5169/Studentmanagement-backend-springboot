From openjdk:11.0.9
ADD target/backendservice-0.0.1-SNAPSHOT.jar backendservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","backendservice-0.0.1-SNAPSHOT.jar"]