package org.group8.bostonmetrosystem;

import org.group8.directedgraph.MultiGraph;
import org.group8.directedgraph.VertexNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class BostonMetroTest {

    private MultiGraph graph = new MultiGraph();
    private BostonMetro bm = new BostonMetro();

    @Test
    void getRouteTest() {
        Station station1 = new Station(1, "OakGrove");
        Station station2 = new Station(5, "Wellington");

        bm.setHomeStation(station1);
        bm.setDestination(station2);

        try {
            bm.getRoute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void lookupStationTest() {
        Station station1 = new Station(1,"OakGrove");
        Station station2 = new Station(5,"Wellington");
        ArrayList<Station> stationList = new ArrayList<>();
        stationList.add(station1);
        stationList.add(station2);

        BostonMetro bm = new BostonMetro();
        Assertions.assertEquals(bm.lookupStation("OakGrove"), station1);
        Assertions.assertNotEquals(bm.lookupStation("Airport"), stationList.get(0));
        Assertions.assertNotEquals(bm.lookupStation("Airport"), stationList.get(1));
    }

    @Test
    void getStationTest() {
        try {
            List<String> stations = bm.getStations();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

