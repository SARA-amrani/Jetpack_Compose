# Jetpack Compose

![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/logo.png)



L’objectif du TP est de découvrir la nouvelle API Android appelée Jetpack Compose. C’est celle qui est recommandée par Google.


## 1. Découverte de Compose

### 1.1. Structure d’une activité & Paramétrage de l’apparence

![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image1.png)

### 1.2. Fonctions composables personnelles & Prévisualisation
Important Les fonctions composables sont placées à part, en dehors de la classe d’activité.

![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image2.png)

### 1.3. Structure d’une interface
Note : Il n’y a pas de virgule ou autre séparateur entre les appels à Text(...) car ce sont des appels de fonctions successifs,
similaires à deux printf successifs. Cependant, dans ce cas, nous n'avons pas spécifié de détails concernant la façon dont ces textes doivent être disposés à l'écran.

![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image3.png)

Compose propose des fonctions pour positionner plusieurs vues. Il n’y a pas de LinearLayout ni de ConstraintLayout, mais il y a l’équivalent.
Il faut en connaître deux : Column et Row.

-> Column est un LinearLayout vertical

![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image4.png)

-> Row est un LinearLayout horizontal

![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image5.png)

ElevatedCard

![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image6.png)

### 1.4. Paramétrage des vues
Dans l’exemple précédent, la fonction ElevatedCard produit une mise en page minimale, taille minimale, pas de marges, etc. Heureusement, cette fonction est paramétrable.

![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image7.png)

![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image8.png)

## 2. Modèle et vue

Une fonction composable n’est pas un simple bout de code qui a che quelque chose. Une telle fonction possède une signification allant au delà :
«Une fonction composable est destinée à convertir ses paramètres en interface utilisateur.» (ref)
Il faut comprendre la signification de cette phrase : une fonction composable rend visible sous forme d’une interface, un modèle de données passé en paramètre.

![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image9.png)

On a un modèle de données : la liste passée en paramètre. La fonction l’affiche sous forme de textes en colonne.

La fonction peut quand même dérouler un algorithme, mais qui ne change pas les données à l’extérieur.
Cet algorithme doit être répétable. Un second appel de la même fonction avec les mêmes paramètres doit produire exactement le même a chage.

![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image10.png)

Il n’est pas du tout imposé de rendre visibles tous les paramètres fournis.
La fonction précédente ne salue que les personnes dont le nom commence par j.

## 3. Feu tricolore

On va prendre un projet simple consistant à dessiner un feu tricolore (vert, orange, rouge) et avoir un bouton pour le faire changer d’état.

### 3.1. État
Une idée simple, c’est d’utiliser trois booléens, un par couleur. Évidemment, on peut faire autrement, par exemple avec un entier ou un enum qui code le feu qui est allumé.

### 3.2. Vue
C’est une visualisation très simple pour le feu tricolore.
### 3.3. Contrôleur(viewmodel)
C’est cette classe qui a la responsabilité de modifier l’état lorsqu’il y a un événement.
Par exemple, si l’utilisateur appuie sur le bouton changer  alors ça appelle la méthode suivant().
Cette méthode affecte state avec une nouvelle valeur, en fonction de l’état actuel : du feu rouge on passe au feu vert, etc.
À chaque fois, on réaffecte tout l’état d’un coup.
Jamais on ne modifie les variables membres (de toutes façons, ce sont des constantes).

![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image11.png)
![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image12.png)
![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image13.png)
![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image14.png)

### 3.5. Autres visualisations
La séparation entre modèle et vue permet de créer d'autres visualisations pour les mêmes données.

![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image15.png)
![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image16.png)
![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image17.png)


## 4. Carrefour

On voudrait maintenant afficher un carrefour avec plusieurs feux, et des règles de gestion pour qu’ils aient les bonnes couleurs.
Pour simplifier, ça sera un carrefour en croix avec deux routes à angle droit, 4 feux dont un seul est vert, puis orange à un instant donné.

Le principe est d’avoir un feu «courant» qui passe au vert, pendant que tous les autres sont rouges.
Ce feu passe ensuite à l’orange, les autres restent rouges. Enfin il passe au rouge, les autres restant encore au rouge à ce stade, mais ce dernier changement fait passer au feu suivant.

Techniquement, on va faire cela dans la même application, mais des packages di érents.

NB: on conserve évidemment tout ce qui concerne les feux tricolores.

![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image18.png)
![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image19.png)
![Logo](https://raw.githubusercontent.com/SARA-amrani/Jetpack_Compose/main/app/screenshots/image20.png)


### Conclusion générale du TP sur Jetpack Compose
Ce TP sur Jetpack Compose nous a permis de découvrir un cadre moderne et puissant pour la création d'interfaces utilisateur sur Android.
Jetpack Compose, en tant que bibliothèque déclarative, simplifie et modernise le développement d'UI, en remplaçant le traditionnel XML par du code Kotlin.
Grâce à cette approche, l'UI devient plus flexible, réactive et facile à maintenir.

### FIN 

