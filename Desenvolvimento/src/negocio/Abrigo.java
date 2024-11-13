package negocio;

import util.ExcecaoAnimalNaoDisponivel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.io.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

        // Metodo adicionarAnimal polimorfico 
        // animais fixos para teste
        adicionarAnimal(new Gato("Ichigo", 3, true, 4.0, "Laranja", "SRD", true)); //flashinho
        adicionarAnimal(new Gato("Yummi", 1, false, 4.0, "Laranja", "SRD", false)); // lyon
        adicionarAnimal(new Gato("Zed", 1, true, 5.0, "Preto e Branco", "Maine Coon", false)); // tommy
        adicionarAnimal(new Gato("Nidalee", 2, false, 4.0, "Rajada", "SRD", false)); // minimi
        adicionarAnimal(new Cachorro("Lux", 3, true, 5.0, "Amarelo", "SRD", "Médio")); //bela
        adicionarAnimal(new Cachorro("Nasus", 1, true, 3.0, "Marrom", "SRD", "Grande")); //cachorro2
        adicionarAnimal(new Cachorro("Janna", 1, true, 2.0, "Amarelo", "SRD", "Pequeno")); //cachorro1 (foto)
        adicionarAnimal(new Cachorro("Ryze", 1, true, 2.0, "Brancp", "Chow-Chow", "Grande")); // chowchow

    }

    // Usuario e senha cadastrado
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

    /// login
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

    // Busca animal pelo nome
    public Animal buscaAnimal(String nome) {
        for( Animal animal : animais ) {
            if( animal.getNome().equalsIgnoreCase(nome)) {
                    return animal;
            }
        }   
        return null;
    }

    //Lança a Exception (adotar so animal cadastrado)
    public void adotar() {
        Animal animalAdotado;
        String animal = JOptionPane.showInputDialog("Escolha um animal: ");
        if ( (animalAdotado = buscaAnimal(animal)) == null) {
            // caso seja um animal não disponível, lança a exceção
            throw new ExcecaoAnimalNaoDisponivel("Animal não disponível: " + animal);
        } else {
            animalAdotado.adotar();
            double taxa = animalAdotado.calcularTaxaAdocao();
            JOptionPane.showMessageDialog(null, "Parabens, voce adotou o " + animal + 
                                            "\nTaxa de adoção: R$ " + String.format("%.2f", taxa) +
                                            "\n"+animalAdotado.emitirSom());
            
            
        }
    }

    // Chamadas Polimorficas 
    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
    }

    // Cadastro
    public void cadastrarUsuario() {
        String nome, login, senha;

        nome = JOptionPane.showInputDialog("Informe seu nome");
        login = JOptionPane.showInputDialog("Informe seu login");
        senha = JOptionPane.showInputDialog("Informe uma senha");

        usuarios.add(new Usuario(nome, login, senha, TipoUsuario.CLIENTE));

        JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
        salvarUsuarios();
    }

    // Serializable no txt
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

    // Carrega do txt  
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

    // Qual usuario logado
    public Usuario getUsuarioAtivo() {
        return usuarioAtivo;
    }

    // operacoes para Abrigo / Interface passear
    public void operacoesAbrigo() {
        String animaisP = "";
        for( Animal animal : animais ) {
            if( animal instanceof Passeavel ) {
                animaisP += animal.getNome() + "\n";
            }
        }
        String animalP = JOptionPane.showInputDialog(animaisP + "\nEscolha um animal para passear");

        for( Animal animal : animais ) {
            if( animal.getNome().equalsIgnoreCase(animalP) ) {
                JOptionPane.showMessageDialog(null, ((Passeavel) animal).passear());
            }
        }
    }

    // Permite usuario a adotar
    public void operacoesCliente() {
        // tratamento da exceção gerada pelo método adotar();
        mostrarAnimais();
        try {
            adotar();
        } catch (ExcecaoAnimalNaoDisponivel e) { // captura a exceção lançada no método adotar()
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

 // Mostrar os animais
 public void mostrarAnimais() {
    JFrame janela = new JFrame("Animais Disponíveis");
    janela.setLayout(new FlowLayout());

    // Criando os JLabel para exibir os nomes dos animais
    for( Animal animal : animais ) {
        JLabel label;
        if( animal instanceof Gato ) {
            label = new JLabel("Gato: " + animal.getNome());
        } else {
            label = new JLabel("Cachorro: " + animal.getNome());
        }
        label.setPreferredSize(new Dimension(300, 20));
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        janela.add(label);
    }

    // Configurações da janela
    janela.setSize(400, 300);
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    janela.setVisible(true);
}
}
