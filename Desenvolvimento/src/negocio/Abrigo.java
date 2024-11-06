package negocio;

import util.ExcecaoAnimalNaoDisponivel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Abrigo {
    private List<Animal> animais = new ArrayList<Animal>();

    public void adotar() {

        String animal = JOptionPane.showInputDialog("Escolha um animal: ");
        if (!animal.equalsIgnoreCase("Gato") && !animal.equalsIgnoreCase("Cachorro")) {
            // caso seja um animal não disponível, lança a exceção
            throw new ExcecaoAnimalNaoDisponivel("Animal não disponível: " + animal);
        }
        JOptionPane.showMessageDialog(null, "Parabens, voce adotou um " + animal);

    }

    // Chamadas Polimorficas 
    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
    }

    public void sons() {
        for( Animal animal : animais ) {
            animal.emitirSom();
        }
    }
    
}
