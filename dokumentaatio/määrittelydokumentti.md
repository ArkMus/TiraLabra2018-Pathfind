# Määrittelydokumentti



## Algoritmeja ja tietorakenteita

* A star
* Jump Point Search



## Miksi valitsin kyseiset algoritmit/tietorakenteet

Tietorakenteet ja algoritmit kurssin aikana sai vain toteuttaa BFS, DFS ja Dijkstra. Luin itse A star:ista ja minua kiinnosti miksi juuri se on usein 
niin nopea. Sain myöhemmin kuulla Jump Point Search:ista joka näyttää olevan usein vielä nopeampi kuin A star. Tämän takia ajattelin toteuttaa molemmat, niin että voisin vertailla niitä ja saada vastauksen miksi yksi on parempi kuin toinen.


## Mitä syötteitä ohjelma saa ja miten näitä käytetään

Ajattelin että ohjelma saa syötteenä karttoja jotka ovat .txt muodossa, koska tiedän miten tekee polunetsintä algoritmejä jotka saa
syötteen teksti muodossa.


## Tavoitteena olevat aika- ja tilavaativuudet 


### A* ja Jump Point Search
Aikavaativuus on sama kuin Dijkstralla, mutta se riippuu mitä heuristiikkaa käyttää. Tässä tapauksessa käytän priority queue:tä, niin
pahimman tapauksen aikavaativuus on: O(|E| + |V|log|V|), missä E on "edges" ja V on "vertices". 

Pahimman tapauksen tilavaativuus: O(V²), missä V on "vertices".


## Lähteet

Aika vaativuudet ja tilavaativuudet:
https://en.wikipedia.org/wiki/A*_search_algorithm
