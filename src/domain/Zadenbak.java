package domain;

import domain.zaaibaar.Zaaibaar;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Zadenbak extends Bak{

    private ArrayList<Zaaibaar> zaden;
    private ArrayList<String> soortNamen;

    public Zadenbak() {
        zaden = new ArrayList<Zaaibaar>();
    }

    public void getSoortNamenInZadenbak(){
        for(Zaaibaar z : zaden){
            if(z!=null){
                soortNamen.add(z.soortNaam);
            }
        }
    }

    public void voegZaadToe(Zaaibaar zaad){
        zaden.add(zaad);
    }

    public int aantalSoorten() {
        return zaden.size();
    }

    public int aantalZaden() {
        int aantal = 0;
        for(Zaaibaar z: zaden) {
            aantal+= z.getAantal();
        }
        return aantal;
    }

    public ArrayList<Zaaibaar> getZaden(){
        return zaden;
    }

    public Zaaibaar get(String naam) {
        Zaaibaar z = null;
        if(naam.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Zaad oproepen mislukt", "Error", JOptionPane.CANCEL_OPTION);
        }
        for(Zaaibaar p : zaden) {
            if(p.getNaam().trim().toLowerCase().equals(naam.trim().toLowerCase())) {
                z = p;
            }
        }
        return z;
    }

    public String printZaden() {
        String uit = "Zadenlijst: " + "\n--------------------------------------------------------------------------------"
                + "\n" + "Zadenlijst bevat " + this.aantalZaden()+
                " zaden.\nZadenlijst bevat "+ this.aantalSoorten() + " verschillende soort(en) zaden"
                + "\n--------------------------------------------------------------------------------\n";
        for(Zaaibaar z: zaden) {
            uit += " - "+z.getNaam()+" ("+z.getSoort()+")\n";

        }
        return uit;
    }

    public String printZadenMetInfo() {
        String uit = "Zadenlijst: " + "\n--------------------------------------------------------------------------------"
                + "\n" + "Zadenlijst bevat " + this.aantalZaden()+
                " zaden.\nZadenlijst bevat "+ this.aantalSoorten() + " verschillende soort(en) zaden"
                + "\n--------------------------------------------------------------------------------\n";
        for(Zaaibaar z: zaden) {
            uit += z.toString()+"--------------------\n\n";
        }
        return uit;
    }
}
