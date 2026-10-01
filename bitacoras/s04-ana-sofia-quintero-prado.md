# Bitacora individual - Semana 4

## 1. Datos de la actividad

- **Estudiante:** Ana Sofia Quintero Prado
- **Equipo:** No aplica
- **Semana:** 4
- **Fecha del laboratorio:** 2026-10-05
- **Fecha del taller:** 2026-10-05
- **Tema principal:** Algoritmos de ordenamiento y comparación de eficiencia.
- **Pregunta de la semana:** ¿Qué algoritmo de ordenamiento tiene más sentido según las características de los datos y del problema?

---

## 2. Prediccion antes de ejecutar

### ¿Qué creo que va a ocurrir?

Creo que los algoritmos avanzados como MergeSort, HeapSort y QuickSort realizarán menos comparaciones que los algoritmos simples cuando el tamaño de los datos aumente. También creo que Inserción puede comportarse mejor cuando los datos ya están ordenados.

### ¿Qué parte del programa o del algoritmo puede fallar?

QuickSort podría presentar problemas si utiliza siempre el mismo pivote y los datos llegan previamente ordenados. También quiero comprobar si Burbuja continúa recorriendo el arreglo aun cuando ya está ordenado.

### ¿Cómo comprobaré mi predicción?

Ejecutaré los cinco experimentos de BancoDeOrdenamiento y compararé las métricas de comparaciones, intercambios y tiempo.

---

## 3. Evidencia del laboratorio

### Resultado observado

Se ejecutaron correctamente los cinco experimentos de ordenamiento.

Experimento 1:

- Burbuja: 49.990.814 comparaciones.
- Selección: 49.995.000 comparaciones.
- Inserción: 24.938.233 comparaciones.

Experimento 2:

- Burbuja: 9.999 comparaciones.
- Selección: 49.995.000 comparaciones.
- Inserción: 9.999 comparaciones.

Experimento 3:

Con 100.000 lecturas:

- Inserción: 2.497.222.762 comparaciones.
- MergeSort: 1.536.325 comparaciones.
- HeapSort: 3.019.556 comparaciones.

Experimento 4:

QuickSort funcionó correctamente con datos desordenados y datos ordenados gracias al cambio de pivote.

Experimento 5:

- Antes de ordenar por PM2.5:
    - Ordenado por timestamp: true.
    - Búsqueda binaria: posición 73412.

- Después de ordenar por PM2.5:
    - Ordenado por timestamp: false.
    - Búsqueda binaria: posición -1.
    - Búsqueda lineal: posición 87753.

### Diferencia entre la predicción y el resultado

La predicción fue correcta. Los algoritmos avanzados crecieron mucho más lentamente que Inserción cuando aumentó el tamaño de los datos. También se comprobó que Inserción funciona muy bien con datos previamente ordenados.

### Error o comportamiento inesperado

- **¿Qué ocurrió?** QuickSort podía presentar problemas cuando los datos ya estaban ordenados.
- **¿Por qué ocurrió?** El pivote fijo producía particiones muy desbalanceadas.
- **¿Cómo lo corregimos o qué falta corregir?** Se implementó un pivote aleatorio, evitando el problema.

---

## 4. Explicación en lenguaje llano

Ordenar significa acomodar los datos siguiendo una regla específica. Existen varios algoritmos para hacerlo y todos logran ordenar, pero algunos necesitan mucho más trabajo que otros. Cuando la cantidad de datos crece, estas diferencias se vuelven muy importantes.

### Ejemplo o analogía

Es como organizar una pila de cartas. Algunas personas comparan las cartas una por una hasta dejarlas bien ubicadas, mientras que otras dividen la pila en grupos pequeños y luego los unen ordenadamente. Al final el resultado es el mismo, pero algunas estrategias requieren mucho menos esfuerzo.

---

## 5. El vacío que encontré

- **Mi duda concreta es:** ¿Cuál sería la mejor estrategia para mantener simultáneamente varios criterios de ordenamiento sin afectar las búsquedas?
- **Lo que ya puedo explicar es:** Cómo funcionan Burbuja, Selección, Inserción, MergeSort, HeapSort y QuickSort.
- **Para resolver la duda consulté:** La guía, los experimentos y los resultados obtenidos.
- **Ahora lo entiendo así:** Cada criterio de ordenamiento puede afectar otros procesos del sistema, por lo que es importante pensar en la arquitectura completa y no solo en un algoritmo aislado.

---

## 6. Trazado de la solución

| Paso | Estado de los datos o estructura | Decisión o resultado |
|---|---|---|
| 1 | Datos ordenados por timestamp | La búsqueda binaria funciona |
| 2 | Se solicita ranking por PM2.5 | Se ordena el arreglo por PM2.5 |
| 3 | El orden por timestamp desaparece | La búsqueda binaria pierde su precondición |
| 4 | Nueva búsqueda por timestamp | La búsqueda binaria falla |
| 5 | Verificación con búsqueda lineal | El dato sigue existiendo |
| 6 | Conclusión | Ordenar por otro criterio afectó el funcionamiento de la búsqueda binaria |

---

## 7. Decisión de diseño

- **Problema que debíamos resolver:** Ordenar grandes cantidades de lecturas sin afectar el funcionamiento del sistema.
- **Estructura, algoritmo o estrategia elegida:** Pivote aleatorio para QuickSort y preservación del orden cronológico para las búsquedas.
- **Alternativa descartada:** Mantener un pivote fijo en QuickSort.
- **Por qué elegimos la primera:** Reduce el riesgo de particiones desbalanceadas y mejora el comportamiento del algoritmo.
- **Qué evidencia respalda la decisión:** QuickSort funcionó correctamente con 50.000 lecturas ordenadas y desordenadas sin producir errores.

---

## 8. Aporte al proyecto

- **Archivo(s) o módulo(s) trabajado(s):** Ordenador.java, BancoDeOrdenamiento.java y docs/decisiones.md.
- **Cambio realizado:** Implementación y análisis de algoritmos de ordenamiento, corrección de Burbuja y QuickSort.
- **Cómo se conecta con la capa anterior:** Utiliza los datos generados durante las semanas anteriores para realizar pruebas de ordenamiento y búsqueda.
- **Qué queda pendiente para la siguiente semana:** Continuar ampliando la plataforma y explorar nuevas estructuras de datos.

---

## 9. Commits realizados

| Commit | Mensaje | Qué demuestra |
|---|---|---|
| [hash] | feat: implementar ordenamientos simples | Burbuja, Selección e Inserción |
| [hash] | fix: agregar corte temprano a burbuja | Resolución del TODO 1 |
| [hash] | feat: implementar algoritmos avanzados | MergeSort, HeapSort y QuickSort |
| [hash] | docs: actualizar decisiones semana 4 | Registro de decisiones técnicas |

---

## 10. Reexplicación final

Los algoritmos de ordenamiento producen el mismo resultado, pero tienen costos diferentes. Los experimentos mostraron que los algoritmos O(n log n), como MergeSort, HeapSort y QuickSort, escalan mucho mejor que los algoritmos O(n²) cuando aumenta la cantidad de datos. También comprobé que ordenar por un criterio diferente puede afectar otros módulos del sistema, como la búsqueda binaria.

---

## 11. Reflexión individual

1. **Lo que ahora puedo hacer y antes no podía:**

   Comparar algoritmos de ordenamiento utilizando métricas reales de rendimiento.

2. **El error o supuesto que más me enseñó:**

   Pensar que ordenar datos solo afecta al módulo de ordenamiento y no a otros componentes del sistema.

3. **La pregunta que llevaría a la próxima clase:**

   ¿Cómo mantener varios criterios de ordenamiento sin perder eficiencia en las búsquedas?

4. **Qué parte del trabajo fue realmente mía:**

   La corrección de Burbuja, la mejora de QuickSort, la ejecución de los experimentos y el análisis de los resultados obtenidos.

---

## Lista de verificación antes de entregar

- [x] Escribí la predicción antes de consultar el resultado.
- [x] Incluí evidencia concreta del laboratorio.
- [x] Expliqué un concepto sin depender de jerga.
- [x] Registré un vacío, una duda o un error real.
- [x] Tracé un caso paso a paso.
- [x] Justifiqué una decisión del proyecto y una alternativa descartada.
- [x] Registré mis commits y mi aporte individual.
- [x] Dejé claro qué queda pendiente.
- [x] Renombré el archivo con el formato correcto.