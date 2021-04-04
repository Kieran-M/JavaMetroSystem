package org.group8.bostonmetrosystem;

import org.group8.directedgraph.DirectedGraph;
import org.group8.directedgraph.VertexNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
public class BostonMetro {
    /**
     * An {@code Object} which is an instance of the class Station
     */
    private ArrayList<Station> stationList;
    /**
     * A {@code String} which stores the current station the user is at
     */
    private Station currentStation;
    /**
     * A {@code String} which stores the users destination station
     */
    private Station destination;
    /**
     * A {@code List} which stores the route of the Boston Metro between the current station and the destination
     */
    private ArrayList<Station> route;

    static MetroMapParser mmp;

    DirectedGraph<Station, Track<Station>> graph;

    public BostonMetro() {
        try {
            mmp = new MetroMapParser("src/main/resources/org/group8/bostonmetro.txt");
            graph = mmp.generateGraphFromFile();
            stationList = new ArrayList<>(graph.getVertices());
        } catch (IOException | BadFileException | VertexNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the current station
     *
     * @return the station name
     */
    public Station getStation() {
        return currentStation;
    }

    /**
     * Sets the current station
     *
     * @param name the station to be set
     */
    //Get station from user's input from the GUI
    public void setHomeStation(Station name) {
        currentStation = name;
    }

    /**
     * Sets the destination station
     *
     * @param dest the destination
     */
    //Get destination from user's input from the GUI
    public void setDestination(Station dest) {
        destination = dest;
    }

    /**
     * Gets the destination name
     *
     * @return destination station name
     */
    public Station getDestination() {
        return destination;
    }

    public List<String> getStations() {
        ArrayList<String> stationNames = new ArrayList<>();
        for (Station station1 : stationList) {
            stationNames.add(station1.getName());
        }
        Collections.sort(stationNames);
        return stationNames;
    }

    /**
     * Gets the route between the station and the destination
     *
     * @return a {@code List} of stations between the current station and the destination station
     */
    public List<Station> getRoute()  {
        try {
            ArrayList<Station> agenda = new ArrayList<>(); //Arraylist of stations to be checked
            agenda.add(this.getStation()); //Adding the current station to the agenda
            HashMap<Station, Station> stationLinks = new HashMap<>(); //Hashmap containing the links between stations
            route = new ArrayList<>(); //The route between the 2 stations

            //Check the agenda for goal station
            while (!agenda.isEmpty()) {
                Station searchStation = agenda.remove(agenda.size() - 1); //Current station to be checked

                if (searchStation.getName().equals(destination.getName())) { //If station is destination add it to route
                    route.add(searchStation);
                    while (!searchStation.equals(currentStation)) { //Work back and add previous stations to route
                        searchStation = stationLinks.get(searchStation);
                        route.add(searchStation);
                    }
                }
                ArrayList<Station> nextStations = new ArrayList<>(graph.getAdjacent(searchStation)); //Get next stations to search and add to relationship map
                for (Station s : nextStations) {
                    if (!stationLinks.containsKey(s)) {
                        stationLinks.put(s, searchStation);
                        agenda.add(s);
                    }
                }
            }
            //Reverse to get the correct route
            Collections.reverse(route);
            return route;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return route;
    }

    /**
     * Looks up information about a station from its name
     *
     * @return a {@code Station} object containing all the information about the station
     */

    public Station lookupStation(String name){
        for (Station station : stationList) {
            if (station.getName().equals(name)) {
                return station;
            }
        } return null;
    }
}
