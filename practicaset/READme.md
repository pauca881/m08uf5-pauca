# Gestió de Persones. Set, hashSet, LinkedHashSet, TreeSet, interseccions

Aquest projecte consisteix en una llista de persones amb el seu nom, nota final i edat. La idea és gestionar aquestes dades a través d'una llista d'objectes (ArrayList) i crear conjunts (`Set`) per fer diferents filtrats.

## Persones

Es creen 10 persones amb les següents característiques:

- **Nom**: Nom de la persona (ignora les majúscules).
- **Nota final**: Un valor aleatori entre 1 i 10.
- **Edat**: Un valor aleatori entre 16 i 25 anys.

## Conjunts

Es creen els següents conjunts:

1. **Aprovats**: Conjunt de persones que han aprovat (nota final >= 5).
2. **No aprovats**: Conjunt de persones que no han aprovat (nota final < 5).
3. **Menors d'edat**: Conjunt de persones amb edat < 18.
4. **Majors d'edat**: Conjunt de persones amb edat >= 18.

## Operacions

- **Menors d'edat que han aprovat**: Trobar aquells menors d'edat que tenen una nota final >= 5.
- **Majors d'edat que no han aprovat**: Trobar aquells majors d'edat que tenen una nota final < 5.
- **Menors que no han aprovat**: Usant els conjunts de menors d'edat i no aprovats, trobar aquells menors que no han aprovat.
