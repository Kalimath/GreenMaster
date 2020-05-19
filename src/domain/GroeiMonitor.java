package domain;

import domain.zaaibaar.Zaaibaar;

import java.util.ArrayList;

public class GroeiMonitor{
    private ArrayList<String> goedeBuren;
    protected Zaaikalender zkalender;
    protected double[] nkp;
    private Plantaardig z;
    private int zaaiTotOogst,aantalUrenZonPerDag,opbrengst;
    private int kouBestendig;

    public GroeiMonitor(Plantaardig z){
        zkalender = new Zaaikalender(z);
        goedeBuren = new ArrayList<>();
        setZ(z);
    }

    public void setGoedeBuren(ArrayList<String> buren){
        if(buren==null){
            throw new NullPointerException("Lijst met goede buren mag niet leeg zijn");
        }else {
            for (String s : buren) {
                if (!s.trim().isEmpty()){
                    this.goedeBuren.add(s);
                }
            }
        }
    }

    public void setKouBestendig(int kouBestendig) {
        if(kouBestendig <0|| kouBestendig >3){
            throw new IllegalArgumentException("koubestendigheid gaat van 0 tot 3");
        }else {
            this.kouBestendig = kouBestendig;
        }
    }

    public void setNpk(double n, double p, double k) {
        this.nkp = nkp;
    }

    public void setOpbrengst(Plantaardig z) {
        int waarde = 1;
        if(z.isZiekteresistent()){
            waarde+=3;
        }
        if(z.isHybride()){
            waarde+=3;
        }
        if(kouBestendig>1){
            waarde+=1;
        }
        this.opbrengst = waarde;
    }

    private void setZ(Plantaardig z) {
        this.z = z;

    }

    public void setZaaiTotOogst(boolean exact, int waarde){
        if(exact){
            double hoogte = z.getHoogte();
            double lengte = hoogte*10;
            if(waarde>=lengte){
                this.zaaiTotOogst = waarde;
            }else if(z.getHoogte()<50){
                    this.zaaiTotOogst = waarde;
                }else {
                throw new IllegalArgumentException("opgegeven zaai tot oogst duur is te kort");
            }
        }else {
            String van = zkalender.getZaaimaanden().get(0);
            String tot = zkalender.getOogstmaanden().get(0);
            ArrayList<String> maanden = zkalender.maandenAanvullen(van, tot);
            this.setZaaiTotOogst(maanden.size() * 30);
        }
    }

    private void setZaaiTotOogst(int zaaiTotOogst) {
        this.zaaiTotOogst = zaaiTotOogst;
    }

    public int getZaaiTotOogst() {
        return zaaiTotOogst;
    }

    public int getOpbrengst() {
        return opbrengst;
    }

    public ArrayList<String> getZaaimaanden() {
        return zkalender.getZaaimaanden();
    }

    public ArrayList<String> getVerplantmaanden() {
        return zkalender.getVerplantmaanden();
    }

    public ArrayList<String> getOogstmaanden() {
        return zkalender.getOogstmaanden();
    }

    public void setAantalUrenZonPerDag(int aantalUrenZonPerDag) {
        this.aantalUrenZonPerDag = aantalUrenZonPerDag;
    }

    public int getAantalUrenZonPerDag() {
        return aantalUrenZonPerDag;
    }

    public void veranderZaaiperiode(String eersteM, String uitersteM) {
        zkalender.setZaaiMarge(eersteM,uitersteM);
    }

    public void veranderVerplantperiode(String eersteM, String uitersteM) {
        zkalender.setVerplantMarge(eersteM,uitersteM);
    }

    public void veranderOogstperiode(String eersteM, String uitersteM) {
        zkalender.setOogstMarge(eersteM, uitersteM);

    }

    public double[] getNkp() {
        return nkp;
    }

    public ArrayList<String> getGoedeBuren(){
        return goedeBuren;
    }

    public Zaaikalender getZaaiKalender(){
        return this.zkalender;
    }

}
