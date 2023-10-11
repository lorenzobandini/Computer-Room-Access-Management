import java.util.concurrent.PriorityBlockingQueue;


public class Riempitore implements Runnable{
    private PriorityBlockingQueue<Utente> codaprioritaria;

    public Riempitore(PriorityBlockingQueue<Utente> codaprioritaria) {
        this.codaprioritaria = codaprioritaria;
    }
    @Override
    public void run() {
        for (int i=0; i< 100; i++) {
            Utente utente = null;
            int random = (int) (Math.random()*100);

            if(random < 10)
                utente = new Professore();
            else if(random < 30)
                utente = new Tesista();
            else
                utente = new Studente();

            codaprioritaria.put(utente);
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        codaprioritaria.put(new UtenteTerm());
    }
}
