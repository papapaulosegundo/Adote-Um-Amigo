package negocio;

public abstract class Animal {
    private String nome;
    private int idade;
    private boolean castracao;
    private float peso;
    private String cor;
    private String raca;

    public Animal(String nome, int idade, boolean castracao, float peso, String cor, String raca) {
        this.nome = nome;
        this.idade = idade;
        this.castracao = castracao;
        this.peso = peso;
        this.cor = cor;
        this.raca = raca;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isCastracao() {
        return castracao;
    }

    public float getPeso() {
        return peso;
    }

    public String getCor() {
        return cor;
    }

    public String getRaca() {
        return raca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCastracao(boolean castracao) {
        this.castracao = castracao;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}