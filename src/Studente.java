public class Studente implements Utente{

    public void azione(int computer) {
        System.out.println("Studente sta usando computer " + computer);
        try{
            int random = (int) (Math.random() * 300) + 200;
            Thread.sleep(random);
        }catch(InterruptedException e){
            e.printStackTrace();
        }        
    }
    
}
