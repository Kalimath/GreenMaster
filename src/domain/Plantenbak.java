package domain;

import domain.planten.*;
import domain.zaaibaar.*;



import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Plantenbak extends Bak{

    private ArrayList<Plant> planten;
    private ArrayList<String> soortNamen;
    public Plantenbak() {
        planten = new ArrayList<Plant>();
        soortNamen = new ArrayList<>();
    }

    public void voegPlantToe(Plant plant){
        planten.add(plant);
    }

    public void getSoortNamenInZadenbak(){
        for(Plant p : planten){
            if(p!=null){
                soortNamen.add(p.soortNaam);
            }
        }
    }

    public void zaai(Zaaibaar z, int aantalTeZaaien) throws Exception{
        if(z==null) {
            throw new NullPointerException("Zaaien mislukt. Object zaad is leeg");
        }


        if(z.getAantal()==aantalTeZaaien) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            JOptionPane.showConfirmDialog(null, "Weet u zeker dat u alle beschikbare zaden wilt zaaien?", "Waarschuwing", dialogButton);
            if(dialogButton == JOptionPane.NO_OPTION) {
                throw new Exception("Gekozen optie: Niet alle zaden zaaien");
            }
        }
        z.checkZaadVoorraad(aantalTeZaaien);

        //als er minder zijn dan vereist: zaaien plus regel hieboven en kans op uitkomen zakt met 50%


        if(!(z instanceof Zaaibaar)) {
            throw new IllegalArgumentException("te zaaien zaad is niet zaaibaar");
        }
        if(z instanceof Tomaat) {
            Tomatenplant y = new Tomatenplant(z.getNaam(), z.getRijAfstand(), z.getPlantAfstand(), z.getHoogte(), z.isZiekteresistent(), z.isHybride(),
                    z.getOpbrengst(), z.getKleur(), z.getVorm(),((Tomaat) z).isKlimmend(), ((Tomaat) z).getBinnenkleur());
            y.
            this.planten.add(
            z.pasAantalZadenAan(2, false);
        }
        if(z instanceof StandaardPeper) {
            this.planten.add( new StandaardPeperplant(z.getNaam(), z.getRijAfstand(), z.getPlantAfstand(), z.getHoogte(), z.isZiekteresistent(), z.isHybride(),
                    z.getOpbrengst(), z.getKleur(), z.getVorm(), ((StandaardPeper) z).getPikantheid()));
            z.pasAantalZadenAan(2, false);
        }
        if(z instanceof RocotoPeper) {
            this.planten.add( new StandaardPeperplant(z.getNaam(), z.getRijAfstand(), z.getPlantAfstand(), z.getHoogte(), z.isZiekteresistent(), z.isHybride(),
                    z.getOpbrengst(), z.getKleur(), z.getVorm(), ((RocotoPeper) z).getPikantheid()));
            z.pasAantalZadenAan(2, false);
        }
        if(z instanceof Boon) {
            this.planten.add(new Bonenplant(z.getNaam(), z.getSoort(), z.getRijAfstand(), z.getPlantAfstand(), z.getHoogte(), z.isZiekteresistent(), z.isHybride(),
                    z.getOpbrengst(), z.getKleur(), z.getVorm(), ((Boon) z).isKlimmend()));
            z.pasAantalZadenAan(2, false);        }

        if(z instanceof Aubergine) {
            this.planten.add(new Aubergineplant(z.getNaam(), z.getRijAfstand(), z.getPlantAfstand(), z.getHoogte(), z.isZiekteresistent(), z.isHybride(),
                    z.getOpbrengst(), z.getKleur(), z.getVorm()));
            z.pasAantalZadenAan(2, false);
        }

    }

    public void verwijderPlantUitPlantenbak(Plant p) {
        if(p==null) throw new IllegalArgumentException("");
        planten.remove(p);
    }

    public int aantalPlanten() {
        return planten.size();
    }

    public int aantalPlantenVanSoort(String soort) {
        int aantal = 0;
        if(soort.trim().toLowerCase().equals("peper")){
            for(Plant p : planten) {
                if(p.soortNaam) {
                    aantal ++;
                }
            }
        }
        return aantal;
    }

    public ArrayList<Plant> getplantenBak(){
        return planten;
    }

    public Plant get(String naam) {
        Plant plant = null;
        if(naam.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Plant oproepen mislukt", "Error", JOptionPane.CANCEL_OPTION);
        }
        for(Plant p : planten) {
            if(p.getNaam().trim().toLowerCase().equals(naam.trim().toLowerCase())) {
                plant = p;
            }
        }
        return plant;
    }

    public String printPlantenbak() {
        String uit = "Plantenbak: " + "\n--------------------------------------------------------------------------------"
                + "\n" + "Plantenbak bevat " + this.aantalPlanten() + " planten"+
                "\n--------------------------------------------------------------------------------\n";

        for(Plant p: planten) {
            uit += p.toString()+"--------------------\n\n";
        }
        uit+="--------------------------------------------------------------------------------\n";;
        return uit;
    }

    public ArrayList<Plant> getPlanten(){
        return planten;
    }

//	||
//	soort.trim().toLowerCase().equals("komkommer")||
//	soort.trim().toLowerCase().equals("aubergine")||
//	soort.trim().toLowerCase().equals("boon")||
//	soort.trim().toLowerCase().equals("peper")

}
