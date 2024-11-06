package negocio;

import util.ExcecaoAnimalNaoDisponivel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Abrigo {
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Animal> animais = new ArrayList<Animal>();
    private Usuario usuarioAtivo;

    public Abrigo() {
        // usuario fixo para teste
        usuarios.add(new Usuario("Paulo", "paulo", "123"));
    }

    public boolean buscaUsuario(String login, String senha) {
        for( Usuario user : usuarios ) {
            if( user.getLogin().equals(login) && 
                user.getSenha().equals(senha)) {
                    usuarioAtivo = user;
                    return true;
            }
        }   
        return false;
    }
    public boolean login() {
        String login = JOptionPane.showInputDialog("Informe seu login");
        String senha = JOptionPane.showInputDialog("Informe sua senha: ");
        if( !buscaUsuario(login, senha)) {
            JOptionPane.showMessageDialog(null, "Usuario não cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Usuario logado com sucesso!");
            return true;
        }
    }

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
