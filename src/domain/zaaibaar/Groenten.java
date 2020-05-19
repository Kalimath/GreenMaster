package domain.zaaibaar;

public abstract class Groenten extends Zaaibaar {
    public Groenten(String naam, String soort, boolean inserre, int vervaljaar, int aantal,
                    boolean ziekteresistent, boolean hybride, int opbrengst, String kleur, String vorm){
        super(naam,soort,inserre,vervaljaar,aantal,ziekteresistent,hybride,opbrengst,kleur,vorm);
        this.groeiMonitor.setNpk(6,3,12);
        this.groeiMonitor.setKouBestendig(0);
        this.setMeerderjarigheid(false);

    }
}
