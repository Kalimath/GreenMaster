package domain.zaaibaar;

import domain.soort.Cucumis;


public class Komkommer extends Groenten implements Cucumis {
   public Komkommer(String naam, String soort, boolean inserre, int vervaljaar, int aantal, double hoogte,
                    boolean ziekteresistent, boolean hybride, int opbrengst, String kleur, String vorm) {
       super(naam, soort, inserre, vervaljaar, aantal, ziekteresistent, hybride, opbrengst, kleur, vorm);
        soortNaam = "komkommer";
   }
}
