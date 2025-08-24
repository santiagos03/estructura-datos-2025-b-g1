public class Ejercicio3_Temperaturas {
       public static void main(String[] args) {
        // Nuevo string de temperaturas
        String datos = "18.5, 20.1, 19.8, 22.4, 21.0, 23.7";

        // Separar y convertir a double
        String[] partes = datos.split(",");
        double[] temperaturas = new double[partes.length];

        for (int i = 0; i < partes.length; i++) {
            temperaturas[i] = Double.parseDouble(partes[i].trim());
        }

        // Variables iniciales
        double min = temperaturas[0];
        double max = temperaturas[0];
        double suma = 0;

        // Recorrer para min, max y suma
        for (double t : temperaturas) {
            if (t < min) min = t;
            if (t > max) max = t;
            suma += t;
        }

        // Promedio
        double promedio = suma / temperaturas.length;

        // Varianza y desviación estándar
        double varianza = 0;
        for (double t : temperaturas) {
            varianza += Math.pow(t - promedio, 2);
        }
        varianza /= temperaturas.length;
        double desviacion = Math.sqrt(varianza);

        // Mostrar resultados
        System.out.println("Mínimo: " + min);
        System.out.println("Máximo: " + max);
        System.out.println("Promedio: " + promedio);
        System.out.println("Desviación estándar: " + desviacion);
    }
}
