# Bitacora individual - Semana 3

> Copia este archivo y renombralo como `s03-ana-sofia-quintero-prado.md`.
> Completa todas las secciones con tus propias palabras. Esta bitacora es
> individual, aunque el codigo pueda haberse construido en equipo.

## 1. Datos de la actividad

- **Estudiante:** Ana Sofia Quintero Prado
- **Equipo:** No aplica
- **Semana:** 3
- **Fecha del laboratorio:** 2026-09-28
- **Fecha del taller:** 2026-09-28
- **Tema principal:** Busqueda lineal, busqueda binaria y analisis de eficiencia.
- **Pregunta de la semana:** ¿Como encontrar una lectura especifica cuando el repositorio contiene cientos de miles o millones de registros?

## 2. Prediccion antes de ejecutar

Antes de abrir o ejecutar el programa, responde:

1. **Que creo que va a ocurrir?**

   Creo que la busqueda lineal encontrara correctamente los datos buscados, pero necesitara recorrer muchos elementos cuando el conjunto de datos sea grande. Tambien creo que la busqueda binaria realizara muchas menos comparaciones porque divide el espacio de busqueda en cada paso.

2. **Que parte del programa o del algoritmo puede fallar?**

   La busqueda binaria puede fallar cuando los datos no se encuentran ordenados por el campo utilizado para buscar. Tambien podria haber errores si las variables inicio y fin no se actualizan correctamente dentro del ciclo.

3. **Como comprobare mi prediccion?**

   Ejecutare los experimentos de la Semana 3 utilizando diferentes tamaños de datos y comparare la cantidad de comparaciones realizadas por los algoritmos de busqueda lineal y binaria.

## 3. Evidencia del laboratorio

### Resultado observado

Al ejecutar el programa se procesaron correctamente las lecturas ambientales del archivo CSV.

Resultados de la ingesta:

- Lecturas almacenadas: 201
- Descartadas por formato: 2
- Descartadas por rango: 8
- PM2.5 promedio: 17.050746268656724

Resultados de la busqueda lineal:

- 1000 lecturas → 1000 comparaciones
- 100000 lecturas → 100000 comparaciones
- 1000000 lecturas → 1000000 comparaciones

Resultados de la busqueda binaria:

- 1000 lecturas → 10 comparaciones
- 100000 lecturas → 17 comparaciones
- 1000000 lecturas → 20 comparaciones

Resultados del experimento PM2.5:

- Aciertos de busqueda binaria por PM2.5: 0 de 20

### Diferencia entre la prediccion y el resultado

La prediccion fue correcta. La busqueda lineal aumento proporcionalmente con el tamaño de los datos, mientras que la busqueda binaria utilizo muy pocas comparaciones incluso para arreglos muy grandes. Tambien se comprobo que la busqueda binaria puede fallar cuando los datos no cumplen la condicion de estar ordenados.

### Error o comportamiento inesperado

- **Que ocurrio?** La busqueda binaria por PM2.5 no encontro valores que realmente existian dentro del arreglo.
- **Por que ocurrio?** Porque los datos estaban ordenados por timestamp y no por PM2.5. La precondicion de la busqueda binaria no se cumplia.
- **Como lo corregimos o que falta corregir?** Para utilizar busqueda binaria por PM2.5 seria necesario ordenar previamente los datos segun ese atributo.

## 4. Explicacion en lenguaje llano

La busqueda lineal consiste en revisar un elemento a la vez hasta encontrar el dato que se necesita. La busqueda binaria es mas rapida porque empieza buscando en la mitad y va descartando secciones completas. De esta forma necesita muchas menos comparaciones para encontrar la informacion cuando los datos estan ordenados.

### Ejemplo o analogia

Es como buscar una palabra en un diccionario. Si leo pagina por pagina realizo una busqueda lineal. Si abro el diccionario por la mitad y voy descartando secciones hago una busqueda binaria. La analogia deja de ser exacta porque un diccionario siempre esta ordenado, mientras que los datos de un sistema pueden no estarlo.

## 5. El vacio que encontre

Al intentar explicar el tema, identifica el punto que aun no comprendes bien.

- **Mi duda concreta es:** ¿Como puede un sistema realizar busquedas eficientes sobre varios atributos diferentes sin tener que ordenar los datos constantemente?
- **Lo que ya puedo explicar es:** La busqueda binaria requiere que los datos esten ordenados segun el atributo utilizado para la busqueda.
- **Para resolver la duda consulte:** La guia de la semana, el codigo implementado y los resultados obtenidos en los experimentos.
- **Ahora lo entiendo asi:** Si los datos no estan ordenados por el atributo buscado, la busqueda binaria puede entregar resultados incorrectos aunque el dato exista.

## 6. Trazado de la solucion

Escoge una ejecucion, recorrido o caso representativo y trazalo paso a paso.

| Paso | Estado de los datos o estructura | Decision o resultado |
|---|---|---|
| 1 | inicio = 0, fin = 3, medio = 1 | El valor medio es 1 y se busca el 3 |
| 2 | Como 1 < 3 | Se descarta la mitad izquierda y se busca a la derecha |
| 3 | inicio = 2, fin = 3, medio = 2 | El valor medio es 2 |
| 4 | Como 2 < 3 | Se vuelve a buscar a la derecha |
| 5 | inicio = 3, fin = 3, medio = 3 | El valor medio coincide con el objetivo |
| 6 | Valor encontrado | La busqueda termina correctamente |

## 7. Decision de diseño

Relaciona lo aprendido con la Plataforma de Monitoreo Ambiental Urbano.

- **Problema que debiamos resolver:** Encontrar lecturas especificas dentro de grandes cantidades de datos de sensores.
- **Estructura, algoritmo o estrategia elegida:** Busqueda lineal y busqueda binaria por timestamp.
- **Alternativa descartada:** Utilizar solamente busqueda lineal para todos los casos.
- **Por que elegimos la primera:** La busqueda binaria reduce drasticamente la cantidad de comparaciones necesarias cuando los datos estan ordenados.
- **Que evidencia respalda la decision:** Para un millon de lecturas la busqueda lineal realizo un millon de comparaciones mientras que la busqueda binaria solo realizo veinte.

## 8. Aporte al proyecto

- **Archivo(s) o modulo(s) trabajado(s):** BuscadorLecturas.java, GeneradorDatos.java, BancoDePruebas.java e IngestaSensores.java.
- **Cambio realizado:** Implementacion de algoritmos de busqueda lineal y binaria, generacion de datos sinteticos y ejecucion de experimentos de eficiencia.
- **Como se conecta con la capa anterior:** Utiliza las estructuras y datos construidos en las semanas anteriores para realizar consultas eficientes.
- **Que queda pendiente para la siguiente semana:** Implementar algoritmos de ordenamiento y estudiar su costo computacional.

## 9. Commits realizados

Registra los commits que muestran tu aporte individual.

| Commit | Mensaje | Que demuestra |
|---|---|---|
| `[hash corto]` | `feat: crea buscador de lecturas` | Implementacion de los algoritmos de busqueda |
| `[hash corto]` | `feat: agrega generador de datos y experimentos` | Creacion de datos sinteticos y pruebas de eficiencia |

## 10. Reexplicacion final

> La busqueda lineal revisa cada elemento hasta encontrar el dato y presenta un comportamiento O(n). La busqueda binaria reduce continuamente el espacio de busqueda y presenta un comportamiento O(log n), pero requiere que los datos esten ordenados. Los experimentos realizados demostraron que la busqueda binaria es mucho mas eficiente cuando se cumple esa condicion.

## 11. Reflexion individual

Responde con honestidad:

1. **Lo que ahora puedo hacer y antes no podia:**

   Implementar y comparar algoritmos de busqueda utilizando mediciones de eficiencia.

2. **El error o supuesto que mas me enseno:**

   Pensar que la busqueda binaria funcionaria correctamente aunque los datos no estuvieran ordenados.

3. **La pregunta que llevaria a la proxima clase:**

   ¿Que algoritmo de ordenamiento resulta mas conveniente para preparar los datos antes de aplicar una busqueda binaria?

4. **Que parte del trabajo fue realmente mia:**

   La implementacion de las clases de busqueda, la ejecucion de los experimentos y el analisis de los resultados obtenidos.

## Lista de verificacion antes de entregar

- [x] Escribi la prediccion antes de consultar el resultado.
- [x] Inclui evidencia concreta del laboratorio.
- [x] Explique un concepto sin depender de jerga.
- [x] Registre un vacio, una duda o un error real.
- [x] Trace al menos un caso paso a paso.
- [x] Justifique una decision del proyecto y una alternativa descartada.
- [x] Registre mis commits y mi aporte individual.
- [x] Deje claro que queda pendiente.
- [x] Renombre el archivo con el formato `sXX-nombre.md`.