import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;


public class CSVHandler {

    public List<String> listaComLinhas = new LinkedList<>();
    public List<String> listaProcessada = new LinkedList<>();


    void lerArquivo(int indice) throws IOException {
        String nomeArquivo = "C:\\Users\\D892630\\IdeaProjects\\FactoryOfThreads\\src\\1000RegistrosMagicos_" + indice + ".csv";
        listaComLinhas = Files.readAllLines(Paths.get(nomeArquivo));

        for (int i=0; i < listaComLinhas.size(); i++){
            listaProcessada.add(listaComLinhas.getFirst());
            listaComLinhas.removeFirst();
        }
    }
}
