    package br.com.alura.screenmatch.principal;

    import br.com.alura.screenmatch.excecao.AnoComMaisDe4CharsException;
    import br.com.alura.screenmatch.excecao.TituloNaoExisteException;
    import br.com.alura.screenmatch.modelos.Buscador;
    import br.com.alura.screenmatch.modelos.Escritor;
    import br.com.alura.screenmatch.modelos.Titulo;
    import br.com.alura.screenmatch.modelos.TituloOmdb;
    import com.google.gson.FieldNamingPolicy;
    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;

    import java.io.IOException;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    public class PrincipalComBusca {
        public static void main(String[] args) throws InterruptedException, IOException{
        	
        	//Instanciando objetos para utilização durante o app
        	
            Scanner sc = new Scanner(System.in);
            Buscador buscador = new Buscador();
            List<Titulo> titulos = new ArrayList<>();
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();
            Escritor escritor = new Escritor();

            System.out.println("Digite a chave da sua API OMDB");
            String apiKey = sc.nextLine();
            System.out.println("Para finalizar o programa escreva Sair");
            
            String busca = " ";


            while (!busca.equalsIgnoreCase("Sair")) {
            	
                try {
                	
                	System.out.println("Digite um filme para busca: ");
                    busca = sc.nextLine();

                    if (busca.equalsIgnoreCase("Sair")) {
                        break;
                    }


                    String corpoResposta = buscador.buscar(busca, apiKey);

                    TituloOmdb meuTiltuloOmdb = gson.fromJson(corpoResposta, TituloOmdb.class);

                    Titulo meuTitulo = new Titulo(meuTiltuloOmdb);
                    System.out.println(meuTitulo);

                    titulos.add(meuTitulo);
                    
                } catch (AnoComMaisDe4CharsException e) {
                    System.out.println("Aconteceu um erro");
                    System.out.println(e.getMessage());
                  
                } catch(TituloNaoExisteException e) {
                	System.out.println("Aconteceu um erro");
                    System.out.println(e.getMessage());
                    
                }
            }
            
            escritor.criarArquivo(titulos, gson);
            
            sc.close();
            System.out.println("Finalizando programa");
        }
    }