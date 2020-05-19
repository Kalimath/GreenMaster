package domain;

public class PlantAfstanden {
    private double oppervlakte, plantAfstand, rijAfstand, hoogte;

    public PlantAfstanden() {


    }

    public double getOppervlakte() {
        return oppervlakte;
    }

    public void setOppervlakte() {
        this.oppervlakte = this.plantAfstand*this.rijAfstand;
    }

    public double getPlantAfstand() {
        return plantAfstand;
    }

    public void setPlantAfstand(double plantAfstand) {
        if(oppervlakte<0.0){
            throw new IllegalArgumentException("De afstand tussen planten moet groter of gelijk zijn aan 0");
        }
        this.plantAfstand = plantAfstand;
    }

    public double getRijAfstand() {
        return rijAfstand;
    }

    public void setRijAfstand(double rijAfstand) {
        if(oppervlakte<0.0){
            throw new IllegalArgumentException("De rijafstand moet groter of gelijk zijn aan 0");
        }
        this.rijAfstand = rijAfstand;
    }

    public double getHoogte() {
        return hoogte;
    }

    public void setHoogte(double hoogte) {
        this.hoogte = hoogte;
    }
}
