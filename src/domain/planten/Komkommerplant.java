package domain.planten;

import domain.soort.Cucumis;

public class Komkommerplant extends Plant {



    public Komkommerplant(String naam, String soort, double hoogte, boolean ziekteresistent, boolean hybride,
                           String vorm, boolean rankend) {
        super(naam, soort, true,ziekteresistent, hybride, vorm);
        soortNaam = "boon";
    }

}