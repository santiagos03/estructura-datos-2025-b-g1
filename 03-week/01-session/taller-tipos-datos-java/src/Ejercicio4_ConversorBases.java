import java.math.BigInteger;

public class Ejercicio4_ConversorBases {

    /** PASO 1: Normaliza el String (hex en mayúsculas, quitar prefijos 0x/0b si vienen). */
    private static String normalize(String s, int base) {
        if (s == null) return "";
        s = s.trim();
        if (s.isEmpty()) return s;

        boolean negative = s.charAt(0) == '-';
        int start = negative ? 1 : (s.charAt(0) == '+' ? 1 : 0);
        String body = s.substring(start);

        // Remueve prefijos comunes si aparecen después del signo
        if (base == 16 && (body.startsWith("0x") || body.startsWith("0X"))) {
            body = body.substring(2);
        } else if (base == 2 && (body.startsWith("0b") || body.startsWith("0B"))) {
            body = body.substring(2);
        }

        body = body.replace("_", ""); // permitir números con guiones bajos (ej.: 1_000)
        String normalized = body.toUpperCase();
        return (negative ? "-" : "") + normalized;
    }

    /** PASO 2: Valida que todos los caracteres pertenezcan a la base indicada. */
    private static boolean isValidForBase(String s, int base) {
        if (s == null || s.isEmpty()) return false;
        int i = (s.charAt(0) == '-' || s.charAt(0) == '+') ? 1 : 0;
        if (i == s.length()) return false; // sólo signo no es válido
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.digit(ch, base) == -1) return false; // fuera de rango para la base
        }
        return true;
    }

    /**
     * PASO 3-5: Intenta parsear a long; si falla/desborda, usa BigInteger.
     * Convierte a las otras 2 bases y reporta si se usó BigInteger.
     */
    public static void convertir(String numero, int baseOrigen) {
        // Paso 1
        String n = normalize(numero, baseOrigen);

        // Paso 2
        if (!isValidForBase(n, baseOrigen)) {
            System.out.println("Entrada inválida para base " + baseOrigen + ": " + numero);
            return;
        }

        boolean usoBigInteger = false;

        try {
            // Paso 3: intentamos con long (con el radix de origen)
            long valor = Long.parseLong(n, baseOrigen);

            // Paso 4: convertimos con métodos de Long
            String bin = Long.toString(valor, 2);
            String dec = Long.toString(valor, 10);
            String hex = Long.toString(valor, 16).toUpperCase();

            // Paso 5: mostramos sólo las otras dos bases
            imprimirResultado(baseOrigen, bin, dec, hex, usoBigInteger);
        } catch (NumberFormatException ex) {
            // Se desbordó o no cabe en long → usamos BigInteger
            usoBigInteger = true;
            BigInteger big = new BigInteger(n, baseOrigen);

            String bin = big.toString(2);
            String dec = big.toString(10);
            String hex = big.toString(16).toUpperCase();

            imprimirResultado(baseOrigen, bin, dec, hex, usoBigInteger);
        }
    }

    private static void imprimirResultado(int baseOrigen, String bin, String dec, String hex, boolean usoBigInteger) {
        System.out.println("Base de origen: " + baseOrigen);
        switch (baseOrigen) {
            case 2:
                System.out.println("→ Decimal: " + dec);
                System.out.println("→ Hex:     " + hex);
                break;
            case 10:
                System.out.println("→ Binario: " + bin);
                System.out.println("→ Hex:     " + hex);
                break;
            case 16:
                System.out.println("→ Binario: " + bin);
                System.out.println("→ Decimal: " + dec);
                break;
            default:
                System.out.println("Base de origen no soportada (use 2, 10 o 16)");
        }
        System.out.println("¿Usó BigInteger?: " + usoBigInteger);
        System.out.println();
    }

    // Ejemplos de uso en main
    public static void main(String[] args) {
        // Cabe en long
        convertir("101010", 2);              // 42
        convertir("9223372036854775807", 10); // Long.MAX_VALUE
        convertir("7F", 16);                  // 127

        // No cabe en long → usa BigInteger
        convertir("FFFFFFFFFFFFFFFF", 16);    // 2^64 - 1
        convertir("100000000000000000000000000000000", 2); // muy grande

        // Ejemplo con signo y prefijos
        convertir("-0x7f", 16);               // -127
        convertir("0b1111_1111_1111_1111", 2); // 65535 con guiones bajos
    }
}
