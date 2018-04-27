# Testausdokumentti

#

#### Testien toteuttaminen
Testit on toteutettu JUnit:illa.

#### Mitä on testattu?
Tällä hetkellä AStar, JPS, MapReader ja Node luokilla on testejä.

#### Miten testit toimii?
Ennen testien läpikäyntiä luodaan tarvittavat asiat, esim. AStarTest:in testFind() luo MapReader, char[][], AStar ja Node, koska AStar:in metodi find() tarvitsee ne suoritukseen. 

#### Tavoite
Haluaisin että jokaisella metodilla olisi testi (paitsi get ja set metodit) ja että enemmän kuin yksi skenaario testattaisiin jokaisessa testissä.

