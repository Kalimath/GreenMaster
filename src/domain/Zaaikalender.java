package domain;

import domain.zaaibaar.Zaaibaar;

import java.util.ArrayList;

public class Zaaikalender {

    private String[] maanden = new String[12];
    private ArrayList<String> zaaimaanden = new ArrayList<>();
    private ArrayList<String> verplantmaanden = new ArrayList<>();
    private ArrayList<String> oogstmaanden = new ArrayList<>();
    public Zaaikalender(Plantaardig z){
        stelMaandenOp();
    }
    private void stelMaandenOp() {
        maanden[0] = "januari";
        maanden[1] = "februari";
        maanden[2] = "maart";
        maanden[3] = "april";
        maanden[4] = "mei";
        maanden[5] = "juni";
        maanden[6] = "juli";
        maanden[7] = "augustus";
        maanden[8] = "september";
        maanden[9] = "oktober";
        maanden[10] = "november";
        maanden[11] = "december";
    }

    public ArrayList<String> maandenAanvullen(String van, String tot){
        van = van.trim().toLowerCase();
        tot = tot.trim().toLowerCase();
        ArrayList<String> maanden = new ArrayList<>();
        int vanI = 0;
        int totI= 0;

        for (int i = 0; i < this.maanden.length; i++) {
            if(this.maanden[i].equals(van)) {
                vanI=i;
            }
        }
        for (int i = 0; i < this.maanden.length; i++) {
            if(this.maanden[i].equals(tot)) {
                totI=i;
            }
        }
        for (int i=vanI; i <= totI; i++) {
            maanden.add(this.maanden[i]);
        }
        return maanden;
    }

    public void setZaaiMarge(String van, String tot){
        this.zaaimaanden = maandenAanvullen(van, tot);
    }

    public void setVerplantMarge(String van, String tot){
        this.verplantmaanden = maandenAanvullen(van, tot);

    }

    public void setOogstMarge(String van, String tot){
        this.oogstmaanden = maandenAanvullen(van, tot);
    }


    public ArrayList<String> getZaaimaanden() {
        return zaaimaanden;
    }

    public ArrayList<String> getVerplantmaanden() {
        return verplantmaanden;
    }

    public ArrayList<String> getOogstmaanden() {
        return oogstmaanden;
    }
}
