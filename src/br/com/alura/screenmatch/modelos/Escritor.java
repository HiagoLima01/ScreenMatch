package br.com.alura.screenmatch.modelos;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Escritor {

    public void criarArquivo(List<Titulo> titulos, Gson gson){
        try{
            FileWriter writer = new FileWriter("filmes.json");
            writer.write(gson.toJson(titulos));
            writer.flush();
            writer.close();
            System.out.println(titulos);
        }catch(IOException e){
            System.out.println("Aconteceu um erro");
            System.out.println(e.getMessage());
        }

    }
}
