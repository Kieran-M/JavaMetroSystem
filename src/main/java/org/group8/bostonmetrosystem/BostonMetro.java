package org.group8.bostonmetrosystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class BostonMetro {
    /**
     * An {@code Object} which is an instance of the class Station
     */
    private Station station;
    /**
     * A {@code String} which stores the current station the user is at
     */
    private String currentStation;
    /**
     * A {@code String} which stores the users destination station
     */
    private String destination;
    /**
     * A {@code List} which stores the route of the Boston Metro between the current station and the destination
     */
    private ArrayList<String> route;

    /**
     * Gets the current station
     * @return the station name
     */
    public String getStation(){
        currentStation = station.getName();
        return currentStation;
    }

    /**
     * Sets the current station
     * @param name the station to be set
     */
    //Get station from user's input from the GUI
    public void setStation(String name){
        currentStation = name;
    }

    /**
     * Sets the destination station
     * @param dest the destination
     */
    //Get destination from user's input from the GUI
    public void setDestination(String dest){
        destination = dest;
    }

    /**
     * Gets the destination name
     * @return destination station name
     */
    public String getDestination(){
        return destination;
    }

    /**
     * Gets the route between the station and the destination
     * @return a {@code List} of stations between the current station and the destination station
     */
    public List<String> getRoute(){
        return route;
    }
}
