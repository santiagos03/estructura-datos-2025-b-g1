public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    private String color;

    public Triangulo(double lado1, double lado2, double lado3, String color) {
        if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
            throw new IllegalArgumentException("Los lados deben ser mayores que 0.");
        }
        if (!esTrianguloValido(lado1, lado2, lado3)) {
            throw new IllegalArgumentException("Los valores no forman un triángulo válido.");
        }
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.color = color;
    }

    private boolean esTrianguloValido(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    public double calcularArea() {
        double s = calcularPerimetro() / 2.0;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3)); // Fórmula de Herón
    }

    public void mostrarInformacion() {
        System.out.printf("TRIÁNGULO - Color: %s | Lados: %.2f, %.2f, %.2f | Área: %.2f | Perímetro: %.2f%n",
                color, lado1, lado2, lado3, calcularArea(), calcularPerimetro());
    }

    // Método main para probar Triangulo directamente
    public static void main(String[] args) {
        Triangulo t1 = new Triangulo(3.0, 4.0, 5.0, "Morado");
        Triangulo t2 = new Triangulo(5.0, 5.0, 6.0, "Naranja");

        System.out.println("=== Probando Triángulos ===");
        t1.mostrarInformacion();
        t2.mostrarInformacion();
    }
}