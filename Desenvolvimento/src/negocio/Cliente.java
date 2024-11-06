package negocio;

public class Cliente {

    private String nome;
    private String cpf;
    private String login;
    private String senha;

    public Cliente(String nome, String cpf, String login, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}
