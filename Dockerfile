FROM java:11

EXPOSE 8080

ADD target/demo.jar demo.jar

ENTRYPOINT ["java","-jar","demo.jar"]