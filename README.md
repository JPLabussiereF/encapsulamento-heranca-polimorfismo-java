# Os Três Pilares da POO em Java

## 🎯 Introdução

A **Programação Orientada a Objetos (POO)** é sustentada por três pilares fundamentais que formam a base de todo sistema bem estruturado: **Encapsulamento**, **Herança** e **Polimorfismo**. Estes conceitos trabalham juntos para criar código mais organizado, reutilizável e fácil de manter.

## 🏛️ Os Três Pilares

| Pilar | Definição | Objetivo |
|-------|-----------|----------|
| **Encapsulamento** | Ocultação dos detalhes internos | Proteger e controlar acesso aos dados |
| **Herança** | Criação de classes baseadas em outras | Reutilizar e especializar código |
| **Polimorfismo** | Múltiplas formas para um comportamento | Flexibilidade e extensibilidade |

### Analogia Visual
```
🏠 Casa (Classe Pai)
├── 🔒 Encapsulamento: Portas e janelas controlam acesso
├── 🏘️ Herança: Apartamento herda características da casa
└── 🎭 Polimorfismo: Diferentes tipos de moradia, mesmo comportamento "morar"
```

## 🔒 1. Encapsulamento

### Conceito
**Encapsulamento** é o mecanismo que **oculta os detalhes internos** de uma classe e **controla o acesso** aos seus dados através de métodos públicos (getters/setters).

### Princípios
- **Atributos privados**: Dados protegidos de acesso direto
- **Métodos públicos**: Interface controlada para interação
- **Validação**: Controle de integridade dos dados

### Exemplo Básico
```java
public class ContaBancaria {
    // Atributos PRIVADOS - encapsulados
    private String titular;
    private double saldo;
    private String numeroConta;
    
    // Construtor
    public ContaBancaria(String titular, String numeroConta) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }
    
    // Métodos públicos para acesso controlado
    public double getSaldo() {
        return saldo;
    }
    
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado: R$ " + valor);
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }
    
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado: R$ " + valor);
            return true;
        } else {
            System.out.println("Saque negado: saldo insuficiente ou valor inválido!");
            return false;
        }
    }
    
    // Método que NÃO permite acesso direto ao saldo
    public String getExtrato() {
        return "Titular: " + titular + 
               " | Conta: " + numeroConta + 
               " | Saldo: R$ " + String.format("%.2f", saldo);
    }
}
```

### Vantagens do Encapsulamento
- ✅ **Segurança**: Dados protegidos contra modificação inadequada
- ✅ **Controle**: Validação de valores antes da atribuição
- ✅ **Manutenção**: Mudanças internas não afetam código externo
- ✅ **Integridade**: Estado consistente dos objetos

## 🧬 2. Herança

### Conceito
**Herança** permite criar **novas classes baseadas em classes existentes**, herdando seus atributos e métodos, promovendo **reutilização** e **especialização** de código.

### Sintaxe
```java
public class ClasseFilha extends ClassePai {
    // Novos atributos e métodos
    // Sobrescrita de métodos existentes
}
```

### Exemplo Progressivo

#### Classe Pai (Superclasse)
```java
public class Veiculo {
    // Atributos protegidos - acessíveis às filhas
    protected String marca;
    protected String modelo;
    protected int ano;
    protected boolean ligado;
    
    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.ligado = false;
    }
    
    // Métodos que serão herdados
    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println(marca + " " + modelo + " foi ligado!");
        }
    }
    
    public void desligar() {
        if (ligado) {
            ligado = false;
            System.out.println(marca + " " + modelo + " foi desligado!");
        }
    }
    
    public void acelerar() {
        if (ligado) {
            System.out.println("Veículo acelerando...");
        } else {
            System.out.println("Ligue o veículo primeiro!");
        }
    }
    
    public String getInfo() {
        return marca + " " + modelo + " (" + ano + ")";
    }
}
```

#### Classes Filhas (Subclasses)
```java
public class Carro extends Veiculo {
    private int numeroPortas;
    private String tipoCombustivel;
    
    public Carro(String marca, String modelo, int ano, int numeroPortas, String tipoCombustivel) {
        super(marca, modelo, ano); // Chama construtor da classe pai
        this.numeroPortas = numeroPortas;
        this.tipoCombustivel = tipoCombustivel;
    }
    
    // Método específico da classe Carro
    public void abrirPortaMalas() {
        System.out.println("Porta-malas do " + modelo + " aberto!");
    }
    
    // Sobrescrita do método acelerar
    @Override
    public void acelerar() {
        if (ligado) {
            System.out.println("Carro " + modelo + " acelerando suavemente...");
        } else {
            System.out.println("Ligue o carro primeiro!");
        }
    }
    
    @Override
    public String getInfo() {
        return super.getInfo() + " - " + numeroPortas + " portas, " + tipoCombustivel;
    }
}

public class Moto extends Veiculo {
    private int cilindradas;
    private boolean temBau;
    
    public Moto(String marca, String modelo, int ano, int cilindradas) {
        super(marca, modelo, ano);
        this.cilindradas = cilindradas;
        this.temBau = false;
    }
    
    // Método específico da classe Moto
    public void empinar() {
        if (ligado) {
            System.out.println("Moto " + modelo + " empinando! 🏍️");
        } else {
            System.out.println("Ligue a moto primeiro!");
        }
    }
    
    // Sobrescrita do método acelerar
    @Override
    public void acelerar() {
        if (ligado) {
            System.out.println("Moto " + modelo + " acelerando rapidamente! VRUMMM!");
        } else {
            System.out.println("Ligue a moto primeiro!");
        }
    }
    
    @Override
    public String getInfo() {
        return super.getInfo() + " - " + cilindradas + "cc";
    }
}
```

### Tipos de Herança
- **Simples**: Uma classe herda de apenas uma classe pai (Java)
- **Múltipla**: Uma classe herda de várias classes (não suportada em Java)
- **Multinível**: Classe → SuperClasse → SuperSuperClasse
- **Hierárquica**: Várias classes herdando da mesma classe pai

## 🎭 3. Polimorfismo

### Conceito
**Polimorfismo** significa "**muitas formas**". Permite que objetos de diferentes classes sejam tratados através de uma **interface comum**, mas cada um responde de **forma específica** ao mesmo método.

### Tipos de Polimorfismo

#### 1. Polimorfismo de Sobrescrita (Runtime)
```java
public class TestePoli {
    public static void main(String[] args) {
        // Mesmo tipo de referência, objetos diferentes
        Veiculo v1 = new Carro("Honda", "Civic", 2023, 4, "Flex");
        Veiculo v2 = new Moto("Yamaha", "MT-07", 2023, 689);
        
        // Polimorfismo em ação!
        v1.ligar();
        v1.acelerar(); // Chama o acelerar() do Carro
        
        v2.ligar();
        v2.acelerar(); // Chama o acelerar() da Moto
        
        // Array polimórfico
        Veiculo[] garagem = {
            new Carro("Toyota", "Corolla", 2022, 4, "Híbrido"),
            new Moto("Honda", "CB600", 2021, 600),
            new Carro("VW", "Golf", 2023, 4, "TSI")
        };
        
        // Cada veículo acelera de forma diferente
        for (Veiculo veiculo : garagem) {
            veiculo.ligar();
            veiculo.acelerar(); // Polimorfismo!
            System.out.println(veiculo.getInfo());
            System.out.println("---");
        }
    }
}
```

#### 2. Polimorfismo de Sobrecarga (Compile time)
```java
public class Calculadora {
    // Métodos com mesmo nome, parâmetros diferentes
    public int somar(int a, int b) {
        return a + b;
    }
    
    public double somar(double a, double b) {
        return a + b;
    }
    
    public int somar(int a, int b, int c) {
        return a + b + c;
    }
    
    public String somar(String a, String b) {
        return a + b;
    }
}
```

### Vantagens do Polimorfismo
- ✅ **Flexibilidade**: Código que funciona com diferentes tipos
- ✅ **Extensibilidade**: Fácil adição de novos tipos
- ✅ **Manutenibilidade**: Menos código duplicado
- ✅ **Abstração**: Interface única para diferentes implementações

## 🔗 Como os Pilares Trabalham Juntos

### Exemplo Integrado: Sistema de Funcionários

```java
// Classe base com ENCAPSULAMENTO
public class Funcionario {
    protected String nome;
    protected double salarioBase;
    protected String departamento;
    
    public Funcionario(String nome, double salarioBase, String departamento) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }
    
    // Método que será POLIMÓRFICO
    public double calcularSalario() {
        return salarioBase;
    }
    
    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Departamento: " + departamento);
        System.out.println("Salário: R$ " + String.format("%.2f", calcularSalario()));
    }
    
    // Getters encapsulados
    public String getNome() { return nome; }
    public double getSalarioBase() { return salarioBase; }
}

// HERANÇA + POLIMORFISMO
public class Desenvolvedor extends Funcionario {
    private int horasExtras;
    private double valorHoraExtra;
    
    public Desenvolvedor(String nome, double salarioBase, int horasExtras) {
        super(nome, salarioBase, "TI");
        this.horasExtras = horasExtras;
        this.valorHoraExtra = 50.0;
    }
    
    // POLIMORFISMO - sobrescrita
    @Override
    public double calcularSalario() {
        return salarioBase + (horasExtras * valorHoraExtra);
    }
    
    public void programar() {
        System.out.println(nome + " está programando... 💻");
    }
}

public class Vendedor extends Funcionario {
    private double vendas;
    private double comissao;
    
    public Vendedor(String nome, double salarioBase, double comissao) {
        super(nome, salarioBase, "Vendas");
        this.vendas = 0;
        this.comissao = comissao;
    }
    
    // POLIMORFISMO - sobrescrita
    @Override
    public double calcularSalario() {
        return salarioBase + (vendas * comissao / 100);
    }
    
    public void registrarVenda(double valor) {
        this.vendas += valor;
        System.out.println("Venda registrada: R$ " + valor);
    }
}
```

## 🏋️ Exercícios Práticos

### Exercício 1: Básico - Sistema de Formas Geométricas
Crie um sistema demonstrando os três pilares:

**[Classe Abstrata Base:](src/main/java/FormaGeometrica.java)**
```java
public abstract class FormaGeometrica {
    protected String cor;
    protected boolean preenchida;
    
    public FormaGeometrica(String cor) {
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
```

**Implemente as classes:**
- [`Retangulo` (largura, altura)](src/main/java/Retangulo.java)
- [`Circulo` (raio)](src/main/java/Circulo.java)
- [`Triangulo` (base, altura, lado1, lado2, lado3)](src/main/java/Triangulo.java)

**Teste o polimorfismo:**
```java
FormaGeometrica[] formas = {
    new Retangulo("Azul", 5, 3),
    new Circulo("Vermelho", 4),
    new Triangulo("Verde", 6, 4, 5, 5, 5)
};

for (FormaGeometrica forma : formas) {
    forma.pintar();
    System.out.println("Área: " + forma.calcularArea());
    System.out.println("Perímetro: " + forma.calcularPerimetro());
}
```

### Exercício 2: Intermediário - Sistema de Animais
Crie uma hierarquia de animais demonstrando os três pilares:

**Classe Base:**
```java
public class Animal {
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
```

**Implemente as subclasses:**
- `Mamifero` (pelagem, temperatura corporal)
    - `Cachorro` (raça, late, buscar objeto)
    - `Gato` (ronronar, arranhar)
- `Ave` (envergadura, pode voar)
    - `Papagaio` (falar palavras, imitar sons)
    - `Aguia` (caçar, voar alto)

**Teste polimorfismo e herança:**
```java
Animal[] zoologico = {
    new Cachorro("Rex", 3, 25.0, "Pastor Alemão"),
    new Gato("Mimi", 2, 4.5),
    new Papagaio("Loro", 5, 1.2),
    new Aguia("Zeus", 8, 6.5)
};

// Polimorfismo em ação
for (Animal animal : zoologico) {
    animal.emitirSom();  // Cada um emite som diferente
    animal.mover();      // Cada um se move diferente
    animal.comer("ração");
    System.out.println(animal.getStatus());
}
```

### Exercício 3: Avançado - Sistema de E-commerce
Crie um sistema de e-commerce completo demonstrando os três pilares:

**Estrutura Base:**
```java
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
```

**Implemente as classes:**

1. **Produtos específicos:**
    - `Eletronico` (garantia, marca) - desconto de 10% se estoque > 50
    - `Roupa` (tamanho, cor) - desconto de 15% se estoque > 100
    - `Livro` (autor, páginas) - desconto de 5% sempre

2. **Sistema de usuários:**
    - `Usuario` (nome, email, senha)
    - `Cliente` extends Usuario (endereço, histórico compras)
    - `Admin` extends Usuario (permissões especiais)

3. **Carrinho e Pedido:**
    - `ItemCarrinho` (produto, quantidade)
    - `CarrinhoCompras` (lista de itens, calcular total)
    - `Pedido` (cliente, itens, status, data)

**Funcionalidades esperadas:**
```java
// Exemplo de uso completo
public class LojaVirtual {
    public static void main(String[] args) {
        // Criando produtos
        Produto[] produtos = {
            new Eletronico("Smartphone", 1200.0, "Samsung", 30),
            new Roupa("Camiseta", 50.0, "M", "Azul", 150),
            new Livro("Java Completo", 80.0, "João Silva", 400)
        };
        
        // Criando cliente
        Cliente cliente = new Cliente("Maria", "maria@email.com", "123456");
        CarrinhoCompras carrinho = new CarrinhoCompras(cliente);
        
        // Adicionando produtos (polimorfismo)
        for (Produto produto : produtos) {
            carrinho.adicionarItem(produto, 1);
            System.out.println(produto.getNome() + 
                             " - Preço original: R$ " + produto.getPreco() +
                             " - Preço final: R$ " + produto.getPrecoFinal());
        }
        
        // Finalizando compra
        Pedido pedido = carrinho.finalizarCompra();
        pedido.exibirResumo();
    }
}
```

## ✨ Boas Práticas dos Pilares

### Encapsulamento
```java
// ❌ Evite - atributos públicos
public class Pessoa {
    public String nome;
    public int idade;
}

// ✅ Prefira - atributos privados com validação
public class Pessoa {
    private String nome;
    private int idade;
    
    public void setIdade(int idade) {
        if (idade >= 0 && idade <= 150) {
            this.idade = idade;
        } else {
            throw new IllegalArgumentException("Idade inválida!");
        }
    }
}
```

### Herança

```java
// ❌ Evite - herança desnecessária
public class Quadrado extends FormaGeometrica {
    // Quadrado É-UM retângulo? Questionável...
}

// ✅ Prefira - herança com relacionamento "É-UM"
public class ContaPoupanca extends ContaBancaria {
    // ContaPoupanca É-UMA ContaBancaria ✓
}
```

### Polimorfismo
```java
// ❌ Evite - verificação de tipo
if (animal instanceof Cachorro) {
    ((Cachorro) animal).latir();
} else if (animal instanceof Gato) {
    ((Gato) animal).miar();
}

// ✅ Prefira - método polimórfico
animal.emitirSom(); // Cada animal implementa seu som
```

## 📚 Dicas de Estudo

1. **Pratique os três juntos**: Os pilares trabalham em conjunto
2. **Comece com exemplos simples**: Animais, veículos, formas geométricas
3. **Use analogias do mundo real**: Facilita o entendimento
4. **Desenhe diagramas**: Visualize as relações entre classes
5. **Teste polimorfismo**: Crie arrays de objetos diferentes
6. **Valide encapsulamento**: Sempre use getters/setters com lógica
7. **Question herança**: Use apenas quando for relação "É-UM"

## 🎯 Próximos Passos

Após dominar os três pilares, você estará pronto para:
- **Interfaces**: Contratos que classes devem implementar
- **Classes Abstratas**: Classes que não podem ser instanciadas
- **Design Patterns**: Soluções elegantes para problemas comuns
- **SOLID Principles**: Princípios para código limpo e manutenível

## 🏆 Resumo dos Pilares

| Pilar | O que faz | Como usar | Benefício |
|-------|-----------|-----------|-----------|
| **🔒 Encapsulamento** | Protege dados | private + getters/setters | Segurança e controle |
| **🧬 Herança** | Reutiliza código | extends + super | Reaproveitamento |
| **🎭 Polimorfismo** | Múltiplas formas | @Override + interface comum | Flexibilidade |

Lembre-se: **Encapsulamento** protege, **Herança** reutiliza, **Polimorfismo** flexibiliza! 💪☕

---

*"POO não é apenas sobre código, é sobre modelar o mundo real de forma elegante e eficiente!"* 🌟