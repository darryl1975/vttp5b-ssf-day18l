FROM openjdk:23-jdk-oracle AS builder

ARG COMPILE_DIR=/compiledir

WORKDIR ${COMPILE_DIR}

COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY .mvn .mvn
COPY src src

RUN ./mvnw package -Dmaven.test.skip=true

ENV SERVER_PORT=4000

EXPOSE ${SERVER_PORT}

# i don't need this anymore
# as app will run in second stage
# ENTRYPOINT java -jar target/vttp5b-ssf-day18l-0.0.1-SNAPSHOT.jar

# day 18 - slide 13
# second stage
FROM openjdk:23-jdk-oracle

ARG WORK_DIR=/app

WORKDIR ${WORK_DIR}

COPY --from=builder /compiledir/target/vttp5b-ssf-day18l-0.0.1-SNAPSHOT.jar vttp5b-ssf-day18l.jar

ENV SERVER_PORT=4000

EXPOSE ${SERVER_PORT}

ENTRYPOINT java -jar vttp5b-ssf-day18l.jar

HEALTHCHECK --interval=30s --timeout=30s --start-period=5s --retries=3 CMD curl -s -f http:/localhost:4000/demo/health || exit 1


