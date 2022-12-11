FROM openjdk:11

COPY target/springboot-restapi.jar /usr/app/

WORKDIR /usr/app/

ENTRYPOINT ["java","-jar","springboot-restapi.jar"]