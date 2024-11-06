package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroUsuario {
    private List<Usuario> usuarios;

    public CadastroUsuario() {
        this.usuarios = new ArrayList<>();
    }

    // Método para permitir que o usuário cadastre seu nome, login e senha
    public void adicionarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de novo usuário:");

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu login: ");
        String login = scanner.nextLine();

        if (buscarUsuarioPorLogin(login) != null) {
            System.out.println("Erro: Já existe um usuário com esse login.");
            return;
        }

        // Solicitar a senha do usuário
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        // Criar o objeto Usuario com os dados fornecidos
        Usuario usuario = new Usuario(nome, login, senha);

        // Adicionar o usuário à lista
        usuarios.add(usuario);

        System.out.println("Usuário " + nome + " cadastrado com sucesso.");
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
