import javax.swing.JOptionPane;

import negocio.Abrigo;
import negocio.Cliente;
import util.*;

public class Main {

    public static void main(String[] args) {
        Abrigo a = new Abrigo();
        Cliente c = new Cliente();

        // tratamento da exceção gerada pelo método adotar();
        try {
            a.adotar();
        } catch( ExcecaoAnimalNaoDisponivel e) {    // captura a exceção lançada no método adotar()
            JOptionPane.showMessageDialog(null, e.getMessage());
         }


    }
}
