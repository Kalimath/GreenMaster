package domain.zaaibaar;

public class Klimboon extends Boon {
    public Klimboon(String naam, String soort, boolean inserre, int vervaljaar, int aantal, double hoogte, boolean ziekteresistent, boolean hybride, int opbrengst, String kleur, String vorm) {
        super(naam, soort, inserre, vervaljaar, aantal, ziekteresistent, hybride, opbrengst, kleur, vorm, true);
        this.afstanden.setHoogte(4);
        this.afstanden.setPlantAfstand(0.1);
        this.afstanden.setRijAfstand(0.5);
    }
}
