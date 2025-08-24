# Taller - Tipos de datos en Java

## Autor
- Nombre: David Santiago Salazar  
- Ingeniería en Sistemas  
- Tercer semestre  

## Objetivo del taller
El objetivo de este taller es **aplicar conceptos básicos de programación y estructuras de datos** por medio de la resolución de problemas prácticos en Java.  
Cada ejercicio busca reforzar habilidades como el manejo de cadenas, compresión, conversión de unidades y manipulación de números en distintas bases.  

## Ejercicios con explicación

## Objetivo del taller
El objetivo de este taller es **aplicar conceptos básicos de programación y estructuras de datos en Java** mediante ejercicios cortos y prácticos.  
Se refuerzan habilidades de:
- Manipulación de cadenas y arreglos.
- Conversión y validación de datos numéricos.
- Uso de condicionales y ciclos.
- Buenas prácticas de entrada/salida y verificación de casos límite.

---

## Ejercicios con explicación

### Ejercicio 1: Validador de ISBN-13
**Enunciado:**  
Dado un `String` de 13 dígitos, validar si cumple el checksum del estándar **ISBN-13**.

**Solución (idea):**  
1. Verificar longitud 13 y que todos los caracteres sean dígitos.  
2. Convertir cada `char` a entero: `int d = isbn.charAt(i) - '0';`  
3. Acumular `suma += d * (i % 2 == 0 ? 1 : 3);`  
4. Es válido si `suma % 10 == 0`.

**Tipos de datos:** `String`, `char`, `int`, `boolean`, `int[]`  
**Código fuente:** `src/Ejercicio1_ISBN13.java`  
**Evidencia:** ![Ejecución](src/evidencias/Ejercicio1_ISBN13.png)

---

### Ejercicio 2: Compresor RLE (Run-Length Encoding)
**Enunciado:**  
Dado un `String`, **comprimir** secuencias de caracteres iguales consecutivos usando RLE.  
Ejemplo: `aaabbc → a3b2c1`.

**Solución (idea):**  
1. Si está vacío, retornar `""`.  
2. Recorrer la cadena contando repeticiones del carácter actual.  
3. Agregar al resultado `carácter + conteo` (usar `StringBuilder`).  
4. Reiniciar conteo al cambiar de carácter.

**Tipos de datos:** `String`, `char`, `int`, `StringBuilder`  
**Código fuente:** `src/Ejercicio2_RLE.java`  
**Evidencia:** ![Ejecución](src/evidencias/Ejercicio2_RLE.png)

---

### Ejercicio 3: Conversor de Temperaturas
**Enunciado:**  
Convertir temperaturas entre **Celsius (C)**, **Fahrenheit (F)** y **Kelvin (K)**.

**Solución (idea):**  
- Fórmulas:
  - `F = C * 9/5 + 32`
  - `C = (F - 32) * 5/9`
  - `K = C + 273.15`  y `C = K - 273.15`
  - Para `F ↔ K`, convertir pasando por `C`.  
- Validar límites físicos: `C ≥ -273.15` y `K ≥ 0`.

**Tipos de datos:** `double`, `String/char` (unidades), `boolean`  
**Código fuente:** `src/Ejercicio3_Temperaturas.java`  
**Evidencia:** ![Ejecución](src/evidencias/Ejercicio3_Temperaturas.png)

---

### Ejercicio 4: Conversor de Bases
**Enunciado:**  
Dado un número como `String` y dos bases (entre 2 y 16), **convertir** de la base origen a la base destino.  
Ejemplo: `num="2F", baseOrigen=16, baseDestino=2 → 101111`.

**Solución (idea):**  
1. Normalizar a mayúsculas y validar dígitos válidos para la base origen (`0–9`, `A–F`).  
2. Parsear a valor entero: `int v = Integer.parseInt(num, baseOrigen);`  
3. Convertir: `String res = Integer.toString(v, baseDestino).toUpperCase();`

**Tipos de datos:** `String`, `int`, `char[]`, `boolean`  
**Código fuente:** `src/Ejercicio4_ConversorBases.java`  
**Evidencia:** ![Ejecución](src/evidencias/Ejercicio4_ConversorBases.png)

---

### Ejercicio 5: Operaciones con Tiempos (HH:MM:SS)
**Enunciado:**  
Trabajar con tiempos en formato `HH:MM:SS`: **convertir** entre segundos totales y `HH:MM:SS`, y (opcional) **sumar/restar** dos tiempos.

**Solución (idea):**  
- **Segundos → HH:MM:SS**  
  `h = s/3600; m = (s%3600)/60; s = s%60;` y formatear con `String.format("%02d:%02d:%02d", h,m,s)`.  
- **HH:MM:SS → Segundos**  
  Separar con `split(":")`, parsear y calcular `h*3600 + m*60 + s`.  
- Para suma/resta, trabajar siempre en segundos y volver a formatear.

**Tipos de datos:** `int`, `String`, `String[]`, `boolean`  
**Código fuente:** `src/Ejercicio5_Tiempos.java`  
**Evidencia:** ![Ejecución](src/evidencias/Ejercicio5_Tiempos.png)

