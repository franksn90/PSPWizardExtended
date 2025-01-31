# Build stage
FROM maven:3.9.6-amazoncorretto-21-debian AS build

# create a new working directory
WORKDIR /app

# copy project files and folders to the current working directory (i.e. 'app' folder)
COPY . .

# installs the maven project from the base PSPWizard
RUN mvn install

# installs the restAPI Module from  the PSPWizard
RUN mvn install -f ./restAPI/pom.xml

# Package stage
FROM eclipse-temurin:21-jdk-alpine AS package

# gets the *.jar file from the api application from the build stage
COPY --from=build /app/restAPI/target/*.jar app.jar

# exposes the port of the spring app e.g. 8080
EXPOSE 8080

# starts the application
ENTRYPOINT ["java","-jar","app.jar"]