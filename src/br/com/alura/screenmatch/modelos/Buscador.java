package br.com.alura.screenmatch.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Buscador {

    public String buscar(String nomeFilme, String apiKey) {
    	
    	/**
    	 * Faz uma requisição à API OMDb para buscar informações sobre o filme desejado filme.
    	 *
    	 * @param nomeFilme, O nome do filme a ser pesquisado. Espaços no nome do filme serão substituídos por "+" na URL.
    	 * @param apiKey A chave da API OMDb para autenticação.
    	 * @return Uma String contendo o corpo da resposta JSON da API OMDb.
    	 * @throws RuntimeException Se ocorrer um erro de I/O ou se a thread for interrompida durante a execução da requisição.
    	 */

        HttpResponse<String> response;

        try {

            String endereco = "https://www.omdbapi.com/?t=" + nomeFilme.replace(" ", "+") + "&apikey=" + apiKey;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            response = null;

            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException e) {
            throw new RuntimeException(e);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

        String corpoResposta = response.body();

        return corpoResposta;

    }
}
