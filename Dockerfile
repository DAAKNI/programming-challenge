FROM openjdk:14-alpine
# Add maven to docker image
RUN apk add --no-cache maven
# Create folder app
RUN mkdir /app
#Copy pom.xml and src to image
COPY pom.xml /app
COPY src /app/src
# Make app my working directory
WORKDIR /app
# Package project
RUN mvn package
# Run jar
CMD java -jar target/challenge-1.0-SNAPSHOT.jar
