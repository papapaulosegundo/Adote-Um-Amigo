package negocio;

public class Cachorro extends Animal implements Passeavel {
    private String porte;

    public Cachorro(String nome, int idade, boolean castracao, float peso, String cor, String raca, String porte) {
        super(nome, idade, castracao, peso, cor, raca);
        this.porte = porte;
    }

    @Override
    public void passear() {
        System.out.println("Pesseando com o cachorro " + getNome());
    }

    @Override
    public void emitirSom() {
        System.out.println("Au au au");
    }

}
