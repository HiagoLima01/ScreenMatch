package br.com.alura.screenmatch.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Buscador {

    public String buscar(String nomeFilme, String apiKey) {

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
