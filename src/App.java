import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // String url = "https://alura-filmes.herokuapp.com/conteudos";
        // ExtratorConteudo extrator = new ExtratorConteudoImdb();

        String url = "https://api.nasa.gov/planetary/apod?api_key=AaZVCluksUYd1Kzb15BWcSGWqagiIAFk6tf1J3CG&start_date=2022-05-01&end_date=2022-06-01";
        ExtratorConteudo extrator = new ExtratorConteudoNasa();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0 ; i < 3; i ++) {
            Conteudo conteudo = conteudos.get(i);

            String nomeArquivo = (conteudo.getTitulo() + ".png");
            InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();

            System.out.println(conteudo.getTitulo());
            System.out.println(conteudo.getUrlImage());
            geradora.cria(inputStream, nomeArquivo);
        };
    }
}
