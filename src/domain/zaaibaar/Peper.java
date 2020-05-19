package domain.zaaibaar;

import domain.soort.Capsicum;

public abstract class Peper extends Groenten implements Capsicum {
    private int scoville;


    public Peper(String naam, String soort, int vervaljaar, int aantal, boolean ziekteresistent,
                 boolean hybride, int opbrengst, String vorm, String kleur, int scoville) {
        super(naam, soort,true, vervaljaar, aantal, ziekteresistent, hybride, opbrengst, kleur, vorm);
        bestePlaatsIsSerre = true;
        soortNaam ="peper";
        setPikantheid(scoville);
        this.afstanden.setRijAfstand(0.6);
        this.afstanden.setPlantAfstand(0.6);
        this.afstanden.setHoogte(1);
        this.groeiMonitor.veranderZaaiperiode("maart","maart");
        this.groeiMonitor.veranderVerplantperiode("april","mei");
        this.groeiMonitor.veranderOogstperiode("juli","oktober");

    }

    private void setPikantheid(int scoville) {
        this.scoville = scoville;

    }

    public int getPikantheid() {
        return scoville;
    }

    @Override
    public String toString() {
        String info = super.toString();
        info += "Scoville-waarde: "+this.getPikantheid()+'\n';
        return info;
    }

    @Override
    public String allDataInString() {
        String uit = super.allDataInString();
        uit += this.getPikantheid()+" / ";
        return uit;
    }
}