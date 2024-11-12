package negocio;

import util.ExcecaoAnimalNaoDisponivel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.io.*;

public class Abrigo {
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Animal> animais = new ArrayList<Animal>();
    private Usuario usuarioAtivo;

    public Abrigo() {
        // buscar os usuarios salvos
        carregarUsuarios();

        // usuario fixo para teste
        usuarios.add(new Usuario("Paulo", "paulo", "123", TipoUsuario.ABRIGO));
        usuarios.add(new Usuario("Cliente", "cliente", "123", TipoUsuario.CLIENTE));
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
            if( usuarioAtivo.isCliente() )
                JOptionPane.showMessageDialog(null, "Cliente logado com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Abrigo logado com sucesso!");

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

    public void cadastrarUsuario() {
        String nome, login, senha;

        nome = JOptionPane.showInputDialog("Informe seu nome");
        login = JOptionPane.showInputDialog("Informe seu login");
        senha = JOptionPane.showInputDialog("Informe uma senha");

        usuarios.add(new Usuario(nome, login, senha, TipoUsuario.CLIENTE));

        JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
        salvarUsuarios();
    }

    private void salvarUsuarios() {

        try {
            FileOutputStream fos = new FileOutputStream("usuarios.txt");
            ObjectOutputStream os = new ObjectOutputStream(fos);

            for( Usuario user : usuarios ) {
                os.writeObject(user);
            }            
            
            os.close();
            fos.close();
        } catch (IOException e ){
            System.out.println(e.getMessage());
        }
    }

    private void carregarUsuarios() {

        try {
            FileInputStream fis = new FileInputStream("usuarios.txt");
            ObjectInputStream is = new ObjectInputStream(fis);
            Usuario user;

            while( (user = (Usuario) is.readObject()) != null ) {
                usuarios.add(user);
            }            
            
            is.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e ){
            System.out.println(e.getMessage());
        }
    }
    public Usuario getUsuarioAtivo() {
        return usuarioAtivo;
    }

    // operacoes para usuario do abrigo
    public void operacoesAbrigo() {
        JOptionPane.showMessageDialog(null, "Operacoes do abrigo");    }

    // operacoes para usuario cliente
    public void operacoesCliente() {
        // tratamento da exceção gerada pelo método adotar();
        try {
            adotar();
        } catch (ExcecaoAnimalNaoDisponivel e) { // captura a exceção lançada no método adotar()
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
}
