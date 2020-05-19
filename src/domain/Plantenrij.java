package domain;

import javax.swing.JOptionPane;

import domain.planten.Plant;
import domain.staat.Looppad;
import domain.zaaibaar.Zaaibaar;

public class Plantenrij {
    private Tuinobject[] rij;

    public Plantenrij(int grootte) {
        this.valideerMeetwaarde(grootte);
        setGrootte(grootte);
        this.rij = new Tuinobject[grootte];

    }

    public void valideerMeetwaarde(int breedte) {
        if (breedte < 1) {
            breedte = 1;
            JOptionPane.showMessageDialog(null, "Breedte is kleiner of gelijk aan 0. Breedte is nu 1", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setGrootte(int grootte) {

        if(grootte<=0) {
            JOptionPane.showMessageDialog(null, "Breedte is kleiner of gelijk aan 0. Breedte is nu 1", "Error", JOptionPane.ERROR_MESSAGE);
            setGrootte(1);
        }
    }

    private int aantalPlanten(){
        int aantal = 0;
        for (Tuinobject t : rij) {
            if (t instanceof Zaaibaar) {
                aantal++;
            }
        }
        return aantal;
    }

    private int aantalPaden(){
        int aantal = 0;
        for (Tuinobject t : rij) {
            if (t instanceof Looppad) {
                aantal++;
            }
        }
        return aantal;
    }

    public void pasBreedteAan(int breedte){
        setGrootte(breedte);
    }

    public void voegObjectToeInRij(Tuinobject object, int positie) {
        if (object == null)
            JOptionPane.showMessageDialog(null, "Object is leeg", "Error", JOptionPane.ERROR_MESSAGE);;

        this.valideerMeetwaarde(positie);
        this.rij[positie-1] = object;

    }

    public Tuinobject[] getPlantenrij() {
        return rij;
    }

    @Override
    public String toString(){
        String uit = "";
        for (Tuinobject t : this.rij) {
            if (t==null){
                uit+= "---\t";
            }else{
                uit+= t.getNaam()+"\t";
            }}
        return uit + "\n";
    }
}
