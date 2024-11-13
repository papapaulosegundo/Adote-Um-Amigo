import javax.swing.JOptionPane;

import negocio.Abrigo;
import negocio.Cliente;
import negocio.Gato;
import negocio.Cachorro;
import util.*;

public class Main {

    //Menu de opções / operações do abrigo
    public static void main(String[] args) {
        Abrigo abrigo = new Abrigo();

        String opcao;

        do {
            opcao = JOptionPane.showInputDialog("Selecione uma opção:\n1 - Login\n2 - Cadastrar Usuario\n3 - Encerrar");
            if (opcao.equals("1")) {
                if (abrigo.login()) {
                    if (abrigo.getUsuarioAtivo().isAbrigo()) {
                        abrigo.operacoesAbrigo();
                    } else {
                        abrigo.operacoesCliente();
                    }
                }
            }
            if (opcao.equals("2")) {
                abrigo.cadastrarUsuario();
            }
        } while (!opcao.equals("3"));
    }
}
