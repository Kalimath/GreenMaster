package domain;

import java.util.ArrayList;

public class Bakken {

    private ArrayList<Bak> bakken = new ArrayList<>();
    public Bakken() {

    }

    public ArrayList<Bak> getBakken(){
        return bakken;
    }

    public void voegBakToe( Bak bak) {
        bakken.add(bak);
    }

}
