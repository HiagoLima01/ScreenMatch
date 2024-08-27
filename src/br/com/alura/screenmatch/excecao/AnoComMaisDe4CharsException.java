package br.com.alura.screenmatch.excecao;

public class AnoComMaisDe4CharsException extends RuntimeException {
    private String mensagem;

    public AnoComMaisDe4CharsException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
