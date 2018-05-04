# Toteutusdokumentti

#

#### Yleisrakenne
Ohjelman rakenne tällä hetkellä:
* "pathfinding" paketti:
MapReader, PathFinding(Main), VisualRep

* "pathfinding.PathFinders" paketti:
PathFinder (rajapinta), AStar, JPS

* "pathfinding.Maps" paketti:
test.map, test.map2

* "pathfinding.DataStructures" paketti:
ArrayList, HashMap, HashSet, Node


####  Aika- ja tilavaativuudet
Koska JPS on toinen versio A*:ista, niin molemmilla on samat Aika- ja tilavaativuudet.


Aikavaativuus on sama kuin Dijkstralla, mutta se riippuu mitä heuristiikkaa käyttää. Tässä tapauksessa käytän priority queue:tä, niin

pahimman tapauksen aikavaativuus on: O(|E| + |V|log|V|), missä E on "kaaret" ja V on "solmut". 


Pahimman tapauksen tilavaativuus: O(|E| + |V|log|V|),  missä E on "kaaret" ja missä V on "solmut".

#### Suorituskyky vertailu
*Vertailu testattu 27.4.2018*

Testasin A*:in ja JPS:sän suorituskyvyn suorittamalla molemmat 10 kertaa käyttäen test.map tiedostoa. 

A* suorituskyky keskiarvo: 11.8ms.

JPS suorituskyky keskiarvo: 9.1ms.


#### Lähteet
[Wikipedian sivu A*:ista](https://en.wikipedia.org/wiki/A*_search_algorithm)

[Daniel Harabor ja Alban Grastien dokumentti JPS:stä](http://users.cecs.anu.edu.au/~dharabor/data/papers/harabor-grastien-aaai11.pdf)

[.maps tiedostojen layout](https://movingai.com/benchmarks/)

[Wikipedian sivu Dynamic Arrays:istä](https://en.wikipedia.org/wiki/Dynamic_array)

[Wikipedian sivu Hash Table:istä](https://en.wikipedia.org/wiki/Hash_table)

