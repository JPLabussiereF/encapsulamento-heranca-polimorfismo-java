public class Aguia extends Ave{
    public Aguia(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " está grasnando...");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está voando bem alto e rápido...");
    }

    public void cacarPresa(String presa){
        System.out.println(nome + " está caçando a sua presa: " + presa);
    }

}
