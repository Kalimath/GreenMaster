package domain.planten;

import domain.Zaaikalender;
import domain.soort.SolanumLycopersicum;
import domain.zaaibaar.Zaaibaar;

public class Tomatenplant extends Plant implements SolanumLycopersicum {
    public static boolean bestePlaatsIsSerre;
    private boolean klimmend = true;
    private String binnenkleur;

    public Tomatenplant(String naam, String soort, int vervaljaar, int aantal, double hoogte,
                  boolean ziekteresistent, boolean hybride, int opbrengst, String vorm, String kleur, String bkleur, boolean klim) {
        super(naam, soort, 0.6, 0.6, true, vervaljaar, aantal, hoogte, ziekteresistent, hybride, opbrengst, vorm, kleur);
        zkalender = new Zaaikalender("tomaat");
        bestePlaatsIsSerre = true;
        setKlimmend(klim);
        setBinnenkleur(bkleur);
        setOppervlakte();
        this.zkalender.setZaaiMarge("maart","mei");
        this.zkalender.setVerplantMarge("april","juni");
        this.zkalender.setOogstMarge("juli","november");


    }


    private void setKlimmend(boolean klimmend) {
        if(!klimmend) {
            this.veranderRijafstand(0.8);
        }
        this.klimmend = klimmend;
        this.setHoogte(0.6);
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
    public void setOppervlakte(){
        if(this.isKlimmend()) {
            this.oppervlakte = 0.36;
        }else {
            this.oppervlakte = 1.0;
        }
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
