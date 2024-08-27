package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.AnoComMaisDe4CharsException;
import br.com.alura.screenmatch.excecao.TituloNaoExisteException;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb tituloOmdb) throws TituloNaoExisteException {
        this.nome = tituloOmdb.title();

        if(tituloOmdb.year() == null){
            throw new TituloNaoExisteException("Titulo Não existe em nosso Catalogo");
        }
        if(tituloOmdb.year().length()>4){
            throw new AnoComMaisDe4CharsException("Não consegui converter o Ano pois tem mais de 4 caracteres");
        }
        this.anoDeLancamento = Integer.parseInt(tituloOmdb.year());
        this.duracaoEmMinutos = Integer.parseInt(tituloOmdb.runtime().substring(0,3).replace(" ", ""));
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }


    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "(Titulo: " +nome+ " Ano de Lançamento: " + anoDeLancamento+ " Duração: " + duracaoEmMinutos + ")";
    }
}
