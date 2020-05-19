package domain;

import db.Database;
import domain.plaatsbaar.Spullenbak;
import domain.plaatsbaar.Tuingereedschap;
import domain.planten.Plant;
import domain.zaaibaar.*;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Domein {
    private int aantal;
    public Database db = new Database();
    private ArrayList<Moestuin> tuintjes = new ArrayList<>();
    public Zadenbak zadenbak = new Zadenbak();
    public Plantenbak plantenbak = new Plantenbak();
    public Spullenbak spullenbak = new Spullenbak();
    YieldEngine yield = new YieldEngine(this);

    public Domein() {
        maakFileTuinAan();

    }

    public boolean zaai(Zaaibaar zaad, int aantal){
        boolean result = false;
        for(Zaaibaar z : zadenbak.getZaden()){
            if(z.equals(zaad)){
                if(z.getAantalZaden()>aantal){
                    try {
                        plantenbak.zaai(zaad, aantal);
                        result = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    public String vraagWaarde(String vraag) {
        String s = "";
        while(s.isEmpty()) {
            s = JOptionPane.showInputDialog(vraag);
        }
        return s.trim().toLowerCase();
    }

    private void maakFileTuinAan() {
        File tuinen = new File("Tuinen");
        tuinen.mkdir();
    }

    private void setAantalTuintjes() {
        this.aantal = tuintjes.size();
    }

    public void voegAanTuinenToe(Moestuin m) {
        tuintjes.add(m);
        this.setAantalTuintjes();
    }

    public int getDomeinBreedte() {
        int breedte = 0;
        for(Moestuin m : this.getMoestuinen()) {
            breedte+=m.getBreedte();
        }
        return breedte;
    }

    public int getDomeinLengte() {
        int lengte = 0;
        for(Moestuin m : this.getMoestuinen()) {
            lengte+=m.getLengte();
        }
        return lengte;
    }

    public int getOppervlakteDomein() {
        int o =this.getDomeinLengte()*this.getDomeinBreedte();
        return o;

    }

    public int getAantalPlanten() {
        //nog te implementeren!!
        return aantal;
    }

    public ArrayList<Moestuin> getMoestuinen(){
        return tuintjes;
    }

    public Plantenbak getPlantenbak(){
        return plantenbak;
    }

    public Zadenbak getZadenbak(){
        return zadenbak;
    }

    public Spullenbak getSpullenbak(){
        return spullenbak;
    }

    public Object zoekTuinobject(String naam, String type) {
        type = type.trim().toLowerCase();
        Object o = null;

        if(type.equals("zaad")) {
            o=zadenbak.get(naam);
        }

        if(type.equals("plant")) {
            o=plantenbak.get(naam);
            for(Moestuin m : tuintjes) {
                for(Plantenrij p : m.kollomen) {
                    for(Tuinobject t : p.getPlantenrij()) {
                        if(t.getNaam().toLowerCase().equals(naam.toLowerCase())) {
                            o=t;
                            break;
                        }
                    }
                }

            }


        }
        if(type.equals("gereedschap")||type.equals("spullen"))
            for(Tuinobject p: spullenbak.getSpullen()) {
                if(p.getNaam().toLowerCase().equals(naam.toLowerCase())) {
                    o=p;
                    break;
                }
            }
        if(o==null) throw new IllegalArgumentException("gevraagd object niet gevonden");
        return o;

    }

    public void geefDomeinPlan() {
        for(Moestuin m : tuintjes) {
            m.geefInfo();
        }
    }

    /*public void voegZaadToe() {

        String zaad = (String) JOptionPane.showInputDialog(null, "Kies het type zaad",null
                , JOptionPane.QUESTION_MESSAGE, null, new String[] { "tomaat",
                        "peper", "aubergine", "boon", "komkommer/meloen"}, "tomaat");

        if(zaad.equals("tomaat")) {
            zadenbak.voegZaadToe(new Tomaat(JOptionPane.showInputDialog("Naam:\nBijvoorbeeld: 'gardenberry'"),
                    JOptionPane.showInputDialog("Soort:\nBijvoorbeeld: 'kerstomaat'"),
                    Integer.parseInt(JOptionPane.showInputDialog("Vervaljaar van het zaad:\nBijvoorbeeld: '2019'")),
                    Integer.parseInt(JOptionPane.showInputDialog("Aantal zaden:\nBijvoorbeeld: '86'")),
                    Double.parseDouble(JOptionPane.showInputDialog("Welke hoogte hebben de volgroeide planten?\n(uitgedrukt in meter)")),
                    Boolean.parseBoolean(JOptionPane.showInputDialog("Zijn de planten hiervan ziekteresistent?\n(ja='true'/nee='false')")),
                    Boolean.parseBoolean(JOptionPane.showInputDialog("Zijn de planten hiervan hybrides?:\nTe herkennen aan 'F1'\n(ja='true'/nee='false')")),
                    Integer.parseInt(JOptionPane.showInputDialog("Geef voor de plant van dit zaad een opbrengst van 1 tot 9")),
                    JOptionPane.showInputDialog("Welke kleur hebben de rijpe vruchten hiervan?"),
                    JOptionPane.showInputDialog("Welke kleur hebben de rijpe vruchten hiervan aan de binnenkant?"),
                    JOptionPane.showInputDialog("Welke vorm hebben de rijpe vruchten hiervan?"),
                    Boolean.parseBoolean(JOptionPane.showInputDialog("zijn de planten klimmend?\n(ja='true'/nee='false')"))));
        }

        if(zaad.equals("peper")) {
            zadenbak.voegZaadToe(new Peper(JOptionPane.showInputDialog("Naam:\nBijvoorbeeld: 'big sun'"),
                    JOptionPane.showInputDialog("Soort:\nBijvoorbeeld: 'Jalape�o'"),
                    Integer.parseInt(JOptionPane.showInputDialog("Vervaljaar van het zaad:\nBijvoorbeeld: '2019'")),
                    Integer.parseInt(JOptionPane.showInputDialog("Aantal zaden:\nBijvoorbeeld: '86'")),
                    Double.parseDouble(JOptionPane.showInputDialog("Welke hoogte hebben de volgroeide planten?\n(uitgedrukt in meter)")),
                    Boolean.parseBoolean(JOptionPane.showInputDialog("Zijn de planten hiervan ziekteresistent?\n(ja='true'/nee='false')")),
                    Boolean.parseBoolean(JOptionPane.showInputDialog("Zijn de planten hiervan hybrides?:\nTe herkennen aan 'F1'\n(ja='true'/nee='false')")),
                    Integer.parseInt(JOptionPane.showInputDialog("Geef voor de plant van dit zaad een opbrengst van 1 tot 9")),
                    JOptionPane.showInputDialog("Welke kleur hebben de rijpe vruchten?"),
                    JOptionPane.showInputDialog("Welke vorm hebben de rijpe vruchten?"),
                    Integer.parseInt(JOptionPane.showInputDialog("Scoville waarde (pikantheid):\nBijvoorbeeld: '200000'"))));
        }

        if(zaad.equals("aubergine")) {
            zadenbak.voegZaadToe(new Aubergine(JOptionPane.showInputDialog("Naam:\nBijvoorbeeld: 'striped toga'"),
                    JOptionPane.showInputDialog("Soort:\nBijvoorbeeld: 'mini'"),
                    Integer.parseInt(JOptionPane.showInputDialog("Vervaljaar van het zaad:\nBijvoorbeeld: '2019'")),
                    Integer.parseInt(JOptionPane.showInputDialog("Aantal zaden:\nBijvoorbeeld: '86'")),
                    Double.parseDouble(JOptionPane.showInputDialog("Welke hoogte hebben de volgroeide planten?\n(uitgedrukt in meter)")),
                    Boolean.parseBoolean(JOptionPane.showInputDialog("Zijn de planten hiervan ziekteresistent?\n(ja='true'/nee='false')")),
                    Boolean.parseBoolean(JOptionPane.showInputDialog("Zijn de planten hiervan hybrides?:\nTe herkennen aan 'F1'\n(ja='true'/nee='false')")),
                    Integer.parseInt(JOptionPane.showInputDialog("Geef voor de plant van dit zaad een opbrengst van 1 tot 9")),
                    JOptionPane.showInputDialog("Welke kleur hebben de rijpe vruchten?"),
                    JOptionPane.showInputDialog("Welke vorm hebben de rijpe vruchten?")));
        }

        if(zaad.equals("boon")) {
            zadenbak.voegZaadToe(new Boon(JOptionPane.showInputDialog("Naam:\nBijvoorbeeld: 'boerenteen'"),
                    JOptionPane.showInputDialog("Soort:\nBijvoorbeeld: 'pronkboon'"),
                    Boolean.parseBoolean(JOptionPane.showInputDialog("Moeten volgende planten groeien in warm klimaat?\n(ja='true'/nee='false')")),
                    Integer.parseInt(JOptionPane.showInputDialog("Vervaljaar van het zaad:\nBijvoorbeeld: '2019'")),
                    Integer.parseInt(JOptionPane.showInputDialog("Aantal zaden:\nBijvoorbeeld: '86'")),
                    Double.parseDouble(JOptionPane.showInputDialog("Welke hoogte hebben de volgroeide planten?\n(uitgedrukt in meter)")),
                    Boolean.parseBoolean(JOptionPane.showInputDialog("Zijn de planten hiervan ziekteresistent?\n(ja='true'/nee='false')")),
                    Boolean.parseBoolean(JOptionPane.showInputDialog("Zijn de planten hiervan hybrides?:\nTe herkennen aan 'F1'\n(ja='true'/nee='false')")),
                    Integer.parseInt(JOptionPane.showInputDialog("Geef voor de plant van dit zaad een opbrengst van 1 tot 9")),
                    JOptionPane.showInputDialog("Welke kleur hebben de rijpe vruchten?"),
                    JOptionPane.showInputDialog("Welke kleur hebben de rijpe vruchten aan de binnenkant?"),
                    Boolean.parseBoolean(JOptionPane.showInputDialog("zijn de planten klimmend?\n(ja='true'/nee='false')"))));
        }
    }*/

    /*public void voegTuinObjectToeAanMoestuin(String naamtuin, String naam, int rijnummer, int hoogte) {
        naamtuin=naamtuin.trim().toLowerCase();
        naam=naam.trim().toLowerCase();
        int indexM=0;
        Moestuin mTuin=null;
        Tuinobject tuinO = null;
        for(Moestuin m: tuintjes) {
            if(m.getNaam().trim().toLowerCase().equals(naamtuin)) {
                indexM=tuintjes.indexOf(m);
                mTuin=m;

            }

            for(Plantenrij p: m.getKollomen()) {
                for(Tuinobject t: p.getPlantenrij()) {
                    if(m.getNaam().trim().toLowerCase().equals(naam)) {
                        tuinO=t;

                    }
                }
            }

        }

        for(Plant p: plantenbak.getPlanten()) {
            if(p.getNaam().trim().toLowerCase().equals(naam)) {
                tuinO=p;
                break;
            }
        }

        for(Tuinobject tu: spullenbak.getSpullen()) {
            if(tu.getNaam().trim().toLowerCase().equals(naam)) {
                tuinO=tu;
                break;
            }
        }

        if(tuinO==null) {
            throw new NullPointerException("Tuinobject niet gevonden, toevoegen mislukt!");
        }else {
            tuintjes.get(indexM).voegTuinObjectToe(tuinO, rijnummer, hoogte);
            //db.schrijfData(tuinO.getNaam(), mTuin.getNaam(), tuinO.allDataInString());
            if(tuinO instanceof Plant) {
                Plant p = (Plant)tuinO;
                plantenbak.verwijderPlantUitPlantenbak(p);
            }
            if(tuinO instanceof Tuingereedschap) {
                Tuingereedschap p = (Tuingereedschap)tuinO;
                spullenbak.verwijderPlantUitPlantenbak(p);
            }


        }
    }*/

   /* public boolean pasZaaiMaandAan(Object o){
        if(!o instanceof zaaibaar){
            return false;
        }else{
        }
    }*/



}
