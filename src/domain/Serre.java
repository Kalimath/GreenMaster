package domain;

public class Serre extends Moestuin {

    public Serre(String naamserre, int lengte, int breedte) {
        super(naamserre, lengte, breedte);

    }

    @Override
    public String toString() {
        String uit = "Serre: " +this.getNaam()+'\n'+"Oppervlakte: "+ this.getOppervlakte() + " m\n";
        uit+="--------------------------------------------------------------------------------\n    ";
        for(int i= 1; i<=this.getBreedte(); i++) {
            uit += " "+i+" \t";
        }
        uit +="\n\n";
        int teller = 1;
        for (Plantenrij rij : this.kollomen) {
            uit += teller++ + "   " + rij.toString()+'\n'+'\n'+'\n';
        }
        uit += "--------------------------------------------------------------------------------\n";
        return uit;
    }

}
