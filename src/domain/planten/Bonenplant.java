package domain.planten;

public class Bonenplant extends Plant {

    private boolean klimmend;

    private String soort;

    public Bonenplant(String naam, String soort, boolean ziekteresistent, boolean hybride, String kleur, String vorm, boolean klimmend) {
        super(naam, soort, false, ziekteresistent, hybride, kleur, vorm);
        soortNaam = "boon";
        setSoort(soort);
        setKlimmed(klimmend);
    }

    private void setSoort(String soort) {
        if (soort.isEmpty()) this.soort = "droogboon";
        this.soort = soort;
    }

    private void setKlimmed(boolean klimmed) {
        this.klimmend = klimmed;
    }

    public String getSoort() {
        return soort;
    }

    public boolean isKlimmend() {
        return klimmend;
    }

    @Override
    public String toString() {
        String uit = super.toString();

        uit += this.getNaam() + ": " + '\n' +
                "Soort: " + this.getSoort() + '\n' +
                "Oppervlakte: " + this.getOppervlakte() + " m�\n" +
                "Opbrengst: " + this.getOpbrengst() + '\n' +
                "Ziekteresistentie: " + this.isZiekteresistent() + '\n' +
                "Hybrideras: " + this.isHybride() + '\n' +
                "Kleur: " + this.getKleur() + '\n';
        return uit;
    }

    @Override
    public String allDataInString() {
        String uit = super.allDataInString();
        uit += this.isKlimmend() + " / ";
        return uit;
    }
}