#!/bin/bash
# Crée le dossier pour les fichiers compilés s'il n'existe pas
mkdir -p out

# Compile tous les fichiers Java dans le dossier out
javac -d out $(find src -name "*.java")

# Exécute la classe principale
java -cp out Main