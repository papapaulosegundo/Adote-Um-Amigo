package negocio;

public class Usuario {

    private String nome;
    private String login;
    private String senha;
    private TipoUsuario tipo;
    private Cliente cliente;

    public Usuario(String nome, String login, String senha, TipoUsuario tipo) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }   

    public String getLogin() {
        return login;
    }
    public String getSenha() {
        return senha;
    }

    public boolean isCliente() {
        return tipo == TipoUsuario.CLIENTE;
    }

    public boolean isAbrigo() {
        return tipo == TipoUsuario.ABRIGO;
    }
    

}
