package domain;

import java.util.Calendar;
import java.util.Date;

public class Moestuinkalender {
    private String[] maanden;
    private int[] dagen;
    private int dag;
    private int maand;
    private int jaar;

    public Moestuinkalender(String datum) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        maanden = new String[12];
        setDatum(datum);
    }

    private void setZaaiMarge(Object o) {
        if(o instanceof Plant||o instanceof Zaad) {
            if(o instanceof AardappelVroeg) {

            }
        }
    }

    private void stelMaandenOp() {
        maanden[0] = "januari";
        maanden[1] = "februari";
        maanden[2] = "maart";
        maanden[3] = "april";
        maanden[4] = "mei";
        maanden[5] = "juni";
        maanden[6] = "juli";
        maanden[7] = "augustus";
        maanden[8] = "september";
        maanden[9] = "oktober";
        maanden[10] = "november";
        maanden[11] = "december";
    }

    public boolean isSchrikkeljaar(int jaar) {
        boolean result = false;
        if((jaar%4)==0&&(jaar%100)!=0) {
            result=true;
        }
        return result;

    }
}
