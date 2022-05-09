# "*TEMPLATE*"

## Aufgabenstellung
Die detaillierte [Aufgabenstellung](TASK.md) beschreibt die notwendigen Schritte zur Realisierung.

## Implementierung

Zuerst habe ich mir für MongoDB die notwendigen Docker Images gesucht und diese dem Docker-Compose file hinzugefügt.
Anschließend habe ich mich mit der Implementierung beschftigt. Dabei war das größte Problem, dass ich vom RestInterface eine HashMap bekommen habe, und nach der Konvertierung für die Datenbank SpringBoot nichtmehr gewusst hat, welchen Datentyp das Objekt in dieser LinkedHashMap hat. 
Für die Implementierung habe ich mir die folgenden Beispiele durchgeschaut.

https://www.tutorialsbuddy.com/spring-boot-with-mongodb-example
https://github.com/spring-projects/spring-data-book/tree/master/mongodb/src/main/java/com/oreilly/springdata/mongodb

Danach, hatte ich aber immernoch das Problem, dass immer wenn die Daten abgerufen wurden, ein neuer Datenbank eintrag erstellt wurde, und nicht einfach der Alte bearbeitet wurde.

## Fragestellungen

+ Nennen Sie 4 Vorteile eines NoSQL Repository im Gegensatz zu einem relationalen DBMS
+ Nennen Sie 4 Nachteile eines NoSQL Repository im Gegensatz zu einem relationalen DBMS
+ Welche Schwierigkeiten ergeben sich bei der Zusammenführung der Daten?
+ Welche Arten von NoSQL Datenbanken gibt es?
+ Nennen Sie einen Vertreter für jede Art?
+ Beschreiben Sie die Abkürzungen CA, CP und AP in Bezug auf das CAP Theorem
+ Mit welchem Befehl koennen Sie die Teilzeiten eines Marathonlaeufers sortiert nach der Timingstations anzeigen.
+ Mit welchem Befehl koennen Sie die Teilzeiten eines Marathonlaeufers auf einer bestimmte Timing Stations (Bsp. 1) aendern?

## Quellen
