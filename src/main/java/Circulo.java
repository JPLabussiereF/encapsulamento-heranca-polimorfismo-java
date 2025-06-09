public class Circulo extends FormaGeometrica {

    private double raio;

    public Circulo(String cor, double raio) {
        super(cor, false);
        this.raio = raio;
    }

    @Override
    public double calcularArea(){
        return Math.PI * (Math.pow(raio, 2));
    }

    @Override
    public double calcularPerimetro(){
        return 2*Math.PI * raio;
    }

}
