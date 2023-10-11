import java.util.concurrent.PriorityBlockingQueue;

public class Tutor implements Runnable {
    private PriorityBlockingQueue<Utente> codaprioritaria;
    private SalaComputer salaComputer;

    public Tutor(PriorityBlockingQueue<Utente> codaprioritaria, SalaComputer salaComputer) {
        this.codaprioritaria = codaprioritaria;
        this.salaComputer = salaComputer;
    }

    @Override
    public void run() {
        while (true) {
            if(!codaprioritaria.isEmpty()){
                Utente utente = codaprioritaria.poll();
                if(utente instanceof UtenteTerm)
                    break;
                Thread thread = new Thread(new Smistatore(salaComputer, utente));
                thread.start();
            }
        }
    }
}


