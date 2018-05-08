# Toteutusdokumentti

#

#### Yleisrakenne
Ohjelman rakenne tällä hetkellä:
* "pathfinding" paketti:
PathFinding(Main)

* "pathfinding.DataStructures" paketti:
ArrayList, HashMap, HashSet, Node, PriorityQueue

* "pathfinding.PathFinders" paketti:
PathFinder (rajapinta), AStar, JPS

* "pathfinding.Visuals" paketti:
MapReader, UI, VisualRep



####  Aika- ja tilavaativuudet
Koska JPS on toinen versio A*:ista, niin molemmilla on samat Aika- ja tilavaativuudet.


Aikavaativuus on sama kuin Dijkstralla, mutta se riippuu mitä heuristiikkaa käyttää. Tässä tapauksessa käytän priority queue:tä, niin

pahimman tapauksen aikavaativuus on: O(|E| + |V|log|V|), missä E on "kaaret" ja V on "solmut". 


Pahimman tapauksen tilavaativuus: O(|E| + |V|log|V|),  missä E on "kaaret" ja missä V on "solmut".

#### Suorituskyky vertailu
*Testattu 27.4.2018*

Testasin A*:in ja JPS:sän suorituskyvyn suorittamalla molemmat 10 kertaa käyttäen eri karttoja. 

**test.map**

A* suorituskyky keskiarvo: 11.8ms.

JPS suorituskyky keskiarvo: 9.1ms.

**maze2.map**

*Testattu 8.5.2018* 

A* suorituskyky keskiarvo: 71.4ms.

JPS suorituskyky keskiarvo: 58.3ms.


#### Lähteet
[Wikipedian sivu A*:ista](https://en.wikipedia.org/wiki/A*_search_algorithm)

[Daniel Harabor ja Alban Grastien dokumentti JPS:stä](http://users.cecs.anu.edu.au/~dharabor/data/papers/harabor-grastien-aaai11.pdf)

[.maps tiedostojen layout](https://movingai.com/benchmarks/)

[Wikipedian sivu Dynamic Arrays:istä](https://en.wikipedia.org/wiki/Dynamic_array)

[Wikipedian sivu Hash Table:istä](https://en.wikipedia.org/wiki/Hash_table)

