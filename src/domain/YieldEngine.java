package domain;

import java.util.ArrayList;

public class YieldEngine {
    private short opbrengstPercent;
    private String[] maanden;
    private Domein domein;

    public YieldEngine(Domein d) {
        this.maanden = new String[12];
        stelMaandenOp();
        refreshData(d);
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

    public void refreshData(Domein d) {
        this.domein = d;
    }

    public void setZaaiMarge(Object o, String van, String tot){
        van = van.trim().toLowerCase();
        tot = tot.trim().toLowerCase();
        ArrayList<String> zaaimaanden = new ArrayList<>();
        int vanI = 0;
        int totI= 0;
        if(o instanceof Plant||o instanceof Zaad) {
            for (int i=0; i < maanden.length; i++) {
                if(maanden[i].equals(van)) {
                    vanI=i;
                }
            }
            for (int i=0; i < maanden.length; i++) {
                if(maanden[i].equals(tot)) {
                    totI=i;
                }
            }
            if(o instanceof Plant) {
                Plant plant = (Plant)o;
                for (int i=vanI; i <= totI; i++) {
                    zaaimaanden.add(maanden[i]);
                }
                plant.setZaaimaanden(zaaimaanden);
            }
            if(o instanceof Zaad) {
                Zaad zaad = (Zaad)o;
                for (int i=vanI; i <= totI; i++) {
                    zaaimaanden.add(maanden[i]);
                }
                zaad.setZaaimaanden(zaaimaanden);
            }
            refreshData(domein);
        }else {
            throw new IllegalArgumentException("zaaimarge opstellen mislukt, type object is foutief");
        }

    }

    public void setVerplantMarge(Object o, String van, String tot){
        van = van.trim().toLowerCase();
        tot = tot.trim().toLowerCase();
        ArrayList<String> verplantmaanden = new ArrayList<>();
        int vanI = 0;
        int totI= 0;
        if(o instanceof Plant||o instanceof Zaad) {
            for (int i=0; i < maanden.length; i++) {
                if(maanden[i].equals(van)) {
                    vanI=i;
                }
            }
            for (int i=0; i < maanden.length; i++) {
                if(maanden[i].equals(tot)) {
                    totI=i;
                }
            }
            if(o instanceof Plant) {
                Plant plant = (Plant)o;
                for (int i=vanI; i <= totI; i++) {
                    verplantmaanden.add(maanden[i]);
                }
                plant.setVerplantmaanden(verplantmaanden);
            }
            if(o instanceof Zaad) {
                Zaad zaad = (Zaad)o;
                for (int i=vanI; i <= totI; i++) {
                    verplantmaanden.add(maanden[i]);
                }
                zaad.setVerplantmaanden(verplantmaanden);
            }
            refreshData(domein);
        }else {
            throw new IllegalArgumentException("verplantmarge opstellen mislukt, type object is foutief");
        }
    }

    public void setOogstMarge(Object o, String van, String tot){
        van = van.trim().toLowerCase();
        tot = tot.trim().toLowerCase();
        ArrayList<String> oogstmaanden = new ArrayList<>();
        int vanI = 0;
        int totI= 0;
        if(o instanceof Plant||o instanceof Zaad) {
            for (int i=0; i < maanden.length; i++) {
                if(maanden[i].equals(van)) {
                    vanI=i;
                }
            }
            for (int i=0; i < maanden.length; i++) {
                if(maanden[i].equals(tot)) {
                    totI=i;
                }
            }
            if(o instanceof Plant) {
                Plant plant = (Plant)o;
                for (int i=vanI; i <= totI; i++) {
                    oogstmaanden.add(maanden[i]);
                }
                plant.setVerplantmaanden(oogstmaanden);
            }
            if(o instanceof Zaad) {
                Zaad zaad = (Zaad)o;
                for (int i=vanI; i <= totI; i++) {
                    oogstmaanden.add(maanden[i]);
                }
                zaad.setVerplantmaanden(oogstmaanden);
            }
            refreshData(domein);
        }else {
            throw new IllegalArgumentException("oogstmarge opstellen mislukt, type object is foutief");
        }
    }

    public void margeCalculator() {

        for(Zaad z: domein.getZadenbak().getZaden()) {


        }

        for(Moestuin m : domein.getMoestuinen()) {
            for(Plantenrij p : m.kollomen) {
                for(Object t : p.getPlantenrij()) {
                    if( t instanceof Plant) {
                        setZaaiMarge(t, ((Plant) t).getEzmaand(), ((Plant) t).getTzmaand());
                        setVerplantMarge(t, ((Plant) t).getEvmaand(), ((Plant) t).getTvmaand());
                        setOogstMarge(t, ((Plant) t).getEomaand(), ((Plant) t).getTomaand());
                    }
                    if(t instanceof Zaad) {
                        setZaaiMarge(t, ((Zaad) t).getEzmaand(), ((Zaad) t).getTzmaand());
                        setVerplantMarge(t, ((Zaad) t).getEvmaand(), ((Zaad) t).getTvmaand());
                        setOogstMarge(t, ((Zaad) t).getEomaand(), ((Zaad) t).getTomaand());
                    }
                }
            }
        }

        for(Plant p: domein.getPlantenbak().getPlanten()) {
            setZaaiMarge(p, ((Plant) p).getEzmaand(), ((Plant) p).getTzmaand());
            setVerplantMarge(p, ((Plant) p).getEvmaand(), ((Plant) p).getTvmaand());
            setOogstMarge(p, ((Plant) p).getEomaand(), ((Plant) p).getTomaand());
        }

        for(Zaad z: domein.getZadenbak().getZaden()) {
            setZaaiMarge(z, ((Zaad) z).getEzmaand(), ((Zaad) z).getTzmaand());
            setVerplantMarge(z, ((Zaad) z).getEvmaand(), ((Zaad) z).getTvmaand());
            setOogstMarge(z, ((Zaad) z).getEomaand(), ((Zaad) z).getTomaand());
        }



    }








}
