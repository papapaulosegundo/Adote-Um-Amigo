package negocio;

public class Gato extends Animal {

    private boolean fivFelv;

    public Gato(String nome, int idade, boolean castracao, float peso, String cor, String raca, boolean fivFelv) {
        super(nome, idade, castracao, peso, cor, raca);
        this.fivFelv = fivFelv;
    }

    public boolean isFivFelv() {
        return fivFelv;
    }

    public void setFivFelv(boolean fivFelv) {
        this.fivFelv = fivFelv;
    }

    @Override
    public void emitirSom() {
        System.out.println("Miau miau");
    }

}
