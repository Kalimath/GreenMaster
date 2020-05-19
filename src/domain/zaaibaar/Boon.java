package domain.zaaibaar;

public abstract class Boon extends Zaaibaar {

    private boolean klimmend;

    public Boon(String naam, String soort, boolean inserre, int vervaljaar,
                int aantal,
                boolean ziekteresistent, boolean hybride, int opbrengst, String kleur, String vorm, boolean klimmend) {
        super(naam, soort, inserre, vervaljaar, aantal, ziekteresistent, hybride, opbrengst, kleur, vorm);
        soortNaam ="boon";
        setKlimmed(klimmend);

    }

    private void setKlimmed(boolean klimmend) {
            this.klimmend = klimmend;
    }

    public boolean isKlimmend() {
        return klimmend;
    }

    @Override
    public String toString() {
        String uit = super.toString();
        String groei = "";
        if(this.isKlimmend()) {
            groei= "klimmed";
        }
        else {
            groei = "Kruipend";
        }
        uit+= "Type groei: "+ groei+'\n';
        return uit;
    }

    @Override
    public String allDataInString() {
        String uit = super.allDataInString();
        uit += this.isKlimmend()+" / ";
        return uit;
    }
}
