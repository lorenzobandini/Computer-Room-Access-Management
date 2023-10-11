public class Professore implements Utente {

    public void azione() {
        System.out.println("Professore sta usando tutti i computer");
        try {
            int random = (int) (Math.random() * 500) + 1000;
            Thread.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
