package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroCliente {

    // Lista para armazenar os clientes cadastrados
    private List<Cliente> clientes = new ArrayList<>();

    // Método para cadastrar um novo cliente
    public void cadastrarCliente(String nome, String cpf, String login, String senha) {
        // Verifica se o login já está em uso
        if (verificarLoginExistente(login)) {
            System.out.println("Este login já está em uso. Tente outro.");
            return;
        }
        // Cria o novo cliente e adiciona à lista
        Cliente cliente = new Cliente(nome, cpf, login, senha);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    // Método para verificar se o login já existe
    private boolean verificarLoginExistente(String login) {
        for (Cliente cliente : clientes) {
            if (cliente.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            CadastroCliente cadastro = new CadastroCliente();

            // Loop para o menu de cadastro
            while (true) {
                System.out.println("1. Cadastrar Cliente");
                System.out.println("2. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (opcao) {
                    case 1:
                        // Solicita os dados do cliente
                        System.out.print("Digite o seu nome completo: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o seu cpf: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Digite o login: ");
                        String login = scanner.nextLine();
                        System.out.print("Digite a senha: ");
                        String senha = scanner.nextLine();

                        // Cadastra o cliente
                        cadastro.cadastrarCliente(nome, cpf, login, senha);
                        break;

                    case 2:
                        // Encerra o programa
                        System.out.println("Saindo...");
                        return;

                    default:
                        System.out.println("Opção inválida!");
                }
            }
        }
    }
}
