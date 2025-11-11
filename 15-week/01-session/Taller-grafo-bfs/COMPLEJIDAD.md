Concepto | Complejidad |
|-----------|-------------|
| Estructura base (lista de adyacencia) | O(V + E) |
| Inserción de vértices/aristas | O(1) |
| Recorrido BFS | O(V + E) |
| Espacio total utilizado | O(V + E) |

Conclusión
- El algoritmo **BFS** tiene complejidad **lineal** respecto al tamaño del grafo.  
- Su rendimiento depende directamente del número de nodos y conexiones.  
- Es ideal para:
  - Encontrar caminos mínimos en grafos no ponderados.  
  - Verificar conectividad entre componentes.  
  - Recorrer redes o mapas de relaciones de manera eficiente.

El uso de una **lista de adyacencia** garantiza un almacenamiento compacto y un acceso eficiente a los vecinos de cada vértice, logrando un excelente balance entre tiempo y espacio.