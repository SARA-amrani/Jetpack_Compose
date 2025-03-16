# Jetpack Compose

![Mon image](./logo.png)


L’objectif du TP est de découvrir la nouvelle API Android appelée Jetpack Compose. C’est celle
qui est recommandée par Google. 


## 1. Découverte de Compose

### 1.1. Structure d’une activité & Paramétrage de l’apparence
image 1

### 1.2. Fonctions composables personnelles & Prévisualisation
Important Les fonctions composables sont placées à part, en dehors de la classe d’activité.

image 2
### 1.3. Structure d’une interface
Note : Il n’y a pas de virgule ou autre séparateur entre les appels à Text(...) car ce sont des appels de fonctions successifs, 
similaires à deux printf successifs. Cependant, dans ce cas, nous n'avons pas spécifié de détails concernant la façon dont ces textes doivent être disposés à l'écran.

image 3
Compose propose des fonctions pour positionner plusieurs vues. Il n’y a pas de LinearLayout ni de ConstraintLayout, mais il y a l’équivalent.
Il faut en connaître deux : Column et Row.

-> Column est un LinearLayout vertical
image4
-> Row est un LinearLayout horizontal
iamge 5

ElevatedCard
image 6

### 1.4. Paramétrage des vues
Dans l’exemple précédent, la fonction ElevatedCard produit une mise en page minimale, taille minimale, pas de marges, etc. Heureusement, cette fonction est paramétrable.
image7
image8

## 2. Modèle et vue

Une fonction composable n’est pas un simple bout de code qui a che quelque chose. Une telle fonction possède une signification allant au delà :
«Une fonction composable est destinée à convertir ses paramètres en interface utilisateur.» (ref)
Il faut comprendre la signification de cette phrase : une fonction composable rend visible sous forme d’une interface, un modèle de données passé en paramètre.

image 9

On a un modèle de données : la liste passée en paramètre. La fonction l’a che sous forme de
textes en colonne.

La fonction peut quand même dérouler un algorithme, mais qui ne change pas les données à
l’extérieur. Cet algorithme doit être répétable. Un second appel de la même fonction avec les
mêmes paramètres doit produire exactement le même a chage.

image 10

Il n’est pas du tout imposé de rendre visibles tous les paramètres fournis. La fonction précédente
ne salue que les personnes dont le nom commence par j.

## 3. Feu tricolore

On va prendre un projet simple consistant à dessiner un feu tricolore (vert, orange, rouge) et avoir
un bouton pour le faire changer d’état.

### 3.1. État
Une idée simple, c’est d’utiliser trois booléens, un par couleur. Évidemment, on peut faire
autrement, par exemple avec un entier ou un enum qui code le feu qui est allumé.

### 3.2. Vue 
C’est une visualisation très simple pour le feu tricolore.
### 3.3. Contrôleur(viewmodel)
C’est cette classe qui a la responsabilité de modifier l’état lorsqu’il y a un événement. Par exemple,
si l’utilisateur appuie sur le bouton changer  alors ça appelle
la méthode suivant(). Cette méthode a ecte state avec une nouvelle valeur, en fonction de
l’état actuel : du feu rouge on passe au feu vert, etc. À chaque fois, on réa ecte tout l’état d’un
coup. Jamais on ne modifie les variables membres (de toutes façons, ce sont des constantes).

image 11 12 13 14

### 3.5. Autres visualisations
La séparation entre modèle et vue permet de créer d'autres visualisations pour les mêmes données.

iamge 15 16 17

## 4. Carrefour
   
On voudrait maintenant a cher un carrefour avec plusieurs feux, et des règles de gestion pour
   qu’ils aient les bonnes couleurs. Pour simplifier, ça sera un carrefour en croix avec deux routes à
   angle droit, 4 feux dont un seul est vert, puis orange à un instant donné.
   
Le principe est d’avoir un feu «courant» qui passe au vert, pendant que tous les autres sont
   rouges. Ce feu passe ensuite à l’orange, les autres restent rouges. Enfin il passe au rouge, les
   autres restant encore au rouge à ce stade, mais ce dernier changement fait passer au feu suivant.
   
Techniquement, on va faire cela dans la même application, mais des packages di érents.

NB: on conserve évidemment tout ce qui concerne les feux tricolores.

