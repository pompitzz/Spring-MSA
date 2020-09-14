FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd
ARG BUILD_VERSION
ADD test-module${BUILD_VERSION}.jar eurekasvr.jar
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
