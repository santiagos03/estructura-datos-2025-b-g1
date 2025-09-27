# Taller de ArrayList en Java

**Clase:** Estructura de datos
**Estudiante:** David Santiago Salazar Salzar

---

## Objetivo del taller

El objetivo de este taller es aplicar los conceptos fundamentales de la programación orientada a objetos en Java y el uso de estructuras dinámicas de almacenamiento, específicamente la clase **`ArrayList`**, para gestionar colecciones de objetos.

Con este ejercicio se busca:

* Reforzar la creación de clases con atributos, constructores y métodos.
* Practicar el encapsulamiento y la validación de datos.
* Implementar métodos de cálculo como área y perímetro en diferentes figuras geométricas.
* Utilizar un `ArrayList` para almacenar múltiples objetos y recorrerlo para mostrar información.
* Desarrollar un programa modular y organizado en varios archivos `.java`.

---

## Explicación de los ejercicios

1. **Creación de las clases de figuras**
   Se implementaron tres clases:

   * `Circulo` (con atributos: radio y color).
   * `Rectangulo` (con atributos: base, altura y color).
   * `Triangulo` (con atributos: lado1, lado2, lado3 y color).

   Cada clase incluye métodos para:

   * Calcular el **área**.
   * Calcular el **perímetro**.
   * Mostrar la información detallada de la figura con `System.out.printf`.

   Además, en cada constructor se realizan **validaciones** para evitar valores negativos o no válidos.

---

2. **Método `main` en cada clase**
   Cada clase incluye su propio método `public static void main(String[] args)` que permite **probar de forma individual** la creación de objetos y el funcionamiento de los métodos.
   Ejemplo:

   * En `Circulo.main()`, se crean dos círculos y se muestra su área y perímetro.
   * En `Rectangulo.main()`, se crean dos rectángulos y se muestran sus resultados.
   * En `Triangulo.main()`, se prueban dos triángulos válidos y se calculan sus valores con la fórmula de Herón.

---

3. **Uso de `ArrayList` en `Main.java`**
   Se creó una clase `Main` con el siguiente propósito:

   * Crear un `ArrayList<Object>` llamado `figuras`.
   * Insertar al menos dos objetos de cada tipo (`Circulo`, `Rectangulo`, `Triangulo`).
   * Recorrer el `ArrayList` utilizando un ciclo `for` y el operador `instanceof` para identificar cada objeto y ejecutar su método `mostrarInformacion()`.

   Con esto se cumple el objetivo de manejar una colección dinámica de objetos de diferentes tipos en un mismo contenedor.

---

## Conclusión

El taller permitió afianzar conocimientos de:

* Programación orientada a objetos en Java.
* Validación de atributos dentro de los constructores.
* Implementación de métodos de cálculo en clases.
* Uso de la clase `ArrayList` para almacenar y gestionar colecciones de objetos.

De esta forma, se demuestra cómo aplicar conceptos de **estructura de datos** a un problema práctico mediante el diseño y manipulación de objetos.
