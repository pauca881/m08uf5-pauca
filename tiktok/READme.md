# Exercici 6: Vídeos TikTok amb Comparable vs Comparator + Sort

## Objectiu

Els objectius d'aquest exercici són:

- Utilitzar les interfícies `Comparable` i `Comparator` per establir diferents criteris d’ordenació dels objectes d’una classe: ordenació natural i altres criteris d’ordenació.
- Utilitzar el mètode `sort` de la classe `Collections` per ordenar llistes de vídeos.
- Consolidar l’ús de les tres opcions per recórrer una `List`: `LinkedList` o `ArrayList`.

## Enunciat

Ets el desenvolupador d'un sistema que gestiona un llistat de vídeos de TikTok. Cada vídeo té les següents propietats:

- **Id**: Numeric, no accessible (no es pot modificar), ni per consultar el valor. Aquest identificador és únic per cada vídeo.
- **usuari** (`String`): Nom d'usuari del creador del vídeo.
- **titol** (`String`): Títol o descripció curta del vídeo.
- **likes** (`int`): Quantitat de "M'agrada" que ha rebut el vídeo.
- **durada** (`double`): Duració del vídeo en segons.

Pel que fa a aquests atributs, és important que pensem quins d'ells haurien de tenir setters i quins no. Els setters no han d'existir per l'`id`, ja que aquest atribut és únic i no ha de ser modificable per l'usuari. A més, com que `likes` és un atribut que canvia a mesura que el vídeo rep més "m'agrada", aquest sí que ha de poder modificar-se, mentre que la durada i el títol també podrien ser configurables, depenent de la lògica de l'aplicació. Es recomana documentar al codi quins setters no es posen i justificar-ho adequadament.

## Tasques a realitzar

1. **Implementació de la classe `VideoTikTok`**:
   - Implementa la classe `VideoTikTok` que implementi `Comparable<VideoTikTok>` per ordenar els vídeos de forma natural per nombre de "M'agrada" (de menys a més popular).
   - Un vídeo es considera igual a un altre si té el mateix usuari, títol i duració.

2. **Creació de dos `Comparator`**:
   - Crea un `Comparator` per ordenar els vídeos per durada (de més curt a més llarg).
   - Crea un altre `Comparator` per ordenar els vídeos per títol (ordre alfabètic).

3. **Classe DAO (Data Access Object)**:
   - Implementa la classe DAO amb els següents mètodes:
     - **RetornarIdMaxim**: Retorna l'`id` més gran de tots els vídeos existents. Si no en té cap, retorna el valor 1.
     - **AfegirVideo**: Afegeix un nou vídeo a la llista. Si el vídeo ja existeix, assigna un nou `id` utilitzant la funció anterior.
     - **EliminarVideo**: Elimina el primer vídeo de la llista.
     - **LlistarVideosUsuariPopulars**: Rep un usuari i retorna un llistat amb els vídeos d’aquest usuari, ordenats del més popular al menys popular (per nombre de "M'agrada").
     - **LlistarVideosUsuariTitol**: Rep un usuari i retorna un llistat amb els vídeos d’aquest usuari, ordenats per títol alfabètic.
     - **LlistarVideosDurada**: Rep un usuari i retorna un llistat amb els vídeos d’aquest usuari, ordenats per durada.

4. **Mètodes de modificació**:
   - Afegeix un mètode `modificarVideo` per permetre que els atributs del vídeo que es poden canviar (com el títol, la durada i els "M'agrada") es puguin modificar.
   - Fes una valoració sobre la idoneïtat de programar un mètode per substituir un vídeo complet per un altre, com es fa en TikTok. Si és necessari, implementa aquest mètode.

5. **Recorreguts de llistats**:
   - Per mostrar els vídeos dels tres mètodes de llistat (`LlistarVideosUsuariPopulars`, `LlistarVideosUsuariTitol` i `LlistarVideosDurada`), utilitza tres tipus de recorreguts diferents:
     - Un recorregut amb un **for-each**.
     - Un recorregut amb un **for clàssic** utilitzant `get()`.
     - Un recorregut amb un **Iterator**.

## Pregunta de Reflexió

Si estem treballant per a l’aplicació TikTok, té sentit programar un mètode que substitueixi un vídeo sencer per un altre? Reflexiona sobre aquesta pregunta i documenta la teva resposta al codi. Pot ser una funcionalitat útil en certs casos, però també podria generar conflictes amb la identitat del vídeo, especialment si estem parlant de metadades com l'`id` o la quantitat de "M'agrada".

