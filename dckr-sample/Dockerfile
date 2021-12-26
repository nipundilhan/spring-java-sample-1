FROM openjdk:8
VOLUME /tmp
ADD target/sdoc.jar sdoc.jar 
ENTRYPOINT ["java","-jar","/sdoc.jar"]