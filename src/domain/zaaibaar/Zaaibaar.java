package domain.zaaibaar;

import domain.*;
import domain.soort.Cucumis;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Zaaibaar extends Plantaardig {



        private int vervaljaar, aantal;


        public Zaaibaar(String naam, String soort, boolean inserre, int vervaljaar, int aantal,
                         boolean ziekteresistent, boolean hybride, String kleur, String vorm) {
            super(naam, soort, inserre, ziekteresistent,hybride,kleur,vorm);

            setVervaljaar(vervaljaar);
            setAantal(aantal);
        }

        private void setVervaljaar(int vervaldatum) {
            this.vervaljaar = vervaldatum;
        }

        private void setAantal(int aantal) {
            this.aantal = aantal;
        }

        public void pasAantalZadenAan(int aantal, boolean toevoegen){
            if(toevoegen) {
                this.aantal = this.aantal+aantal;
            }else{
                this.aantal = this.aantal-aantal;
            }
        }

        public void checkZaadVoorraad(int aantalTeZaaien) {
            int zaadRestAantal = this.getAantalZaden()-aantalTeZaaien;
            if(aantalTeZaaien<1) {
                throw new IllegalArgumentException("Aantal te zaaien zaden moet minstens 1 bedragen.");
            }
            if(this.getAantalZaden()<=aantalTeZaaien) {
                JOptionPane.showMessageDialog(null, "Aantal zaden van "+this.getNaam()+" bedraagt slechts "+this.getAantalZaden()+" zaden.\n"+
                        "Gelieve de voorraad aan te vullen voor "+this.groeiMonitor.getZaaimaanden().get(0)+'\n'+
                        "www.vreeken.nl");
            }
            if(((this instanceof Tomaat ||this instanceof Peper ||
                    this instanceof Cucumis ||this instanceof Aubergine) && zaadRestAantal<4)||zaadRestAantal<15) {
                JOptionPane.showMessageDialog(null, "Aantal zaden van "+this.getNaam()+" bedraagt slechts "+this.getAantalZaden()+" zaden.\n"+
                        "Gelieve de voorraad aan te vullen voor "+this.groeiMonitor.getZaaimaanden().get(0)+'\n'+
                        "www.vreeken.nl");
            }
        }

        public int getAantalZaden() {
            return aantal;
        }

        public int getVervaljaarZaden() {
            return vervaljaar;
        }

        @Override
        public String allDataInString() {
            return this.getNaam()+" / "+ this.getSoort()+" / "+
                    this.getAantalZaden()+" / "+this.getHoogte()+" / "+
                    this.groeiMonitor.getOpbrengst()+" / "+this.getVorm()+" / "+
                    this.getKleur()+" / ";
        }

        @Override
        public String toString() {
            String uit =this.getNaam()+'\n'+
                    "Soort: "+ this.getSoort()+'\n'+
                    "Aantal zaden beschikbaar: "+ this.getAantalZaden()+'\n'+
                    "Hoogte: "+this.afstanden.getHoogte()+'\n';
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
