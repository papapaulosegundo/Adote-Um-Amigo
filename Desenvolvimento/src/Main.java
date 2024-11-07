import javax.swing.JOptionPane;

import negocio.Abrigo;
import negocio.Cliente;
import negocio.Gato;
import negocio.Cachorro;
import util.*;

public class Main {

    public static void main(String[] args) {
        Abrigo abrigo = new Abrigo();

        int opcao;

        do {
            opcao = Integer.parseInt(
                    JOptionPane
                            .showInputDialog("Selecione uma opção:\n1 - Login\n2 - Cadastrar Usuario\n3 - Encerrar"));
            if (opcao == 1) {
                if (abrigo.login()) {
                    if (abrigo.getUsuarioAtivo().isAbrigo()) {
                        abrigo.operacoesAbrigo();
                    } else {
                        abrigo.operacoesCliente();
                    }
                }
            }
            if (opcao == 2) {
                abrigo.cadastrarUsuario();
            }

        } while (opcao != 3);

        /*
         * // Chamada polimorfica de abrigo
         * a.adicionarAnimal(new Gato("Tom", 3, false , 4.0, "cinza", "indefinida",
         * false ));
         * a.adicionarAnimal(new Cachorro("Spike", 5, true , 5, "cinza", "bulldog",
         * "medio"));
         * 
         * a.sons();
         * 
         * Cliente c = new Cliente();
         * 
         * // tratamento da exceção gerada pelo método adotar();
         * try {
         * a.adotar();
         * } catch (ExcecaoAnimalNaoDisponivel e) { // captura a exceção lançada no
         * método adotar()
         * JOptionPane.showMessageDialog(null, e.getMessage());
         * }
         */
    }
}
