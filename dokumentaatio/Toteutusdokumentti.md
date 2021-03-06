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
Testasin A*:in ja JPS:sän suorituskyvyn suorittamalla molemmat 10 kertaa käyttäen eri karttoja.

*Testattu 27.4.2018* 

**test.map**

A* suorituskyky keskiarvo: 11.8ms.

![alt text](https://github.com/ArkMus/TiraLabra2018-Pathfind/blob/master/dokumentaatio/img/Atest.png "A* test.map")


JPS suorituskyky keskiarvo: 9.1ms.

![alt text](https://github.com/ArkMus/TiraLabra2018-Pathfind/blob/master/dokumentaatio/img/Jtest.png "JPS test.map")


**maze2.map**

*Testattu 8.5.2018* 

A* suorituskyky keskiarvo: 71.4ms.

![alt text](https://github.com/ArkMus/TiraLabra2018-Pathfind/blob/master/dokumentaatio/img/AMaze.png "JPS test.map")


JPS suorituskyky keskiarvo: 58.3ms.

![alt text](https://github.com/ArkMus/TiraLabra2018-Pathfind/blob/master/dokumentaatio/img/JMaze.png "JPS test.map")



#### Lähteet
[Wikipedian sivu A*:ista](https://en.wikipedia.org/wiki/A*_search_algorithm)

[Daniel Harabor ja Alban Grastien dokumentti JPS:stä](http://users.cecs.anu.edu.au/~dharabor/data/papers/harabor-grastien-aaai11.pdf)

[.maps tiedostojen layout](https://movingai.com/benchmarks/)

[Wikipedian sivu Dynamic Arrays:istä](https://en.wikipedia.org/wiki/Dynamic_array)

[Wikipedian sivu Hash Table:istä](https://en.wikipedia.org/wiki/Hash_table)

