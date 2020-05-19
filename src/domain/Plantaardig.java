package domain;

import domain.soort.Cucumis;
import domain.zaaibaar.Aubergine;
import domain.zaaibaar.Peper;
import domain.zaaibaar.Tomaat;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Plantaardig extends Tuinobject {


    protected GroeiMonitor groeiMonitor;
    protected Zaaimonitor zaaiMonitor;
    protected PlantAfstanden afstanden;
    public static boolean bestePlaatsIsSerre;
    private String naam, soort, vorm, kleur;
    protected String alert;
    private boolean ziekteresistent, hybride, inSerre, meerderjarig;
    protected boolean isPlant;

    public Plantaardig(String naam, String soort, boolean inserre,
                    boolean ziekteresistent, boolean hybride, String kleur, String vorm) {
        super(naam);
        setNaam(naam);
        setSoort(soort);
        setInSerre(inserre);
        setZiekteresistent(ziekteresistent);
        setHybride(hybride);
        setKleur(kleur);
        setVorm(vorm);
        groeiMonitor = new GroeiMonitor(this);
        isPlant = false;
        afstanden = new PlantAfstanden();

    }



    public void setAlert(String tekst){
        this.alert = tekst;
    }

    protected void isPlant(){
        this.isPlant = true;
    }

    protected void setMeerderjarigheid(boolean meerderjarig){
        this.meerderjarig = meerderjarig;
    }


    public void veranderZaaiperiode(String eersteM, String uitersteM) {
        groeiMonitor.veranderZaaiperiode(eersteM,uitersteM);
    }

    public void veranderVerplantperiode(String eersteM, String uitersteM) {
        groeiMonitor.veranderVerplantperiode(eersteM,uitersteM);
    }

    public void veranderOogstperiode(String eersteM, String uitersteM) {
        groeiMonitor.veranderOogstperiode(eersteM,uitersteM);
    }

    private void setNaam(String naam) {
        this.naam = naam.trim();
    }

    private void setSoort(String soort) {
        this.soort = soort.trim();
    }

    public void veranderPlantAfstand(double plantafstand) {
        this.afstanden.setPlantAfstand(plantafstand);
    }

    public void veranderRijAfstand(double rijAfstand) {

        this.afstanden.setRijAfstand(rijAfstand);
    }

    public void veranderHoogte(double hoogte) {

        this.afstanden.setHoogte(hoogte);
    }

    private void setInSerre(boolean inSerre) {
        this.inSerre = inSerre;
    }

    private void setZiekteresistent(boolean ziekteresistent) {
        this.ziekteresistent = ziekteresistent;
    }

    private void setHybride(boolean hybride) {
        this.hybride = hybride;
    }

    private void setKleur(String kleur) {
        this.kleur = kleur.trim();
    }

    private void setVorm(String vorm) {
        this.vorm = vorm.trim();
    }

    public String getSoort() {
        return soort;
    }

    public String getNaam() {
        return naam;
    }

    public double getRijAfstand() {
        return this.afstanden.getRijAfstand();
    }

    public double getPlantAfstand() {
        return this.afstanden.getPlantAfstand();
    }

    public boolean getInSerre() {
        return inSerre;
    }

    public double getHoogte() {
        return this.afstanden.getHoogte();
    }

    public boolean isZiekteresistent() {
        return ziekteresistent;
    }

    public boolean isHybride() {
        return hybride;
    }

    public String getKleur() {
        return kleur;
    }

    public String getVorm() {
        return vorm;
    }

    public ArrayList<String> getZaaimaanden() {
        ArrayList<String> uit = groeiMonitor.getZaaimaanden();
        return uit;
    }

    public ArrayList<String> getVerplantmaanden() {
        ArrayList<String> uit = groeiMonitor.getVerplantmaanden();
        return uit;
    }

    public ArrayList<String> getOogstmaanden() {
        ArrayList<String> uit = groeiMonitor.getOogstmaanden();
        return uit;
    }

    public static boolean isBestePlaatsIsSerre() {
        return bestePlaatsIsSerre;
    }

    public Zaaikalender getZaaiKalender(){
        return groeiMonitor.getZaaiKalender();
    }

    public String allDataInString() {
        return this.getNaam()+" / "+ this.getSoort()+" / "+
                this.groeiMonitor.getOpbrengst()+" / "+this.getVorm()+" / "+
                this.getKleur()+" / ";
    }

    @Override
    public String toString() {
        String uit =naam+'\n'+
                "Soort: "+ this.getSoort()+'\n'+
                "Hoogte: "+this.getHoogte()+'\n';
        String ziekte = "";
        if(this.isZiekteresistent()) {
            ziekte= "Ja";
        }
        else {
            ziekte = "Nee";
        }
        uit+="Ziekteresistentie: " + ziekte+'\n';
        String hybr = "";
        if(this.isHybride()) {
            hybr= "Ja";
        }
        else {
            hybr = "Nee";
        }
        uit+="Hybrideras: " + hybr+ '\n';
        if(this.getInSerre()) {
            uit+= "kweek: in serre"+'\n';
        }else {
            uit+= "kweek: buiten, eventueel binnen"+'\n';
        }
        uit +="Opbrengst: "+ this.groeiMonitor.getOpbrengst()+"/9"+'\n'+
                "Vorm: "+this.getVorm()+'\n'+
                "Kleur: "+this.getKleur()+'\n';
        return uit;


    }
}

