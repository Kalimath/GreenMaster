package domain.plaatsbaar;

import domain.Tuinobject;

import java.util.ArrayList;

public class Spullenbak {
    private ArrayList<Tuinobject> spullen;

    public Spullenbak(){
        spullen = new ArrayList<Tuinobject>();
    }

    public ArrayList<Tuinobject> getSpullen(){
        return spullen;
    }
}
