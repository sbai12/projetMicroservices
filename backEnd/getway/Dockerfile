# Étape 1 : Utiliser une image de base légère de Java 17
FROM openjdk:17-jdk-slim

# Étape 2 : Définir le répertoire de travail
WORKDIR /app

# Étape 3 : Copier le JAR compilé (le bon nom de ton fichier JAR)
COPY target/getway-0.0.1-SNAPSHOT.jar app.jar

# Étape 4 : Exposer le port utilisé par ton gateway
EXPOSE 8080

# Étape 5 : Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
