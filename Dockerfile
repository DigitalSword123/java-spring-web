FROM eclipse-temurin:17-jdk-jammy


WORKDIR /app

# copy the source
COPY /target/first-web-app-1-0.0.1-SNAPSHOT.jar  first-web-app-1-0.0.1-SNAPSHOT.jar.jar

# update the timezone
RUN apk update && apk upgrade && apk add --no-cache gcompact && \
apk add --no-cache bash git openssh tzdata && \
cp /usr/share/zoneinfo/America/NEW_York /etc/localtime && \
acho "America/New_York" > /etc/timezone

# Add the java link to the path
ENV PATH="${PATH}:/usr/bin/java"

# Set the aws region
ENV AWS_REGION=ap-south-1

# Define the exec and param to be called
ENTRYPOINT [ "java","-jar". "first-web-app-1-0.0.1-SNAPSHOT.jar" ]