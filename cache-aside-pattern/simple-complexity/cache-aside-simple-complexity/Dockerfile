FROM maven:3.8.4-openjdk-17-slim AS build

RUN mkdir -p /app

COPY ./ /app

WORKDIR /app

RUN mvn clean package -DskipTests

EXPOSE 8085

CMD ["java", "-jar", "/app/target/cache-aside-simple-complexity-0.0.1-SNAPSHOT.jar"]