public class Circulo {
    private double radio;
    private String color;

    // Constructor
    public Circulo(double radio, String color) {
        if (radio <= 0) {
            throw new IllegalArgumentException("El radio debe ser mayor que 0.");
        }
        this.radio = radio;
        this.color = color;
    }

    // Métodos
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    public void mostrarInformacion() {
        System.out.printf("CÍRCULO - Color: %s | Radio: %.2f | Área: %.2f | Perímetro: %.2f%n",
                color, radio, calcularArea(), calcularPerimetro());
    }

    // Getters
    public double getRadio() {
        return radio;
    }

    public String getColor() {
        return color;
    }

    // Método main para ejecutar
    public static void main(String[] args) {
        // Creamos algunos círculos
        Circulo c1 = new Circulo(3.0, "Rojo");
        Circulo c2 = new Circulo(5.0, "Azul");

        // Mostramos la información
        System.out.println("=== Información de los círculos ===");
        c1.mostrarInformacion();
        c2.mostrarInformacion();
    }
}

