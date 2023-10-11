public class Smistatore implements Runnable {
    private Utente utente;
    private SalaComputer salaComputer;
    
    public Smistatore(SalaComputer salaComputer, Utente utente) {
        this.salaComputer = salaComputer;
        this.utente = utente;
    }
    
    @Override
    public void run() {
        if(utente instanceof Professore){
            salaComputer.arrivaprofessore((Professore)utente);
        }

        if (utente instanceof Tesista) {
            while(!salaComputer.occupailcomputer((Tesista) utente)){
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            ((Tesista)utente).azione();
            salaComputer.liberacomputer(((Tesista) utente).getComputerassociato());
        }

        if(utente instanceof Studente){
            int computer = salaComputer.occupaprimocomputer();
            while(computer == -1){
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                computer = salaComputer.occupaprimocomputer();
            }
            ((Studente)utente).azione(computer);
            salaComputer.liberacomputer(computer);
        }
    }
}
