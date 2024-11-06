package negocio;

import java.util.ArrayList;
import java.util.List;

public class CadastroUsuario {
    private List<Usuario> usuarios;

    public CadastroUsuario() {
        this.usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        // Verificar se já existe um usuário com o mesmo login
        if (buscarUsuarioPorLogin(usuario.getLogin()) != null) {
            System.out.println("Erro: Já existe um usuário com esse login.");
        } else {
            usuarios.add(usuario);
            System.out.println("Usuário " + usuario.getLogin() + " cadastrado com sucesso.");
        }
    }

    // Método para buscar um usuário pelo login
    public Usuario buscarUsuarioPorLogin(String login) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                return usuario;
            }
        }
        return null;
    }

    // Método para validar login e senha
    public boolean autenticarUsuario(String login, String senha) {
        Usuario usuario = buscarUsuarioPorLogin(login);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return true;
        }
        return false;
    }

    // Método para listar todos os usuários cadastrados
    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("Usuários cadastrados:");
            for (Usuario usuario : usuarios) {
                System.out.println("Nome: " + usuario.getLogin());
            }
        }
    }
}
