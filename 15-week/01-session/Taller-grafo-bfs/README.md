# Taller — Construcción de un Grafo y Recorrido BFS

**Asignatura:** Estructura de Datos  
**Docente:** Jesus Ariel Gonzalez Bonilla  
**Integrantes del grupo:**  
- David Santiago Salazar Salazar
- Cesar Augusto Tamayo Urriago

---

## Objetivo del Taller

El objetivo principal de este taller es **construir un grafo no dirigido en Java** e implementar el **algoritmo de búsqueda en anchura (BFS – Breadth-First Search)**, comprendiendo:

- Cómo se representan las relaciones entre nodos mediante listas de adyacencia.
- El funcionamiento del recorrido BFS por niveles.
- La eficiencia del algoritmo y su comparación con DFS (Depth-First Search).

Este taller busca desarrollar pensamiento lógico y dominio sobre estructuras dinámicas en Java, aplicando conceptos de recorridos y conectividad en grafos.

---

## Descripción general

El grafo se implementa en una clase llamada `Graph`, que contiene los métodos principales:

| Método | Descripción |
|---------|--------------|
| `addVertex(String v)` | Agrega un vértice al grafo si no existe. |
| `addEdge(String v1, String v2)` | Crea una conexión (arista) entre dos vértices, en ambos sentidos (grafo no dirigido). |
| `bfs(String start)` | Realiza un recorrido en anchura (BFS) desde un nodo inicial. |

El recorrido BFS utiliza una **cola (Queue)** para explorar los nodos **nivel por nivel**, asegurando que todos los vecinos de un vértice se visiten antes de pasar al siguiente nivel.

---

## Desarrollo de los ejercicios

### Ejercicio 1 — Red Social Simple
Se modeló una red social donde **cada usuario es un nodo** y **cada amistad es una arista**.  
Se realiza un recorrido BFS desde un usuario inicial para determinar el orden en que se visitan sus conexiones.

**Ejemplo de salida:**
**Interpretación:**  
Ana está conectada directamente con Luis y Sofía; luego, por ellos, se alcanzan Carlos y Marta.

---

### 🗺️ Ejercicio 2 — Mapa de Ciudades
Cada ciudad representa un nodo y las carreteras entre ellas son aristas.  
El recorrido BFS muestra las ciudades alcanzables desde una ciudad de origen, ordenadas por niveles de conexión.

**Ejemplo de salida:**
**Interpretación:**  
Desde Bogotá se llega primero a Medellín y Cali, y luego a las demás ciudades conectadas indirectamente.

---

### 🔗 Ejercicio 3 — Componentes Conexos
Se construyó un grafo con **dos componentes no conectados**.  
Esto permite observar que BFS solo recorre el componente en el que se inicia el recorrido.

**Ejemplo de salida:**
**Interpretación:**  
BFS no puede alcanzar los nodos de otro componente desconectado; solo explora los que están en la misma red de conexiones.

---

### 🔍 Ejercicio 4 — Comparación con DFS
Se implementó también el algoritmo **DFS (Depth-First Search)** y se comparó su recorrido con BFS.

**Ejemplo de salida:**
**Interpretación:**  
- **BFS:** recorre por niveles (anchura).  
- **DFS:** recorre en profundidad, explorando un camino hasta el final antes de retroceder.