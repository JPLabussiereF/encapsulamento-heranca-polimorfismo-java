public class Gato extends Mamifero{


    public Gato(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " está ronronando...");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está se alisando em sua perna...");
    }

    public void arranhar(String objeto){
        System.out.println( nome + " está arranhando " + objeto);
    }

}