package org.group8.bostonmetrosystem;

import org.group8.directedgraph.DirectedGraph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
    private Station currentStation;
    /**
     * A {@code String} which stores the users destination station
     */
    private Station destination;
    /**
     * A {@code List} which stores the route of the Boston Metro between the current station and the destination
     */
    private ArrayList<Station> route;

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
    public void setStation(Station name) {
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

    /**
     * Gets the route between the station and the destination
     *
     * @return a {@code List} of stations between the current station and the destination station
     */
    public List<Station> getRoute() throws IOException {

        MetroMapParser mmp = new MetroMapParser("src/main/resources/bostonmetro.txt");
        try {
            DirectedGraph<Station, Track<Station>> graph = mmp.generateGraphFromFile();
            ArrayList<Station> agenda = new ArrayList<>(); //Arraylist of stations to be checked
            agenda.add(this.getStation()); //Adding the current station to the agenda
            HashMap<Station, Station> stationLinks = new HashMap<>(); //Hasmap containing the links between stations
            //ArrayList<Station> route = new ArrayList<>(); //The route between the 2 stations

            //Check the agenda for goal station
            while (!agenda.isEmpty()) {
                Station searchStation = agenda.remove(-1);

                if (searchStation.equals(destination)) {
                    route.add(searchStation);
                    while (!searchStation.equals(currentStation)) {
                        searchStation = stationLinks.get(searchStation);
                        route.add(searchStation);
                    }
                }
                ArrayList<Station> nextStations = new ArrayList<>(graph.getAdjacent(searchStation));
                for(Station s: nextStations){
                    if (!stationLinks.containsKey(s)){
                        stationLinks.put(s,searchStation);
                        agenda.add(s);
                    }
                }
            }
            return route;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return route;
    }
}
