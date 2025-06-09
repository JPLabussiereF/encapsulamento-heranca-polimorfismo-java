public class Retangulo extends FormaGeometrica{
    private double altura;
    private double largura;

    public Retangulo(String cor, double largura, double altura){
        super(cor, false);
        this.altura = altura;
        this.largura = largura;
    }

    @Override
    public double calcularArea(){
        return largura * altura;
    }

    @Override
    public double calcularPerimetro(){
        return 2 * (largura*altura);
    }

}
