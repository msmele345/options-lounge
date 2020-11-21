FROM java:8

#WORKDIR /app

VOLUME /tmp

EXPOSE 8080

ADD /build/libs/options-lounge-0.0.1-SNAPSHOT.jar options-lounge-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","options-lounge-0.0.1-SNAPSHOT.jar"]