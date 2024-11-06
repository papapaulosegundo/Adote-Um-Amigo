import javax.swing.JOptionPane;

import negocio.Abrigo;
import negocio.Cliente;
import negocio.Gato;
import negocio.Cachorro;
import util.*;

public class Main {

    public static void main(String[] args) {
        Abrigo a = new Abrigo();

        // Chamada polimorfica de abrigo
        a.adicionarAnimal(new Gato("Tom", 3, false , 4.0, "cinza", "indefinida", false ));
        a.adicionarAnimal(new Cachorro("Spike", 5, true , 5, "cinza", "bulldog", "medio"));

        a.sons();

        Cliente c = new Cliente();

        // tratamento da exceção gerada pelo método adotar();
        try {
            a.adotar();
        } catch (ExcecaoAnimalNaoDisponivel e) { // captura a exceção lançada no método adotar()
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
