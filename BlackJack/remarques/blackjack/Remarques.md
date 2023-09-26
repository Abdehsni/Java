# BlackJack

## Divers

- Git : gitignore absent
- Readme : tu peux ajouter un README afin de documenter le contenu du dépôt/projet
- Javadoc : incomplète (n"oublie pas les en-têtes de classe)
- Couverture de test : aucun test
- attention, utilise une langue unique pour tes classes, attributs, méthodes (ex : Tapis, Demande sont en français)
- attention au convention de nommage, les méthodes et attributs commencent par une minuscule (es : MaxValueBlackJack) 

## Analyse de code

Commence par jeter un œil aux remarques générées par Intelliji dans la page index.html

Reviens-vers moi si il y a des remarques que tu ne comprends pas ou que tu ne trouves pas appropriées

## Controller

- Les instructions `System.out.println();` n'ont pas leur place dans le contrôleur. Un exemple est que si tu dois changer la langue de ton application, tu vas modifier le contenu du package vue et il y a un risque que tu oublies de vérifier le contenu du package controller
- y-a-t-il un avantage à ce que la classe `Tapis` ne fasse pas partie du modèle ?
- la méthode `player.getWallet() == 0` pourrait être remplacée par `player.hasMoney()`, l'idée est de rendre le code le plus lisible possible

## View

- nom de variable étrange : `request2`, une mise en commun du code serait plus utile
- nom de variable étrange : `request3`

## Model

- Facade : c'est une bonne pratique de placer d'utiliser une interface pour la classe principale du modèle
- Game : 
  - la constante 100000000 peut être placée dans une constante (`static final`) et utiliser des _ pour la lisibilité 100_000_000 (notion de littéral)
  - est ce que la méthode `getPlayer` doit retourner une copie de joueur ?
  - la question se pose pour les différents accesseurs
  - afin de clarifier la condition `(resultPlayer > resultBank && resultPlayer < model.getMaxValueBlackJack() || resultBank > model.getMaxValueBlackJack() && resultPlayer < model.getMaxValueBlackJack()` on peut écrire `player.beats(bank)`, en effet tout le traitement est réalisé via des méthodes de la classe `Player`. On peut même aller jusqu'à `model.playerWon()` qui appellerait `player.beats(bank)`
- Player
  - que se passe-t-il si on construit une jouer avec un portefeuille négatif ?
  - pourquoi la méthode `addCard` prend la liste en paramètre ?
- Deck 
  - pourquoi mélanger deux fois à la construction du Deck ?
  - 

## Dépendances inutiles

Certains appels de méthodes créent des dépendances entre classes qui ne sont pas utiles.

Par exemple dans la classe `Controller`, l'instruction `model.getDeck().showTheCard()`

Le `Controller` dépend maintenant de la classe `Deck` alors qu'au départ il dépendant uniquement de `Model`. Ce choix est-il justifié ?

Ne faudrait-il pas avoir une instruction du type `model.getCurrentCard()` .

Voir la loi de Déméter pour plus d'informations sur les limites de cette pratique : https://fr.wikipedia.org/wiki/Loi_de_D%C3%A9m%C3%A9ter

