public abstract class FormaGeometrica {
    protected String cor;
    protected boolean preenchida;

    public FormaGeometrica(String cor, boolean preenchida) {
        this.cor = cor;
        this.preenchida = false;
    }

    // Método abstrato - POLIMORFISMO
    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    // Método concreto
    public void pintar() {
        preenchida = true;
        System.out.println("Forma pintada de " + cor);
    }

    // ENCAPSULAMENTO
    public String getCor() { return cor; }
    public boolean isPreenchida() { return preenchida; }
}


