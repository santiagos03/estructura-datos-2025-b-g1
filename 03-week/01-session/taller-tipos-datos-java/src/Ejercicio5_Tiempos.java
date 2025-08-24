import java.util.Arrays;

public class Ejercicio5_Tiempos{

    // ===== PASO 1: Parsear HH:MM:SS a segundos =====
    private static long parseToSeconds(String t) {
        if (t == null) throw new IllegalArgumentException("Tiempo nulo");
        t = t.trim();
        String[] parts = t.split(":");
        if (parts.length != 3) throw new IllegalArgumentException("Formato inválido: " + t);
        long h = Long.parseLong(parts[0]);
        long m = Long.parseLong(parts[1]);
        long s = Long.parseLong(parts[2]);
        if (m < 0 || m >= 60 || s < 0 || s >= 60) {
            throw new IllegalArgumentException("Minutos/segundos fuera de rango en: " + t);
        }
        return h * 3600 + m * 60 + s;
    }

    // ===== PASO 5: Convertir segundos a HH:MM:SS por divisiones y módulos =====
    private static String formatHMS(long totalSeconds) {
        if (totalSeconds < 0) totalSeconds = 0; // por seguridad
        long h = totalSeconds / 3600;
        long rem = totalSeconds % 3600;
        long m = rem / 60;
        long s = rem % 60;
        return String.format("%d:%02d:%02d", h, m, s); // horas sin límite, mm/ss con 2 dígitos
    }

    // Redondeo a 2 decimales para porcentajes
    private static double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

    // Estructura simple para devolver resultados
    static class Stats {
        long totalSeconds;
        long avgSecondsRounded; // promedio redondeado a segundo más cercano
        int maxIndex;           // índice del tramo más largo
        long maxSeconds;
        double[] percentages;   // porcentaje de cada tramo respecto al total
    }

    public static Stats calcularEstadisticas(String[] tiemposHMS) {
        if (tiemposHMS == null) tiemposHMS = new String[0];
        int n = tiemposHMS.length;
        long[] segs = new long[n];

        // PASO 1 + PASO 2: parseo y suma total
        long total = 0L;
        for (int i = 0; i < n; i++) {
            segs[i] = parseToSeconds(tiemposHMS[i]);
            total += segs[i];
        }

        // PASO 3: promedio (total / n). Usamos double para el cálculo y luego redondeamos a long
        long avgRounded = 0L;
        if (n > 0) {
            double avg = (double) total / n;
            avgRounded = Math.round(avg);
        }

        // PASO 4: mantener max y su índice
        int maxIdx = -1;
        long maxVal = -1;
        for (int i = 0; i < n; i++) {
            if (segs[i] > maxVal) {
                maxVal = segs[i];
                maxIdx = i;
            }
        }

        // PASO 6: calcular porcentajes (segmento / total * 100) con control de total 0
        double[] perc = new double[n];
        if (total > 0) {
            for (int i = 0; i < n; i++) {
                perc[i] = round2((segs[i] * 100.0) / total);
            }
        } else {
            Arrays.fill(perc, 0.0);
        }

        Stats out = new Stats();
        out.totalSeconds = total;
        out.avgSecondsRounded = avgRounded;
        out.maxIndex = maxIdx;
        out.maxSeconds = maxVal;
        out.percentages = perc;
        return out;
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        String[] tiempos = { "00:05:33", "00:12:17", "00:03:50" };
        Stats r = calcularEstadisticas(tiempos);

        System.out.println("Lista: " + Arrays.toString(tiempos));
        System.out.println("Tiempo total: " + formatHMS(r.totalSeconds) +
                " (" + r.totalSeconds + " s)");
        System.out.println("Promedio: " + formatHMS(r.avgSecondsRounded));
        if (r.maxIndex >= 0) {
            System.out.println("Tramo más largo: índice " + r.maxIndex +
                    ", valor " + formatHMS(r.maxSeconds));
        } else {
            System.out.println("Tramo más largo: N/A");
        }
        System.out.println("Porcentajes: " + Arrays.toString(r.percentages));
    }
}

