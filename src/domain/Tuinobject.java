package domain;

import domain.staat.Looppad;

public class Tuinobject {
    public static String soortNaam;
    private double oppervlakte;

    public Tuinobject(String naam) {
        setOppervlakte();
    }

    public String getNaam() {
        if(this instanceof Looppad)return "Pad";
        return "nodata";

    }

    public void setOppervlakte(){
        this.oppervlakte = 0.5;

    }

    public double getOppervlakte() {
        return oppervlakte;
    }

    public String allDataInString() {
        String uit = "nodata";
        return uit;
    }


}
