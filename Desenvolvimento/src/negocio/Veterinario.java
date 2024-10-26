 package negocio;

public class Veterinario extends Funcionario {


    public Veterinario(String nome, String telefone, int CRMV, int email) {
        super(nome, telefone, CRMV, email);

    }
    
//metodo consultar o animal não especificado ainda qual
    public boolean consultar(Animal a){
        return true;
    }

}
