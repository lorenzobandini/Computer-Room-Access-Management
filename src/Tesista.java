public class Tesista implements Utente{
    private int computerassociato;

    public Tesista() {
        this.computerassociato = (int) (Math.random() * 20);
    }

    public int getComputerassociato() {
        return computerassociato;
    }

    public void azione() {
        System.out.println("Tesista sta usando computer "+ this.computerassociato);
        try{
            int random = (int) (Math.random() * 300) + 400;
            Thread.sleep(random);
        }catch(InterruptedException e){
            e.printStackTrace();
        }        
    }

}
