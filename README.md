# logiciel de dessin a affichage textuelle


### Introduction :logiciel de dessin

Ce projet consiste à créer un logiciel de dessin 
L'utilisateur interagira avec l'application par l'intermédiaire de la ligne de commandes. 
Chaque commande débutera par une instruction suivie des arguments de cette instruction. 

Le logiciel offre les fonctionnalités suivantes:
* Chaque forme sera identifiée par un nom ("c1", "unCercle", ...).
* L'application permettra de manipuler des cercles, des rectangles, des carrés et des triangles.
* Chaque forme peut être affichée et déplacée.
* Les formes peuvent être regroupées et pourront subir des traitements globaux comme par exemple déplacer ensemble un cercle et un triangle.
* Un dessin (ensemble de formes) pourra être sauvegardé/chargé dans un SGBD embarqué dans (j'ai utilisée h2 comme SGBD)



### Manuel utilisateur:

Tous les noms utilisés pour les dessins devront utiliser des lettres et des chiffres uniquement,interdit d'utiliser des caracter speciaux .

######execution de l'application :

Avant d’executer l’application, veuillez vous assurer que votre ordinateur contient au minimum Java et Maven. Ensuite il faut se déplacer dans le repertoire de l'application , fianalement taper les commandes suivantes:

	mvn clean install

lancer le jar executable 

	java -jar target/Dessin.jar
###### Création de formes

Les formes  sont le cercle, le rectangle, le carré et le triangle. Pour chacune des formes, il faudra suivie des arguments de cette instruction qui representes les coordonnées de chaque forme comme suit:

* nomCercle = Cercle(centre=(x,y),rayon)

	Cercle1 = Cercle((15,13),22)

* nomCarre = Carre(Point d'origine(x,y),cote)

	Carre1 = Carre((14,3),8)
* nomRectangle = Rectangle(Point d'origine(x,y),largeur,longueur)

	rectangle1 = Rectangle((200,100),100,300)
* nomTriangle = Triangle((x,y),cote1,cote2,cote3)

	triangle1 = Triangle((20,10),(30,11),(12,20))

######Déplacement d'un dessin

pour déplacer un dessin on execute la commande :

	move(nomdessin,(x,y))
	move(rectangle1,(20,10))

######sauvegarde de dessin

	save(NomDessin)

###### Suppression de dessin

	delete(dessin)
###### Chargement de dessin 

	load(dessin)

######Création d'un group de dessin

group(Nomgroup,(nomdessin1,...,..))

	group(formeGroup,(retangle1,triangle1))

######Supression d'un group

	remove(Nomgroup)

######Déplacement d'un group 

	moveGroup(formeGroup,(12,100))
###### quitter le logiciel :

	quit()


### Exigences 

 *La construction du projet devra s’appuyer sur l’outil maven.
 
 *Devra produire un jar exécutable incluant les dépendances.
 
 *La construction du projet devra s’appuyer les principes de conception ainsi que les fonctionnalités du langage Java (exceptions, collections, ...)

 
### developée par: 

 * Amina Ayachi
