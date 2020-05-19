package domain.planten;

import domain.Plantaardig;
import domain.Tuinobject;
import domain.Zaaikalender;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Plant extends Plantaardig {
    public static String soortNaam;
    private Zaaikalender zkalender;
    private String naam, kleur, vorm;

    protected double rijafstand, plantafstand;
    private double hoogte;
    private boolean ziekteresistent, hybride;
    private int opbrengst;

    public Plant(String naam, String soort, boolean inserre,  boolean ziekteresistent,
                 boolean hybride, String kleur, String vorm) {
        super(naam,soort,inserre,ziekteresistent,hybride,kleur,vorm);

        try {
            setHoogte(hoogte);
        }catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"Hoogte is nu: " + this.getHoogte() + " m");
        }
        setHybride(hybride);
        setNaam(naam);
        setOpbrengst(opbrengst);
        try {
            setRijAfstand(rijafstand);
        }catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"rijafstand is nu: " + this.getOppervlakte() + " m" );
        }
        setZiekteresistent(ziekteresistent);
        setKleur(kleur);
        setVorm(vorm);
        setPlantafstand(plantafstand);
        this.isPlant();
    }

    public Plant(String naam, String soort, boolean inserre, boolean ziekteresistent, boolean hybride, String vorm) {
        this(naam, soort, inserre,  ziekteresistent, hybride, "groen", vorm);
    }

    private void setKleur(String kleur) {
        this.kleur = kleur.trim();
    }

    private void setVorm(String vorm) {
        this.vorm = vorm.trim();
    }

    private void setNaam(String naam) {
        if(naam.trim().equals("")) throw new IllegalArgumentException("Naam is leeg");
        this.naam = naam.trim();
    }

    protected void setRijAfstand(double rijafstand) {
        if(rijafstand<0) throw new IllegalArgumentException("rijafstand is ongeldig");
        this.rijafstand =rijafstand;
    }

    public void setPlantafstand(double plantafstand) {
        this.plantafstand = plantafstand;
    }

    private void setHoogte(double hoogte) {
        this.hoogte = hoogte;
    }

    private void setZiekteresistent(boolean ziekteresistent) {
        this.ziekteresistent = ziekteresistent;
    }

    private void setHybride(boolean hybride) {
        this.hybride = hybride;
    }

    private void setOpbrengst(int opbrengst) {
        this.opbrengst = opbrengst;
    }


    public void pasOpbrengstAan(int opb) {
        try {
            if(opb>0&&opb<11) {
                this.opbrengst= opb;
            }else {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "Opbrengst is niet aangepast vanwege een foutief opgegeven waarde");
        }
    }

    public double getRijAfstand() {
        return this.rijafstand;
    }

    public double getPlantafstand() {
        return plantafstand;
    }

    public double getHoogte() {
        return this.hoogte;
    }

    public boolean isZiekteresistent() {
        return this.ziekteresistent;
    }

    public boolean isHybride() {
        return this.hybride;
    }

    public int getOpbrengst() {
        return this.opbrengst;
    }

    public String getKleur() {
        return this.kleur;
    }

    public String getVorm() {
        return this.vorm;
    }

    public void veranderZaaiperiode(String eersteM, String uitersteM) {
        zkalender.setZaaiMarge(eersteM,uitersteM);
    }

    public void veranderVerplantperiode(String eersteM, String uitersteM) {
        zkalender.setVerplantMarge(eersteM,uitersteM);
    }

    public void veranderOogstperiode(String eersteM, String uitersteM) {
        zkalender.setOogstMarge(eersteM,uitersteM);
    }

    public Zaaikalender getZaaikalender(){
        return zkalender;
    }


    @Override
    public String allDataInString() {
        return this.getNaam()+" / "+this.getRijAfstand()+ this.getHoogte()+" / "+
                this.isZiekteresistent()+" / "+
                this.isHybride()+" / "+
                this.getOpbrengst()+" / "+
                this.getKleur()+" / "+
                this.getVorm()+" / ";
    }

    @Override
    public double getOppervlakte() {
        return rijafstand;
    }

    @Override
    public String getNaam() {
        return naam;
    }

    @Override
    public String toString() {
        String info = "";
        info += this.getNaam()+ ": " +'\n'+
                "Oppervlakte: "+this.getOppervlakte()+" m�\n"+
                "Opbrengst: " + this.getOpbrengst()+'\n';
        String ziekte = "";
        if(this.isZiekteresistent()) {
            ziekte= "Ja";
        }
        else {
            ziekte = "Nee";
        }
        info+="Ziekteresistentie: " + ziekte+'\n';
        String hybr = "";
        if(this.isHybride()) {
            hybr= "Ja";
        }
        else {
            hybr = "Nee";
        }
        info+="Hybrideras: " + hybr+ '\n'+
                "Kleur: " + this.getKleur()+'\n'+
                "Vorm: " + this.getVorm()+'\n';
        return info;
    }
}
