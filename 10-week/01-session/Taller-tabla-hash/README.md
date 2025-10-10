# Taller - Implementación básica de una Tabla Hash

**Materia:** Estructura de Datos  
**Unidad:** 2  
**Tema:** Tabla Hash con encadenamiento  
**Lenguaje:** Java  
**Autor:** David Santiago Salazar  

---

## Propósito

Implementar una **tabla hash genérica `<K, V>`** desde cero, entendiendo:

- Cómo se genera el índice a partir de la clave (función hash).  
- Cómo se manejan las **colisiones** usando listas encadenadas.  
- Cómo realizar operaciones de inserción, búsqueda y eliminación de forma eficiente.

---

## Estructura del proyecto
---
## Archivos principales
| Archivo | Descripción |
|----------|-------------|
| `Entry.java` | Nodo básico que almacena una pareja clave–valor y un puntero `next`. |
| `HashTable.java` | Implementa las operaciones principales de una tabla hash (put, get, remove, etc.). |
| `Ejercicio1.java` | Diccionario usuario → rol con menú en consola. |
| `Ejercicio2.java` | Contador de palabras usando `HashTable<String,Integer>`. |
| `Ejercicio3.java` | Prueba de colisiones controladas. |
| `Ejercicio4.java` | Inserción masiva para probar `size()` y rendimiento. |
---
## Cómo compilar y ejecutar
Desde la raíz del proyecto (donde está la carpeta `src`):
```bash
javac src/*.java -d out




