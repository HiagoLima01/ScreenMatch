package br.com.alura.screenmatch.excecao;

public class TituloNaoExisteException extends Exception{
    private String mensagem;

    public TituloNaoExisteException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
