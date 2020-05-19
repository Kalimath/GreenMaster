package domain.zaaibaar;

import domain.soort.Capsicum;

public class RocotoPeper extends Peper implements Capsicum {
    public RocotoPeper(String naam, String soort, int vervaljaar, int aantal, double hoogte, boolean ziekteresistent, boolean hybride, int opbrengst, String vorm, String kleur, int scoville) {
        super(naam, soort, vervaljaar, aantal, ziekteresistent, hybride, opbrengst, vorm, kleur, scoville);
        setMeerderjarigheid(true);
        this.groeiMonitor.veranderZaaiperiode("maart","maart");
        this.groeiMonitor.veranderVerplantperiode("april","mei");
        this.groeiMonitor.veranderOogstperiode("juli","oktober");
        this.alert = "heeft kouder klimaat nodig, weinig stikstof";
        this.afstanden.setHoogte(4);
    }



}
