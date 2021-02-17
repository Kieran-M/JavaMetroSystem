package org.group8.bostonmetrosystem;

import java.util.ArrayList;
import java.util.List;

public class BostonMetro {
    private Station station;
    private String currentStation;
    private String destination;
    private ArrayList<String> route;

    public String getStation(){
        currentStation = station.getName();
        return currentStation;
    }

    //Get station from user's input from the GUI
    public void setStation(String current){
        currentStation = current;
    }

    //Get destination from user's input from the GUI
    public void setDestination(String dest){
        destination = dest;
    }

    public String getDestination(){
        return destination;
    }

    public List<String> getRoute(){
        return route;
    }
}
