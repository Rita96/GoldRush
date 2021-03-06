package goldrush;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Code used in the "Software Engineering" course.
 *
 * Copyright 2017 by Claudio Cusano (claudio.cusano@unipv.it)
 * Dept of Electrical, Computer and Biomedical Engineering,
 * University of Pavia.
 */

/**
 * Class that store the amount of gold obtained by the diggers.
 * 
 * @author Claudio Cusano <claudio.cusano@unipv.it>
 */
class Bank {
    Map<GoldDigger, Integer> accounts;
    
    Bank() {
        accounts = new HashMap<>();
    }
    
    /**
     * Store additional gold for a digger.
     * 
     * @param digger the owner of the gold
     * @param amount the amount of gold to be stored
     */
    void storeGold(GoldDigger digger, int amount) {
        if (!accounts.containsKey(digger))
            accounts.put(digger, 0);
        int new_amount = amount + accounts.get(digger);
        accounts.put(digger, new_amount);
    }
    
    /**
     * Compute a ranking of the diggers by decreasing amount of stored gold.
     * 
     * @return a list of digger/gold pairs
     */
    List<Map.Entry<GoldDigger, Integer>> richestDiggers() {
        ArrayList<Map.Entry<GoldDigger, Integer>> ranking = new ArrayList<>(accounts.entrySet());
        Collections.sort(ranking, new Comparator<Map.Entry<GoldDigger, Integer>>() {
            @Override
            public int compare(Map.Entry<GoldDigger, Integer> o1, Map.Entry<GoldDigger, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        return ranking;
    }
}
