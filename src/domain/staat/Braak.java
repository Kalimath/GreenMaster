package domain.staat;

import domain.Tuinobject;

public class Braak extends Tuinobject {

    public Braak(String naam) {
        super(naam);
    }

    @Override
    public String getNaam() {
        return "---";
    }
}