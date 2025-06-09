public class Main {
    public static void main(String[] args) {
        FormaGeometrica[] formas = {
                new Retangulo("Azul", 5, 3),
                new Circulo("Vermelho", 4),
                new Triangulo("Verde", 6, 4, 5, 5, 5)
        };

        for (FormaGeometrica forma : formas) {
            forma.pintar();
            System.out.println("Área: " + forma.calcularArea());
            System.out.println("Perímetro: " + forma.calcularPerimetro());
        }
    }
}