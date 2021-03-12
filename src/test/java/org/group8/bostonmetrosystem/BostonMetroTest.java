package org.group8.bostonmetrosystem;

import org.junit.jupiter.api.Test;

public class BostonMetroTest {

    @Test
    void bfsTest() {
        Station station1 = new Station(1,"OakGrove");
        Station station2 = new Station(5,"Wellington");

        BostonMetro bm = new BostonMetro();
        bm.setHomeStation(station1);
        bm.setDestination(station2);

        try{
            bm.getRoute();
        } catch(Exception e){
            e.printStackTrace();
        }

    }

}
