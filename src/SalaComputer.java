import java.util.Arrays;

public class SalaComputer {
    private boolean[] computers;

    public SalaComputer(){
        this.computers = new boolean[20];
        Arrays.fill(this.computers, true);
    }


    synchronized void liberacomputer(int i){
        this.computers[i] = true;
    }

    synchronized void liberatutticomputer(){
        Arrays.fill(this.computers, true);
    }

    synchronized boolean occupailcomputer(Tesista tesista){
        if(this.computers[tesista.getComputerassociato()]){
            this.computers[tesista.getComputerassociato()] = false;
            return true;
        }
        return false;
    }

    synchronized int occupaprimocomputer(){
        for(int i=0; i<computers.length; i++){
            if(this.computers[i]){
                this.computers[i] = false;
                return i;
            }
        }
        return -1;
    }

    boolean controllatutticomputer(){
        for(int i=0; i<computers.length; i++){
            if(!this.computers[i]){
                return false;
            }
        }
        return true;
    }

    synchronized void arrivaprofessore(Professore professore){
        while(this.controllatutticomputer()){
           try{
               Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            } 
        }
        professore.azione();
        this.liberatutticomputer();
    }
}
