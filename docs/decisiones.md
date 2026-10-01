# Decisiones de diseño — Semana 3

## Búsqueda binaria por timestamp

### Precondición

La búsqueda binaria requiere que las lecturas estén ordenadas ascendentemente por timestamp.

### Condición actual del proyecto

GeneradorDatos produce timestamps en orden cronológico ascendente.

### Decisión

Utilizar búsqueda binaria para consultas por timestamp.

### Justificación

La búsqueda binaria reduce significativamente la cantidad de comparaciones necesarias para encontrar una lectura.

Mientras la búsqueda lineal tiene complejidad O(n), la búsqueda binaria tiene complejidad O(log n).

Los resultados experimentales obtenidos fueron:

- 1.000 lecturas → 10 comparaciones
- 100.000 lecturas → 17 comparaciones
- 1.000.000 lecturas → 20 comparaciones

Esto demuestra que la búsqueda binaria es más eficiente cuando se cumple la precondición de ordenamiento.

## PM2.5

No se utilizará búsqueda binaria directamente sobre PM2.5 mientras los datos no estén ordenados por dicho campo.

El experimento realizado mostró que la búsqueda binaria encontró 0 de 20 valores existentes.

Esto demuestra que un algoritmo correcto puede producir resultados incorrectos si no se cumplen sus precondiciones.

## Comparación de String

Los timestamps y los identificadores de estación se comparan mediante equals() y no mediante ==.

equals() compara el contenido de las cadenas, mientras que == compara referencias en memoria.

## Medición de eficiencia

La principal medida utilizada fue el número de comparaciones realizadas por cada algoritmo.

También se registró el tiempo de ejecución como evidencia experimental complementaria.

## Pregunta pendiente

¿Conviene ordenar los datos antes de realizar las búsquedas?

Esta pregunta será abordada durante la Semana 4, cuando se estudien algoritmos de ordenamiento.

# DEC-04 — Pivote de QuickSort

**Semana:** 4

**Problema:**

QuickSort con pivote fijo puede producir particiones muy desbalanceadas cuando los datos ya están ordenados cronológicamente.

**Alternativas:**

- Pivote aleatorio.
- Mediana de tres.

**Decisión:**

Utilizar pivote aleatorio.

**Justificación:**

Después de modificar el algoritmo, QuickSort funcionó correctamente tanto con 50.000 lecturas desordenadas como con 50.000 lecturas ordenadas cronológicamente.

Resultados obtenidos:

- Datos desordenados:
    - Comparaciones: 993.477
    - Intercambios: 594.968

- Datos ordenados:
    - Comparaciones: 920.810
    - Intercambios: 501.692

No se produjo StackOverflowError.

**Consecuencia:**

El algoritmo mantiene un comportamiento estable incluso cuando las lecturas llegan ordenadas desde la red de sensores.

---

# DEC-05 — Ordenamiento y búsqueda

**Semana:** 4

**Problema:**

Ordenar las lecturas por PM2.5 destruye el orden por timestamp que necesita la búsqueda binaria.

**Alternativas:**

- Trabajar con una copia.
- Restaurar el orden original después del ranking.
- Mantener índices separados.

**Decisión:**

Conservar el orden por timestamp para las consultas y utilizar una copia cuando sea necesario generar rankings por PM2.5.

**Justificación:**

En el Experimento 5 se observó que:

Antes de ordenar:

- Ordenado por timestamp: true
- Búsqueda binaria: posición 73412

Después de ordenar por PM2.5:

- Ordenado por timestamp: false
- Búsqueda binaria: posición -1
- Búsqueda lineal: posición 87753

La lectura seguía existiendo, pero la búsqueda binaria dejó de funcionar porque perdió su precondición.

**Consecuencia:**

Se evita romper las consultas binarias por timestamp al generar reportes ordenados por PM2.5.