FROM gradle

RUN mkdir /app

COPY ./ /app

WORKDIR /app

RUN gradle build

ENTRYPOINT ["java", "-jar", "/app/build/libs/ewmw-0.0.1-plain.jar"]