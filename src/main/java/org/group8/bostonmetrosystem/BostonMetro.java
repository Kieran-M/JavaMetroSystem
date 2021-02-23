package org.group8.bostonmetrosystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
     * Prints the current station
     */
    public void getStation(){
        System.out.println("Your current Station is: " + currentStation);
    }

    /**
     * Sets the current station
     */
    //Get station from user's input from the GUI
    public void setStation(){
        System.out.println("Please enter your current Station");
        Scanner name = new Scanner(System.in);
        currentStation = name.nextLine();
    }

    /**
     * Sets the destination station
     */
    //Get destination from user's input from the GUI
    public void setDestination(){
        System.out.println("Please enter your destination");
        Scanner name = new Scanner(System.in);
        destination = name.nextLine();
    }

    /**
     * Prints the destination name
     */
    public void getDestination(){
        System.out.println("Your destination Station is: " + destination);
    }

    /**
     * Gets the route between the station and the destination
     * @return a {@code List} of stations between the current station and the destination station
     */
    public List<String> getRoute(){
        return route;
    }

    /**
     * Constructs a new instance MetroMapParser to read the text file and return
     * information about each station
     * @throws BadFileException if you can not read the text file
     */
    public void readMap() throws BadFileException{
        try {
            MetroMapParser read = new MetroMapParser("src/main/resources/bostonmetro.txt");
            ArrayList<ArrayList<String>> stations = read.generateGraphFromFile();
            System.out.println(stations);
        } catch (IOException e) {
            throw new BadFileException("Can not read text file");
        }
    }

    public static void main(String[] args) throws BadFileException {
        BostonMetro Metro = new BostonMetro();
        Metro.readMap();
        Metro.setStation();
        Metro.setDestination();
        Metro.getStation();
        Metro.getDestination();
    }

}
