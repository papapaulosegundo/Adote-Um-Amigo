package negocio;

public class Cachorro extends Animal implements Passeavel {
    private String porte;

    public Cachorro(String nome, int idade, boolean castracao, double peso, String cor, String raca, String porte) {
        super(nome, idade, castracao, peso, cor, raca);
        this.porte = porte;
    }

    // Encapsulamento
    public String getPorte() {
        return porte;
    }
    public void setPorte(String porte) {
        this.porte = porte;
    }

    // Metodo da interface sobrescrito
    @Override
    public void passear() {
        System.out.println("Passeando com o cachorro " + getNome());
    }

    // Metodo abstrato sobrescrito
    @Override
    public String emitirSom() {
        return "Au au au";
    }
    
    // Metodo sobrescrito
    public double calcularTaxaAdocao() {
        double taxa = super.calcularTaxaAdocao();
        if( porte.equals("grande")) {
            taxa += taxa * 0.1;
        }
        return taxa;
    }
}
