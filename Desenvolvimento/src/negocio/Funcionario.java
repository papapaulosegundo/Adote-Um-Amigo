package negocio;

public abstract class Funcionario {
    private String nome;
    private String telefone;
    private int CRMV;
    private int email;

    public Funcionario(String nome, String telefone, int CRMV, int email) {
        this.nome = nome;
        this.telefone = telefone;
        this.CRMV = CRMV;
        this.email = email;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public int getCRMV(){
        return CRMV;
    }

    public void setCRMV(int CRMV){
        this.CRMV = CRMV;
    }

    public int getEmail(){
        return email;
    }

    public void setEmail(int email){
        this.email = email;
    }

}
