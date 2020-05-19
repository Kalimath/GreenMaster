package domain.zaaibaar;

public class Aubergine extends Groenten {

    public Aubergine(String naam, String soort, int vervaljaar, int aantal, double hoogte,
                     boolean ziekteresistent, boolean hybride, int opbrengst, String kleur, String vorm) {
        super(naam, soort, true, vervaljaar, aantal, ziekteresistent, hybride, opbrengst, kleur, vorm);
        bestePlaatsIsSerre = true;
        soortNaam = "aubergine";
        this.veranderPlantAfstand(0.6);
        this.veranderRijAfstand(0.6);
        this.groeiMonitor.veranderZaaiperiode("maart","april");
        this.groeiMonitor.veranderVerplantperiode("mei","juni");
        this.groeiMonitor.veranderOogstperiode("juli","september");
    }


}