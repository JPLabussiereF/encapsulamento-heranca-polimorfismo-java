public class Cachorro extends Mamifero{

    private String raca;

    public Cachorro(String nome, int idade, double peso, String raca) {
        super(nome, idade, peso);
        this.raca = raca;
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " está latindo...");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está correndo e balançando o rabo...");
    }

    public void buscarObjeto(String objeto){
        System.out.println( nome + " foi buscar o " + objeto);
    }
}
