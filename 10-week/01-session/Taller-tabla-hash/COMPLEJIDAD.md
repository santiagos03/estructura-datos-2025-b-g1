# Análisis de Complejidad — Tabla Hash  
**Autor:** David Santiago Salazar  
**Fecha:** Octubre 2025  

---

## Operaciones Analizadas

| Operación | Promedio | Peor caso |
|------------|-----------|------------|
| **Insertar (`put`)** | O(1) | O(n) |
| **Buscar (`get`)** | O(1) | O(n) |
| **Eliminar (`remove`)** | O(1) | O(n) |

---

## xplicación Detallada

En una **tabla hash con encadenamiento**, cada clave se almacena en una posición del arreglo (cubeta) determinada por su función hash:

Cuando varias claves producen el mismo índice, se colocan en una **lista enlazada** dentro de esa cubeta (esto es una colisión).

---

### 🔹 Complejidad Promedio
- Si la función hash **distribuye uniformemente las claves**, el número promedio de elementos por cubeta es constante.  
- Por eso, las operaciones básicas (`put`, `get`, `remove`) tienen **tiempo promedio constante**, es decir **O(1)**.

---

### 🔹 Peor Caso
- Si **todas las claves caen en la misma cubeta**, la lista se convierte en una secuencia lineal de elementos.  
- En ese escenario, buscar, insertar o eliminar requiere recorrer todos los elementos ⇒ **O(n)**.

---

### 🔹 Espacio
- La tabla utiliza un arreglo principal de tamaño fijo (`capacity`) y múltiples nodos `Entry`.  
- En total, el espacio ocupado es **O(n)**, donde *n* es el número de pares clave–valor almacenados.

---

### Conclusión
- En promedio, una tabla hash es **extremadamente eficiente**, con operaciones constantes.  
- Sin embargo, en el peor de los casos (mala función hash o muchas colisiones), el rendimiento cae a **lineal**.  
- Esta implementación **no redimensiona automáticamente**, por lo que la eficiencia depende de mantener una buena distribución de claves.

---

**Autor:** David Santiago Salazar  

