package domain;

import domain.zaaibaar.Zaaibaar;

public class Zaaimonitor {
    private Zaaibaar z;
    private int zadenPerzaai;

    public Zaaimonitor(Zaaibaar z){
        setZ(z);
    }

    public void setZadenPerzaai(int zadenPerzaai) {
        if(zadenPerzaai<=0){
           throw new IllegalArgumentException("Zaden nodig per zaaibeurt moet minstens 1 bedragen");
        }
        this.zadenPerzaai = zadenPerzaai;
    }

    public void setZ(Zaaibaar z) {
        this.z = z;
    }

    public int getZadenPerzaai() {
        return zadenPerzaai;
    }


}
