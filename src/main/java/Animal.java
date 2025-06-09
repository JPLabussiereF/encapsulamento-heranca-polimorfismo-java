public abstract class Animal {
    protected String nome;
    protected int idade;
    protected double peso;
    private boolean vivo; // ENCAPSULAMENTO

    public Animal(String nome, int idade, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.vivo = true;
    }

    // Métodos polimórficos
    public void emitirSom() {
        System.out.println(nome + " faz algum som...");
    }

    public void mover() {
        System.out.println(nome + " está se movendo...");
    }

    // Métodos comuns
    public void dormir() {
        System.out.println(nome + " está dormindo... 😴");
    }

    public void comer(String alimento) {
        System.out.println(nome + " está comendo " + alimento);
        peso += 0.1; // Ganha peso ao comer
    }

    // ENCAPSULAMENTO - getters com lógica
    public boolean isVivo() { return vivo; }
    public String getStatus() {
        return nome + " (" + idade + " anos, " + peso + "kg) - " +
                (vivo ? "Vivo" : "Morto");
    }
}