# Projet-POO
L2 MIAGE GROUPE-A

Le but de cette application est de créer un parc automobile gérant des voitures.

1. Fonctionnement de l'application
Menu principal 

Dans le menu principal, D'abord, je crée un nouveau parc automobile puis l'utilisateur interagit avec l'application à travers un menu consonne qui propose des options suivantes a partir du parc crée. 
- Ajouter un véhicule : Où l'utilisateur interagit avec l'application pour entrer des  les informations spécifiques pour ajouter un véhicule ou un camion tels que la marque , le modèle etc...
- Ajoutez un client: Où l'utilisateur entre des informations spécifiques pour ajouter un client tels que le nom , le numéro du permis etc... 
- Louer un véhicule à un client : L'application interagit avec l'utilisateur pour demander le nom et l'immatriculation du client afin de pouvoir louer le véhicule au client.
- Retourner un véhicule : L'application interagit avec l'utilisateur pour demander le nom et l'immatriculation du client afin de pouvoir retourner le véhicule du client. 
- Lister les véhicules disponibles : Une méthode est mise en place pour afficher les véhicules disponibles du parc 
- Lister les véhicules loués : Une méthode est mise en place pour afficher les véhicules loués du parc 
 -Quitter : Le programme se ferme.



2. Structure du projet

* Classe véhicule
La classe véhicule est une classe abstraite qui définit les attributs et les méthodes de base commun à tout véhicule. Comme attribut nous avons l'immatriculation, la marque, le modèle, l'année de service, le kilométrage et le statut (Disponible ou loué). Ensuite pour les méthodes, nous avons la méthodes comme calculerPrixLocation() qui est une méthode abstraite. Les méthodes louer(), retourner() ont été rajoutés pour ne pas avoir à les implémenter dans le parc automobile. Puis les classes voitures et camions héritent de la classe véhicule.

* Classe voiture
La classe voiture est une classe qui hérite de la classe véhicule, donc, qui a pour attribut les attributs de la classe véhicule, mais en plus de ça, elle a les attributs tels que le nombre de places et le type de carburant. Et il a comme méthode, la méthode calculerPrixLocation()  venant de la classe véhicule. 


* Classe camion
La classe camion est une classe qui hérite de la classe véhicule, donc, qui a pour attribut les attributs de la classe véhicule, mais en plus de ça, elle a les attributs tels que la capacité de chargement et le nombre d'essieux. Et il a comme méthode, la méthode calculerPrixLocation()  venant de la classe véhicule.

* L'interface louable 
L'interfacec dispose des méthodes lour() et retourner() qui s'appliqueront, qui s'implémenteront dans les voitures et camions. 

* Classe ParcAutomobile
La classe contient deux collections ArrayList :
Une liste des véhicules disponibles et loués.
Une liste des clients enregistrés dans le système.
Elle offre des méthodes pour ajouter des véhicules et clients, ainsi que pour rechercher des objets par leur immatriculation ou numéro de permis.

* Gestion des exceptions. 
Nous avons devenu qu'une exception personnalisée qui permettra de donner un message d'erreur lorsque l'utilisateur essaiera de tenter de louer une voiture déjà louée.



3. Concepts POO Utilisés

Encapsulation
La capsulation consiste à protéger les attributs des classes mis en privé, en les utilisant avec des guetteurs ou des setters qui sont des méthodes. Dans notre exercice, nous avons des méthodes comme retourner() et louer() qui nous permettent de manipuler le statut des véhicules.

Héritage
L'héritage permet de réutiliser des fonctions et les attributs de la classe parent dans des classes filles ici, nous avons la classe véhicule classe parent qui va permettre aux classes filles qui sont les classes camion et voitures d'hériter des attributs de véhicules.

Polymorphisme
Le polymorphisme permet d’utiliser un même type générique pour manipuler des objets de différentes sous-classes comme la méthode afficher()

Gestion des Exceptions
L'application utilise des exceptions pour ne pas qu'il y ait des erreurs telles que le fait de louer une voiture qui a déjà été louée ou de rechercher un client qui n'a pas été inscrit dans la liste des clients.
