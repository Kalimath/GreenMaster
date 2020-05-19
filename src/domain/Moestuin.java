package domain;

import domain.debug.DomainException;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Moestuin extends ItemHouder{
    ArrayList<Plantenrij> kollomen;
    private HashMap<Punt, Tuinobject> moestuin;
    private String naam;
    private int breedte;
    private int lengte;
    private int oppervlakte;

    public Moestuin(String naam, int lengte, int breedte){
        moestuin = new HashMap<Punt, Tuinobject>();
        setNaam(naam);
        kollomen = new ArrayList<>();
        this.valideerMeetwaarde(breedte);
        this.valideerMeetwaarde(lengte);
        setPositie(breedte);
        setRijnummer(lengte);
        setMoestuin(lengte, breedte);
        setOppervlakte(lengte, breedte);
    }

    private void setNaam(String naam) {
        if(naam.equals(null)||naam.trim().equals("")) throw new IllegalArgumentException("Naam van moestuin mag niet leeg zijn");
        this.naam = naam.trim();
    }


    private void setMoestuin(int rijnummer, int posities){

        for (int i = kollomen.size(); i < rijnummer; i++) {
            this.kollomen.add(new Plantenrij(posities));
        }
    }

    public void setOppervlakte(int lengte, int breedte){
        this.oppervlakte = lengte*breedte;

    }

    private void setPositie(int positie){
        this.valideerMeetwaarde(positie);
        this.breedte= positie;
    }

    public void setRijnummer(int rijnummer){
        this.valideerMeetwaarde(rijnummer);
        this.lengte = rijnummer;
    }

/*public void voegTuinObjectToe(Tuinobject object, Punt punt) {
	if(object==null||punt == null) {
		throw new IllegalArgumentException("Tuinobject en punt mogen niet leeg zijn.");
	}else {
		moestuin.put(punt, object);
	}
}*/

    public void voegTuinObjectToe(Tuinobject object, int rijnummer, int grootte){
        this.valideerMeetwaarde(rijnummer);
        this.valideerMeetwaarde(grootte);
        kollomen.get(rijnummer-1).voegObjectToeInRij(object, grootte);
    }

    public void force(Tuinobject object, int rijnummer, int grootte){
        this.valideerMeetwaarde(rijnummer);
        this.valideerMeetwaarde(grootte);
        //nieuwe array maken met lengte (initiele+1)
        kollomen.get(rijnummer - 1).voegObjectToeInRij(object, grootte);
    }

    public void valideerMeetwaarde(int meetwaarde) throws IllegalArgumentException {
        if (meetwaarde < 1) {
            meetwaarde = 1;
            throw new IllegalArgumentException("Meetwaarde incorrect");
        }
    }



    public String getNaam() {
        return naam;
    }

    public int getAantalRijen() {
        return kollomen.size();
    }

    public ArrayList<Plantenrij> getKollomen() {
        return kollomen;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getLengte() {
        return lengte;
    }

    public int getOppervlakte() {
        return oppervlakte;
    }

    @Override
    public String toString() {
        String uit = "Moestuin: " +this.getNaam()+'\n'+"Oppervlakte: "+ this.oppervlakte + " m²\n";
        uit+="--------------------------------------------------------------------------------\n";
        int i= 1;
        while(i<this.getBreedte()) {
            uit += i+'\t';
            i++;
        }
        uit +='\n';
        int teller = 1;
        for (Plantenrij rij : this.kollomen) {
            uit += teller++ + "  " + rij.toString()+'\n'+'\n'+'\n';
        }
        uit += "--------------------------------------------------------------------------------\n";
        return uit;
    }

    public String geefInfo() {
        return this.toString();
    }



    public void voegTuinObjectToe(String showInputDialog, int parseInt, int parseInt2) {
        // TODO Auto-generated method stub

    }}
