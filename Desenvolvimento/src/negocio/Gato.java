package negocio;

public class Gato extends Animal {

    private boolean fivFelv;

    public Gato(String nome, int idade, boolean castracao, double peso, String cor, String raca, boolean fifFelv) {
        super(nome, idade, castracao, peso, cor, raca);
        this.fivFelv = fivFelv;
    }

    // Metodo abstrato sobrescrito
    @Override
    public void emitirSom() {
        System.out.println("Miau miau");
    }
    
     // Metodo sobrescrito
     public double calcularTaxaAdocao() {
        double taxa = super.calcularTaxaAdocao();
        if( fivFelv ) {
            taxa = 0;
        }
        return taxa;
    }   
}
