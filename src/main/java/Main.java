public class Main {
    public static void main(String[] args) {
        FormaGeometrica[] formas = {
                new Retangulo("Azul", 5, 3),
                new Circulo("Vermelho", 4),
                new Triangulo("Verde", 6, 4, 5, 5, 5)
        };

        System.out.println("===FORMAS GEOMÉTRICAS===\n");
        for (FormaGeometrica forma : formas) {
            forma.pintar();
            System.out.println("Área: " + forma.calcularArea());
            System.out.println("Perímetro: " + forma.calcularPerimetro());
        }

        Animal[] zoologico = {
                new Cachorro("Rex", 3, 25.0, "Pastor Alemão"),
                new Gato("Mimi", 2, 4.5),
                new Papagaio("Loro", 5, 1.2),
                new Aguia("Zeus", 8, 6.5)
        };
        System.out.println("\n===ZOOLÓGICO===");
        // Polimorfismo em ação
        for (Animal animal : zoologico) {
            animal.emitirSom();  // Cada um emite som diferente
            animal.mover();      // Cada um se move diferente
            animal.comer("ração");
            System.out.println(animal.getStatus());
        }
    }
}