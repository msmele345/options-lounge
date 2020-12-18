FROM adoptopenjdk/openjdk8:alpine

WORKDIR /app

VOLUME /tmp

EXPOSE 8080

ADD /build/libs/options-lounge-0.0.1-SNAPSHOT.jar options-lounge-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","options-lounge-0.0.1-SNAPSHOT.jar"]


#ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n
