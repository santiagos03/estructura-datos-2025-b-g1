# Taller de Listas en Java

**Autor:** David Santiago Salazar Salazar  
**Curso:** Estructura de Datos  
**Fecha:** Septiembre 2025  

Este proyecto contiene implementaciones de listas en Java y varios ejercicios prácticos
para comprender su funcionamiento.

---

## 📂 Archivos principales
- `Nodo.java`: Clase base para la lista simple y circular.
- `ListaSimple.java`: Implementación de lista simplemente enlazada.
- `ListaDoble.java`: Implementación de lista doblemente enlazada.
- `ListaCircular.java`: Implementación de lista circular.
- `Ejercicio1.java` a `Ejercicio6.java`: Casos de prueba y ejemplos de aplicación.

---

## 📝 Análisis de cada ejercicio

### 🔹 Ejercicio 1 – Lista básica
- **Descripción**: Se crea una lista simple y se insertan elementos al final.
- **Objetivo**: Ver cómo se construye una lista de manera básica.
- **Resultado esperado**: La impresión de `[5, 10, 15]`.

---

### 🔹 Ejercicio 2 – Inserción múltiple
- **Descripción**: Se insertan varios elementos y se agrega un valor en una posición específica.
- **Objetivo**: Comprobar cómo funciona `insertarEnPosicion`.
- **Resultado esperado**: Lista ordenada `[1, 2, 3, 4]`.

---

### 🔹 Ejercicio 3 – Eliminación controlada
- **Descripción**: Se eliminan elementos de una posición dada.
- **Objetivo**: Validar que la lista maneje bien posiciones válidas e inválidas.
- **Resultado esperado**:
  - Antes: `[10, 20, 30]`
  - Después de eliminar en posición 1: `[10, 30]`
  - Intento de eliminar en posición inválida → `null`.

---

### 🔹 Ejercicio 4 – Lista doble
- **Descripción**: Se implementa una lista doblemente enlazada con inserción y eliminación en ambos extremos.
- **Objetivo**: Comparar recorrido hacia adelante y hacia atrás.
- **Resultado esperado**:
  - Forward: `[1, 2, 3]`
  - Backward: `[3, 2, 1]`
  - Eliminación de inicio → `1`
  - Eliminación de fin → `3`
  - Lista final: `[2]`.

---

### 🔹 Ejercicio 5 – Lista circular
- **Descripción**: Se implementa una lista circular que permite recorrer los elementos en bucle.
- **Objetivo**: Probar inserciones y eliminaciones en una lista sin final nulo.
- **Resultado esperado**:
  - Lista inicial: `[10, 5, 20, 30]`
  - Después de eliminar en posición 2 → `[10, 5, 30]`.

---

### 🔹 Ejercicio 6 – Cola de pacientes (aplicación práctica)
- **Descripción**: Se usa u
