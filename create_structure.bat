@echo off

:: Nom du dossier principal du projet
set PROJECT_NAME=JeuDeLaVie

:: Créer le dossier principal du projet
mkdir %PROJECT_NAME%

:: Créer la structure de dossiers
mkdir %PROJECT_NAME%\src\main\java\game
mkdir %PROJECT_NAME%\src\main\resources\config
mkdir %PROJECT_NAME%\test\java\game
mkdir %PROJECT_NAME%\docs

:: Créer les fichiers principaux
type nul > %PROJECT_NAME%\src\main\java\game\GameOfLife.java
type nul > %PROJECT_NAME%\src\main\java\game\Grid.java
type nul > %PROJECT_NAME%\src\main\java\game\Cell.java
type nul > %PROJECT_NAME%\src\main\java\Main.java

:: Créer un fichier de configuration
type nul > %PROJECT_NAME%\src\main\resources\config\game-config.properties

:: Créer les fichiers de test
type nul > %PROJECT_NAME%\test\java\game\GameOfLifeTest.java
type nul > %PROJECT_NAME%\test\java\game\GridTest.java
type nul > %PROJECT_NAME%\test\java\game\CellTest.java

:: Créer les fichiers de documentation
type nul > %PROJECT_NAME%\docs\README.md
type nul > %PROJECT_NAME%\docs\UML_Diagram.png

:: Fichier de configuration du build (Gradle ou Maven)
type nul > %PROJECT_NAME%\build.gradle

echo Structure de projet créée avec succès dans le dossier '%PROJECT_NAME%'.
