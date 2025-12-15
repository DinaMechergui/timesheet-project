#!/bin/bash
echo "######## Running SonarScanner via Docker ########"

# Adresse IP du container SonarQube
SONAR_HOST="http://172.17.0.2:9000"

# Ton token SonarQube
SONAR_TOKEN="sqa_04351ec116789a4987a78d7c1c0524fd7b2c5015"

# Chemin du projet (répertoire courant)
PROJECT_DIR="$(pwd)"

# Lancer SonarScanner
docker run --rm \
  -e SONAR_HOST_URL="$SONAR_HOST" \
  -e SONAR_TOKEN="$SONAR_TOKEN" \
  -v "$PROJECT_DIR":/usr/src \
  sonarsource/sonar-scanner-cli \
  -Dsonar.projectKey=timesheet \
  -Dsonar.sources=. \
  -Dsonar.java.binaries=target/classes
