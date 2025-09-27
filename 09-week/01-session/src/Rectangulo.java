public class Rectangulo {
    private double base;
    private double altura;
    private String color;

    public Rectangulo(double base, double altura, String color) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Base y altura deben ser mayores que 0.");
        }
        this.base = base;
        this.altura = altura;
        this.color = color;
    }

    public double calcularArea() {
        return base * altura;
    }

    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    public void mostrarInformacion() {
        System.out.printf("RECTÁNGULO - Color: %s | Base: %.2f | Altura: %.2f | Área: %.2f | Perímetro: %.2f%n",
                color, base, altura, calcularArea(), calcularPerimetro());
    }

    // Método main para probar Rectangulo directamente
    public static void main(String[] args) {
        Rectangulo r1 = new Rectangulo(4.0, 2.0, "Verde");
        Rectangulo r2 = new Rectangulo(6.0, 3.0, "Amarillo");

        System.out.println("=== Probando Rectángulos ===");
        r1.mostrarInformacion();
        r2.mostrarInformacion();
    }
}