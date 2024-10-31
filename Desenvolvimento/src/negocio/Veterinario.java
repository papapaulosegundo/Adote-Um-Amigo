package negocio;

public class Veterinario extends Funcionario {
    public int CRMV;

    public Veterinario(String nome, String telefone, String email, int CRMV) {
        super(nome, telefone, email);
        this.CRMV = CRMV;

    }

    public int getCRMV() {
        return CRMV;
    }

    public void setCRMV(int CRMV) {
        this.CRMV = CRMV;
    }

    // metodo consultar o animal não especificado ainda qual
    public boolean consultar(Animal a) {
        return true;
    }

    @Override
    public void mostrarInformacoes() {
        throw new UnsupportedOperationException("Unimplemented method 'mostrarInformacoes'");
    }

}
