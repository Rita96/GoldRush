/*
 * Code used in the "Software Engineering" course.
 *
 * Copyright 2017 by Claudio Cusano (claudio.cusano@unipv.it)
 * Dept of Electrical, Computer and Biomedical Engineering,
 * University of Pavia.
 */
package goldrush;

import static goldrush.GoldRush.DEFAULT_DAYS;

/**
 *
 * @author Elisa Chiapponi(426982)
 */
public class ChiapponiElisa extends GoldDigger {

    private int choosenSite;
    

    public ChiapponiElisa() {
        this.choosenSite = 0;
        
    }

    @Override
    public int chooseDiggingSite(int[] distances) {
        return choosenSite;
    }

    @Override
    public void dailyOutcome(int revenue, int[] distances, int[] diggers) {

        int digSite = 0;
        float guadagno = 0;
        float guadTmp;

        for (int i = 0; i < diggers.length; i++) {
            guadTmp = 5 * (12 - 2 * distances[i]);
            if (diggers[i] != 0) {
                guadTmp = guadTmp / diggers[i];
            }

            if (guadTmp > guadagno) {
                guadagno = guadTmp;
                if (digSite == 0) {
                    digSite = 0;
                } else if ((int) Math.round(Math.random()) == 0) {

                    digSite = i + 1;
                } else {
                    digSite = i - 1;

                }
            }
        }

        setChoosenSite(digSite);

    }

    public void setChoosenSite(int site) {
        this.choosenSite = site;
    }
}
