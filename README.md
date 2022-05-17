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

  |                                                              | SQL-Datenbank                                                | NoSQL-Datenbank                                              |
  | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | Art                                                          | Eine Datenbank für alles                                     | Verschiedene Datenbankmodelle, wie z. B. Dokumenten-, Graph-, Key-Value- und Spaltendatenbank |
  | Datenspeicherung                                             | Individuelle Daten (z. B. „Buchtitel“) werden in Zeilen in einer  Tabelle gespeichert und bestimmten Attributen zugeordnet (z. B. „Autor“, „Erscheinungsjahr“ usw.). Die Datensätze werden in separaten Tabellen  gespeichert und bei komplexen Suchanfragen vom System zusammengeführt. | NoSQL-Datenbanken nutzen keine Tabellen, sondern je nach Typ ganze Dokumente, Key-Values, Graphen oder Spalten. |
  | Schemata                                                     | Datentyp und -struktur werden im Vorhinein festgelegt. Um neue  Informationen zu speichern, muss die gesamte Datenbank angepasst werden  (und zu diesem Zweck offline gehen). | Flexibel. Neue Datensätze können sofort hinzugefügt werden.  Strukturierte, halbstrukturierte und unstrukturierte Daten können  zusammen abgespeichert werden, eine vorherige Konvertierung ist nicht  notwendig. |
  | Skalierung                                                   | Vertikale Skalierung. Ein einzelner Server muss die Leistung des  kompletten Datenbanksystems tragen, was einen Leistungsabfall bei großen Datenmengen zur Folge hat. | Horizontale Skalierung. Jeder Administrator kann neue Commodity- und Cloud-Server hinzufügen, die NoSQL-Datenbank sendet die Daten  automatisch an alle Server. |
  | Entwicklungsmodell                                           | Open Source (z. B. MySQL) oder Bezahl-Software (Oracle Database) | Open Source oder Bezahl-Software                             |
  | ACID-Eigenschaften: Atomicity, Consistency, Isolation, Durability | Bei SQL-Datenbanken sind alle ACID-Eigenschaften gegeben.    | Damit NoSQL-Datenbanken flexibel und horizontal skalierbar bleiben,  werden ACID-Transaktionen meistens nicht unterstützt. Stattdessen wird  das BASE-Modell verwendet (Basically Available, Soft State, Eventually  Consistant). Demnach gilt: Verfügbarkeit vor Konsistenz. |
  | Leistung                                                     | Nutzen bei erhöhtem Datenaufkommen Indizes. Um die Leistung von  SQL-Systemen zu erhöhen, müssen Abfragen, Indizes und Struktur optimiert werden. | Durch das Nutzen von Cloud-Servern und Hardware-Clustern haben NoSQL-Datenbanken eine deutlich höhere Leistungsstärke. |
  | APIs                                                         | Abfragen zur Speicherung und zum Abrufen von Daten werden mit SQL (Structured Query Language) übermittelt. | Daten werden über objektbasierte APIs gespeichert und abgefragt. |

+ Welche Schwierigkeiten ergeben sich bei der Zusammenführung der Daten?

+ Welche Arten von NoSQL Datenbanken gibt es?

  > ### Dokumentenorientierte Datenbanken
  >
  > In [dokumentenorientierten NoSQL-Datenbanken](https://www.ionos.de/digitalguide/hosting/hosting-technik/dokumentenorientierte-datenbank/) werden Daten direkt in Dokumenten von variierender Länge gespeichert.  Die Daten müssen dabei nicht strukturiert sein. Ihnen werden  verschiedene **Attribute** oder sogenannte **„Tags“** zugeordnet, auf deren Basis die Inhalte des Dokuments durchsucht werden können. Dokumentenorientierte NoSQL-Datenbanken eignen sich besonders  gut für **Content-Management-Systeme** und **Blogs**. Als Datenformat wird heute vor allem **JSON** (**J**ava**S**cript **O**bject **N**otation) verwendet, das den schnellen Datenaustausch zwischen Anwendungen ermöglicht.
  >
  > ### Graphdatenbanken
  >
  > Eine [Graphdatenbank](https://www.ionos.de/digitalguide/hosting/hosting-technik/graphdatenbank/) bildet Beziehungen zwischen Daten mithilfe von Knoten und Kanten ab. Über **Knotenpunkte** und **deren Verbindungen zueinander** wird das Beziehungsgeflecht der Daten organisiert. Bei Datenbeständen  mit stark vernetzten Informationen erreichen NoSQL-Graphdatenbanken  dadurch eine deutlich bessere Performance als relationale  SQL-Datenbanken. Sie werden vor allem **im Bereich Social Media** angewendet – beispielsweise, um die Beziehungen zwischen Followern auf Twitter oder Instagram darzustellen.
  >
  > ### Key-Value-Datenbanken
  >
  > Während relationale SQL-Datenbanken starre Schemata und Tabellen nutzen, speichern [Key-Value-Datenbanken](https://www.ionos.de/digitalguide/hosting/hosting-technik/key-value-store/) Daten in Form von **Schlüssel-Werte-Paaren**. Die einzelnen Werte sind spezifischen Schlüsseln zugeordnet, wobei der  Datensatz selbst als Schlüssel (Key) fungiert und einen Wert (Value)  darstellt. Der Key bildet zugleich einen **Index**, mit dem sich die Datenbank durchsuchen lässt. Die Keys der  NoSQL-Key-Value-Datenbanken sind immer eindeutig und lassen sich mit den Primary Keys von relationalen Datenbanken vergleichen.
  >
  > ### Spaltenorientierte Datenbanken
  >
  > Anders als relationale Datenbankmodelle speichern [Spaltenorientierte Datenbanksysteme](https://www.ionos.de/digitalguide/hosting/hosting-technik/spaltenorientierte-datenbank/)**Datensätze nicht in Zeilen, sondern in Spalten**. Dadurch ergeben sich kürzere Datenleseprozesse und eine höhere Leistungsfähigkeit. Dieses NoSQL-Modell wird vor allem für **Data-Mining und Analyseprogramme** genutzt.

+ Nennen Sie einen Vertreter für jede Art?

  > **Key-Value:** Redis
  >
  > **Graphdatenbanken:** Neo4J
  >
  > **Spaltenorientiert:** MonetDB
  >
  > **Dokumentenorientierte:** MongoDB

+ Beschreiben Sie die Abkürzungen CA, CP und AP in Bezug auf das CAP Theorem

  > The CAP theorem is used to makes system designers aware of the  trade-offs while designing networked shared-data systems. CAP theorem  has influenced the design of many distributed data systems. It is very  important to understand the CAP theorem as It makes the basics of  choosing any NoSQL database based on the requirements.
  >
  > The CAP theorem categorizes systems into three categories:
  >
  > **CP (Consistent and Partition Tolerant) database:** A CP database delivers consistency and partition tolerance at the  expense of availability. When a partition occurs between any two nodes,  the system has to shut down the non-consistent node (i.e., make it  unavailable) until the partition is resolved.
  >
  > ***Partition\*** *refers to a communication break between nodes within a distributed  system. Meaning, if a node cannot receive any messages from another node in the system, there is a partition between the two nodes. Partition  could have been because of network failure, server crash, or any other  reason.*
  >
  > **AP (Available and Partition Tolerant) database:** An AP database delivers availability and partition tolerance at the  expense of consistency. When a partition occurs, all nodes remain  available but those at the wrong end of a partition might return an  older version of data than others. When the partition is resolved, the  AP databases typically resync the nodes to repair all inconsistencies in the system.
  >
  > **CA (Consistent and Available) database:** A CA delivers consistency and availability in the absence of any network  partition. Often a single node’s DB servers are categorized as CA  systems. Single node DB servers do not need to deal with partition  tolerance and are thus considered CA systems.
  >
  > ![Explained](https://miro.medium.com/max/946/1*xJu9RmHbIB30quVLhsUoqQ.png)

+ Mit welchem Befehl koennen Sie die Teilzeiten eines Marathonlaeufers sortiert nach der Timingstations anzeigen.

+ Mit welchem Befehl koennen Sie die Teilzeiten eines Marathonlaeufers auf einer bestimmte Timing Stations (Bsp. 1) aendern?

## Quellen

[1] https://www.ionos.de/digitalguide/hosting/hosting-technik/nosql/

[2] https://www.ionos.de/digitalguide/hosting/hosting-technik/graphdatenbank/

[3] https://datenbanken-verstehen.de/lexikon/spaltenorientierte-datenbanken/

[4] https://www.ionos.de/digitalguide/hosting/hosting-technik/dokumentenorientierte-datenbank/

[5] https://www.ionos.de/digitalguide/hosting/hosting-technik/spaltenorientierte-datenbank/

[6] https://medium.com/@kumar.barmanand/cap-theorem-and-nosql-databases-589e26e15905
