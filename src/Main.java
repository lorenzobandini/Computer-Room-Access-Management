import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void main(String[] args) throws Exception {

        PriorityBlockingQueue<Utente> codaprioritaria = new PriorityBlockingQueue<Utente>(10,new ComparatoreUtenti());

        Thread riempitore = new Thread(new Riempitore(codaprioritaria));
        riempitore.start();

        SalaComputer salaComputer = new SalaComputer();

        Thread tutor = new Thread(new Tutor(codaprioritaria, salaComputer));
        tutor.start();

        riempitore.join();
        tutor.join();
    }
}
