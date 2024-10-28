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

}
