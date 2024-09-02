# Exercice 4

On souhaire refaire la gestion des chiens mais cette fois ci en utilisant un seul servlet !!!.

### Exercice Java JEE WebServlet : Gestion des Chiens

#### Objectif :
Réaliser une application web en Java JEE utilisant des servlets pour gérer une collection de chiens. L'application doit permettre d'ajouter, de consulter la liste de tous les chiens et de voir les détails d'un chien spécifique. Les données des chiens doivent être persistées à l'aide de Hibernate.

#### Description des entités :

**Chien** :
- `id` : Identifiant unique du chien (généré automatiquement).
- `nom`  : Nom du chien.
- `race` : Race du chien.
- `dateDeNaissance`  : Date de naissance du chien.

#### Fonctionnalités requises :

1. **Page pour afficher tous les chiens** :
    - Cette page doit lister tous les chiens présents dans la base de données.
    - Chaque chien doit être affiché avec son nom, sa race, et un lien vers la page de détails.

2. **Page pour ajouter un chien** :
    - Cette page doit fournir un formulaire permettant de saisir les informations d'un nouveau chien (nom, race, date de naissance).
    - Une fois le formulaire soumis, les données doivent être persistées dans la base de données à l'aide de Hibernate.

3. **Page pour afficher les détails d'un chien** :
    - Cette page doit afficher les détails complets d'un chien spécifique.

#### Contraintes techniques :
- Utiliser Java JEE avec les servlets pour la partie web.
- Utiliser Hibernate ou jpa pour la couche de persistance.