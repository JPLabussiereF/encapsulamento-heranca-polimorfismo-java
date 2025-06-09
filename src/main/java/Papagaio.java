public class Papagaio extends Ave{
    public Papagaio(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    public void imitarPalavra(String palavra){
        System.out.println(nome + "está imitando ");
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " esta imitando sons...");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está voando para gaiola...");
    }
}
