# GRUPPÖVNING

# Rymdstation 404

Bygg en liten Java-simulering tillsammans och rädda stationen innan tiden tar slut.

## UPPDRAGET

Rymdstation 404 har tappat kontrollen över flera sektioner. Syret sjunker, dörrar har låst sig och reaktorn håller på att stänga ner. Er grupp ska bygga ett Java-program som simulerar ett räddningsteam som tar sig genom stationen och löser problemen. Programmet behöver inte vara stort – fokus ligger på att använda kursens byggstenar på ett genomtänkt sätt.

## Så arbetar ni

Arbeta i samma kodbas. En person är ”driver” och skriver, resten diskuterar, granskar och föreslår lösningar. Byt driver ungefär var 20:e minut. Poängen är att ni ska kunna förklara lösningen tillsammans – inte dela upp uppgiften i fyra separata delar.

- Använd ett Git/GitHub-repository på det sätt ni brukar arbeta i kursen.
- Gör minst tre meningsfulla commits under arbetet, inte bara en stor commit på slutet.
- Kör programmet ofta. När något går fel: läs felmeddelandet tillsammans innan ni ändrar kod.
- Ni får välja egna klassnamn, variabelnamn och detaljer. Kraven nedan beskriver vad programmet ska kunna, inte exakt hur koden måste se ut.

## Stationen

```text
[ START ]  ->  [ LUFTSLUSS ]  ->  [ LABB ]  ->  [ REAKTOR ]
```

Räddningsteamet ska ta sig genom stationens sektioner i ordning. Varje sektion har ett problem som påverkar teamet eller måste lösas innan de kan gå vidare. Exempel:

- Luftslussen läcker syre och kostar energi.
- Labbet är låst och kräver rätt typ av teammedlem eller en viss mängd energi.
- Reaktorn måste repareras för att uppdraget ska lyckas.

## Programmet måste innehålla

- **Variabler, typer och operatorer:** Använd till exempel namn, energi, skada, poäng eller alarmnivå. Minst en beräkning ska förändra ett värde under simuleringen.
- **Control Flow:** Använd if/else och minst en loop eller switch för att styra vad som händer i stationen.
- **Klasser och objekt:** Modellera minst två saker i programmet som egna klasser, till exempel teammedlemmar, sektioner eller stationen.
- **Metoder:** Flytta ut beteenden till metoder. Main ska starta och styra simuleringen, inte innehålla all logik.
- **Array:** Lagra flera objekt eller värden i en array och använd programmet för att arbeta med innehållet.
- **Enum:** Använd en enum för något med ett begränsat antal lägen, till exempel sektionstyp, status eller roll.
- **Arv:** Ha en parent class och minst två subklasser. Subklasserna ska skilja sig på något sätt i beteende eller data.
- **Abstrakt klass eller abstrakt metod:** Minst en del av er modell ska vara abstrakt och behöva konkretiseras i en subklass.
- **Interface:** Skapa ett beteende som olika typer kan implementera. Visa att samma metod kan arbeta med objekt av olika typer genom interfacets typ.
- **Polymorfism:** Någonstans ska ett objekt kunna behandlas som en mer generell typ, till exempel en subklass som sin parent class eller ett objekt som ett interface.

## Tre händelser som måste finnas

- En sektion där ett värde förändras med hjälp av operatorer och ett villkor avgör vad som händer.
- En sektion där programmet använder er enum tillsammans med switch eller if/else för att välja beteende.
- En slutsektion där polymorfism spelar roll – exempelvis att ett generellt Repairable-, CrewMember- eller liknande värde kan representera flera konkreta objekt.

## Planering

- Skissa programmet. Bestäm klasser, enum, interface och vad som ska ligga i arrayen. Skapa repo/projekt och första commit.
- Bygg grundmodellen: variabler, klasser, konstruktorer och metoder. Få ett enkelt flöde att köra från start till slut.
- Lägg till stationens händelser med control flow, array och enum. Testa efter varje del.
- Lägg till arv, abstrakt del, interface och polymorfism. Försök återanvända samma metod för flera konkreta typer.
- Bug hunt: kör flera scenarier, kontrollera utskrifter och städa bort onödigt duplicerad kod.
- Push till GitHub och förbered en 60-sekunders demo där alla i gruppen kan förklara minst en del av lösningen.

## När ni tycker att ni är klara

- Programmet kompilerar och kör utan att ni behöver kommentera bort delar av lösningen.
- Ni kan peka ut var variabler/operatorer, control flow, klasser, metoder, array och enum används.
- Ni kan förklara skillnaden mellan parent class och subklass i er egen kod.
- Ni kan förklara varför ni valde ett interface och vilka klasser som implementerar det.
- Ni kan visa ett konkret exempel på polymorfism i er lösning.
- Alla i gruppen kan förklara minst en klass eller metod utan att läsa innantill.
- Koden finns pushad till GitHub med flera commits.

## Om ni blir klara tidigt – välj EN twist

**Blackout:** Lägg till ytterligare en sektion där samma kod måste fungera för flera typer av teammedlemmar.

**Nytt team:** Lägg till en tredje subklass med ett beteende som skiljer sig från de andra.

**Dubbel reparation:** Skapa två helt olika objekt som båda kan behandlas genom samma interface och låt samma metod hantera båda.

**Svårare final:** Uppdraget ska kunna misslyckas på minst två olika sätt, inte bara lyckas.

Infotiv Intern
