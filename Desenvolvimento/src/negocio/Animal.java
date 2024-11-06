package negocio;

public abstract class Animal {
    private String nome;
    private int idade;
    private boolean castracao;
    private double peso;
    private String cor;
    private String raca;

    // o construtor pode ser chamado nas subclasses
    public Animal(String nome, int idade, boolean castracao, double peso, String cor, String raca) {
        this.nome = nome;
        this.idade = idade;
        this.castracao = castracao;
        this.peso = peso;
        this.cor = cor;
        this.raca = raca;
    }

    // Getters / Encapsulamento
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isCastracao() {
        return castracao;
    }

    public double getPeso() {
        return peso;
    }

    public String getCor() {
        return cor;
    }

    public String getRaca() {
        return raca;
    }

    // Setters / Encapsulamento
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCastracao(boolean castracao) {
        this.castracao = castracao;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public double calcularTaxaAdocao() {
        double taxa = 100;
        if( isCastracao() ) {
            taxa += 20;
        }
        return taxa;
    }

    // Método abstrato
    public abstract void emitirSom();
}