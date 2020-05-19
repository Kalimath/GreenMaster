package domain.zaaibaar;

import domain.Zaaikalender;
import domain.soort.SolanumLycopersicum;

public class Tomaat extends Groenten implements SolanumLycopersicum {

    public static boolean bestePlaatsIsSerre;
    private boolean klimmend = true;
    private String binnenkleur;

    public Tomaat(String naam, String soort, int vervaljaar, int aantal
                  ,boolean ziekteresistent, boolean hybride, int opbrengst, String vorm, String kleur, String bkleur, boolean klim) {
        super(naam, soort, true, vervaljaar, aantal,ziekteresistent, hybride, opbrengst, vorm, kleur);
        bestePlaatsIsSerre = true;
        soortNaam ="tomaat";
        setKlimmend(klim);
        setBinnenkleur(bkleur);
        this.afstanden.setRijAfstand(1.5);
        this.afstanden.setPlantAfstand(0.5);
        this.groeiMonitor.veranderZaaiperiode("maart","mei");
        this.groeiMonitor.veranderVerplantperiode("april","juni");
        this.groeiMonitor.veranderOogstperiode("juli","november");



    }


    private void setKlimmend(boolean klimmend) {
        if(!klimmend) {
            this.veranderRijAfstand(0.8);
            this.afstanden.setHoogte(0.5);
        }
        this.klimmend = klimmend;
        this.afstanden.setHoogte(3);
    }

    private void setBinnenkleur(String bkleur) {
        this.binnenkleur = bkleur;
    }

    public boolean isKlimmend() {
        return klimmend;
    }

    public String getBinnenkleur() {
        return binnenkleur;
    }

    @Override
    public String toString() {
        String uit = super.toString();
        String groei = "";
        if(this.isKlimmend()) {
            groei= "klimmed";
        }
        else {
            groei = "Kruipend";
        }
        uit+= "Binnenkleur: "+ this.getBinnenkleur()+'\n'+"Type groei: "+ groei+'\n';
        return uit;
    }

    @Override
    public String allDataInString() {
        String uit = super.allDataInString();
        uit += this.getBinnenkleur()+" / "+this.isKlimmend()+" / ";
        return uit;
    }


}
