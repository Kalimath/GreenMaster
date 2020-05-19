package domain.zaaibaar;

import domain.soort.Capsicum;

public class StandaardPeper extends Peper implements Capsicum {
    public StandaardPeper(String naam, String soort, int vervaljaar, int aantal, boolean ziekteresistent, boolean hybride, int opbrengst, String vorm, String kleur, int scoville) {
        super(naam, soort, vervaljaar, aantal,ziekteresistent, hybride, opbrengst, vorm, kleur, scoville);
        bestePlaatsIsSerre = true;
    }
}
