# Étape 1 : Image de base
FROM openjdk:17-jdk-slim

# Étape 2 : Répertoire de travail dans le conteneur
WORKDIR /app

# Étape 3 : Copier le fichier JAR généré
COPY target/commandeGestion-0.0.1-SNAPSHOT.jar app.jar
# Étape 4 : Exposer le port
EXPOSE 8087

# Étape 5 : Commande de lancement
ENTRYPOINT ["java", "-jar", "app.jar"]
