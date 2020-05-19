package domain.zaaibaar;

public class Aardappel extends Groenten{

    public Aardappel(String naam, String soort, int vervaljaar, int aantal, boolean ziekteresistent, boolean hybride, int opbrengst, String kleur, String vorm) {
        super(naam, soort, false, vervaljaar, aantal, ziekteresistent, hybride, opbrengst, kleur, vorm);
        bestePlaatsIsSerre = false;
        soortNaam ="aardappel";
        this.veranderPlantAfstand(0.4);
        this.veranderRijAfstand(0.6);
        this.afstanden.setHoogte(0.5);
    }
}
