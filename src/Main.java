import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException{

        CSVHandler handler = new CSVHandler();

        long tempoInicial = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            handler.lerArquivo(i);
        }
        long tempoFinal = System.currentTimeMillis();
        long tempoDecorridoSemThread = tempoFinal - tempoInicial;


        ThreadFactory virtualThreadFactory = Thread.ofVirtual().factory();

        ExecutorService executor =
                Executors.newFixedThreadPool(10, virtualThreadFactory);


        long tempoInicialComThreads = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> {
                try {
                    handler.lerArquivo(finalI);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()){

        }

        long tempoDecorridoComThread = System.currentTimeMillis() - tempoInicialComThreads;
        System.out.println("Tempo de execução sem Threads: " + tempoDecorridoSemThread + " ms");
        System.out.println("Tempo de execução com Threads: " + tempoDecorridoComThread + " ms");

        System.out.println("Terminado!");
    }

}
