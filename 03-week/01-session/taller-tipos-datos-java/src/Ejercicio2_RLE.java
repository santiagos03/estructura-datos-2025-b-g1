public class Ejercicio2_RLE {
    public static String compressRLE(String input) {
if (input == null || input.isEmpty()) return "";


StringBuilder result = new StringBuilder();
int count = 1;


for (int i = 1; i <= input.length(); i++) {
if (i < input.length() && input.charAt(i) == input.charAt(i - 1)) {
count++;
} else {
result.append(input.charAt(i - 1)).append(count);
count = 1;
}
}


return result.toString();
}


public static double compressionRatio(String original, String compressed) {
if (original == null || original.isEmpty()) return 0.0;
return (double) compressed.length() / original.length();
}


public static void main(String[] args) {
String test = "aaabbbccccd";


String compressed = compressRLE(test);
double ratio = compressionRatio(test, compressed);


System.out.println("Texto original: " + test);
System.out.println("Texto comprimido: " + compressed);
System.out.println("Ratio de compresión: " + ratio);
}
}
