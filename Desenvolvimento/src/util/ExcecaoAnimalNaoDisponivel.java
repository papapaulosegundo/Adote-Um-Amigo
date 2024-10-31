package util;

// Excecção para sinalizar que o animal não está disponível
// Herança da classe RuntimeException (Exceção que não precisa de tratamento obrigatório)

public class ExcecaoAnimalNaoDisponivel extends RuntimeException {
    

    public ExcecaoAnimalNaoDisponivel() {
        super("Animal não disponível!");
    }

    public ExcecaoAnimalNaoDisponivel(String msg) {
        super(msg);
    }
}
