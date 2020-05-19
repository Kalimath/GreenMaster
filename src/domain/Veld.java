package domain;

public class Veld extends Moestuin {

    public Veld(String naam, int lengte, int breedte) {
        super(naam, lengte, breedte);
    }

    @Override
    public String toString() {
        String uit = "Veld: " +this.getNaam()+'\n'+"Oppervlakte: "+ this.getOppervlakte() + " m\n"+
                "--------------------------------------------------------------------------------\n";
        int teller = 1;
        for (Plantenrij rij : this.kollomen) {
            uit += teller++ + ":  " + rij.toString()+'\n'+'\n'+'\n';
        }
        uit += "--------------------------------------------------------------------------------\n";
        return uit;
    }
}
