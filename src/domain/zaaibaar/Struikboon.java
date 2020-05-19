package domain.zaaibaar;

public class Struikboon extends Boon {
    public Struikboon(String naam, String soort, boolean inserre, int vervaljaar, int aantal, double hoogte, boolean ziekteresistent, boolean hybride, int opbrengst, String kleur, String vorm) {
        super(naam, soort, inserre, vervaljaar, aantal, ziekteresistent, hybride, opbrengst, kleur, vorm, false);
        this.afstanden.setHoogte(0.5);
        this.afstanden.setPlantAfstand(0.1);
        this.afstanden.setRijAfstand(0.5);
    }
}
