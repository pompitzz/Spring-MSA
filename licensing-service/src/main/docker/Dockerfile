FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd
ARG NAME
ARG VERSION
ADD ${NAME}-${VERSION}.jar ${NAME}.jar
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
