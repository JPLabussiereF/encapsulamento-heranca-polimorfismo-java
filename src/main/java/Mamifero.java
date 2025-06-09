public abstract class Mamifero extends Animal{

    private String pelagem;
    private float temperaturaCorporal;

    public Mamifero(String nome, int idade, double peso) {
        super(nome, idade, peso);
        this.pelagem = "pelo";
        this.temperaturaCorporal = 37.0f;
    }

    public String getPelagem() {
        return pelagem;
    }

    public float getTemperaturaCorporal() {
        return temperaturaCorporal;
    }
}
