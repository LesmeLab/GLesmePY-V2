# Trabajo Práctico 1: Buffer Gap e Historial de Edición

**Grupo:** `g_tq12`  
**Integrante:** Lesme Ortega, Gustavo Emanuel - **C.I.C.:** 5249373 - **Sección:** TQ  

**Declaración de Honor:**  
> Yo Gustavo Emanuel Lesme Ortega, no he discutido el código fuente de mi tarea con ningún otro grupo, 
	solo con el Profesor o el AER. 
	No he usado código obtenido de otro estudiante o de cualquier otra fuente no autorizada, modificada o no modificada. 
	Cualquier código o documentación utilizada en mi programa obtenido de fuentes, tales como libros o notas de curso, han sido claramente indicadas en mi tarea.

---

## 1. Decisiones de Diseño

### Ubicación del hueco al duplicar capacidad
Al alcanzar el límite del arreglo y requerir una duplicación de tamaño (`crecer()`), la estructura recoloca el nuevo espacio libre (*gap*) en la posición exacta del cursor de edición (`inicioHueco`). 

Los elementos previos a la posición del cursor permanecen en las mismas posiciones físicas iniciales ($0$ a $\text{inicioHueco} - 1$), mientras que los elementos posteriores se desplazan al final del nuevo arreglo ($nuevoFinHueco$ a $nuevaCapacidad - 1$). Esta decisión optimiza el patrón de acceso de un editor de texto real: como la mayoría de las inserciones suceden de forma consecutiva en la posición del cursor, mantener el hueco ahí evita desplazamientos mecánicos de datos en subsecuentes escrituras.

---

## 2. Criterio de Excepciones

* **`BufferVacioException` (Excepción Chequeada - extiende `Exception`):**
  Borrar un carácter con el cursor posicionado al inicio del texto representa una condición de borde totalmente previsible dentro del flujo interactivo normal (por ejemplo, el usuario presiona *Backspace* repetidamente). Al ser una excepción chequeada, Java obliga al código cliente a anticipar y capturar el evento de forma explícita sin interrumpir la ejecución del programa.

* **`PosicionInvalidaException` (Excepción No Chequeada - extiende `RuntimeException`):**
  Intentar mover el cursor a una posición negativa, fuera de los límites lógicos, o acceder a un índice inválido mediante `get()` o `set()` representa un error del desarrollador (violación de precondiciones). Al ser no chequeada, indica un *bug* en el programa cliente que debe corregirse en tiempo de desarrollo.

---

## 3. Tabla Comparativa de Desplazamientos

Resultados obtenidos al ejecutar 10.000 inserciones consecutivas en el medio de una secuencia de $N$ elementos (`TestBufferGap`):

| N | Desplazamientos BufferGap | Desplazamientos Arreglo Simple |
|---|---|---|
| 100000 | 0 | 500000000 |
| 200000 | 0 | 1000000000 |
| 1000000 | 0 | 5000000000 |

---

## 4. Análisis del Comportamiento

* **`BufferGap` ($O(1)$ amortizado en inserción focalizada):**
  Tras reubicar el cursor en la posición del medio ($N / 2$), el hueco (*gap*) queda directamente alineado con la posición de escritura. Como consecuencia, las 10.000 inserciones posteriores consumen el espacio disponible dentro del propio hueco sin requerir el movimiento físico de ningún elemento circundante, manteniendo el contador de desplazamientos en $0$.

* **`Arreglo Simple` ($O(N \cdot K)$ cuadrático):**
  Un arreglo contiguo carece de hueco móvil. Cada inserción individual en la posición intermedia obliga a trasladar manualmente hacia la derecha la mitad de los elementos ($N / 2$) para abrir un espacio de 1 elemento. Para $K = 10.000$ inserciones, el total de desplazamientos escala de forma directamente proporcional a $K \cdot (N / 2) = 5.000 \cdot N$, alcanzando miles de millones de operaciones mecánicas.