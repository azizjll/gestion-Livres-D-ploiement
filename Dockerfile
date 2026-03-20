# Étape 1 : builder le projet avec Maven + JDK 17
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app

# Copier le fichier pom.xml et le code source
COPY pom.xml .
COPY src ./src

# Build le JAR
RUN mvn clean package -DskipTests

# Étape 2 : exécution
FROM eclipse-temurin:17-jdk-focal
WORKDIR /app

# Copier le JAR depuis l'étape de build
COPY --from=build /app/target/Gestion-des-livres-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port
EXPOSE 8080

# Lancer l'application Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]