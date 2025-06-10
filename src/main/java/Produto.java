// Classe abstrata para produtos
public abstract class Produto {
    protected String nome;
    protected double preco;
    protected String categoria;
    protected int estoque;
    private static int proximoId = 1;
    private int id;

    public Produto(String nome, double preco, String categoria, int estoque) {
        this.id = proximoId++;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.estoque = estoque;
    }

    // Método abstrato - cada produto calcula desconto diferente
    public abstract double calcularDesconto();

    // Método polimórfico
    public double getPrecoFinal() {
        return preco - calcularDesconto();
    }

    // ENCAPSULAMENTO
    public boolean temEstoque(int quantidade) {
        return estoque >= quantidade;
    }

    public boolean reduzirEstoque(int quantidade) {
        if (temEstoque(quantidade)) {
            estoque -= quantidade;
            return true;
        }
        return false;
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }
}