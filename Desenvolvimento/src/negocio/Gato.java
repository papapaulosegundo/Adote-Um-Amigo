package negocio;

public class Gato extends Animal {

    private boolean fivFelv;

    public Gato(String nome, int idade, boolean castracao, float peso, String cor, String raca, boolean fifFelv) {
        super(nome, idade, castracao, peso, cor, raca);
        this.fivFelv = fivFelv;
    }

    @Override
    public void emitirSom() {
        System.out.println("Miau miau");
    }

}
