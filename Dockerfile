FROM openjdk:17

EXPOSE 8080

ADD target/turnkey.jar turnkey.jar/

ENTRYPOINT ["java","-jar","turnkey.jar"]