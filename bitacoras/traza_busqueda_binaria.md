# Traza de búsqueda binaria

Arreglo:

[0,1,2,3]

Objetivo:

3

| Paso | Inicio | Fin | Medio | Valor Medio | Acción |
|-------|--------|------|--------|-------------|---------|
| 1 | 0 | 3 | 1 | 1 | Buscar derecha |
| 2 | 2 | 3 | 2 | 2 | Buscar derecha |
| 3 | 3 | 3 | 3 | 3 | Encontrado |

## Conclusión

La búsqueda binaria reduce el espacio de búsqueda en cada iteración.

Cuando el valor medio es menor que el objetivo se busca hacia la derecha.

Cuando el valor medio es mayor que el objetivo se busca hacia la izquierda.

Gracias a esto el algoritmo tiene complejidad O(log n).