package org.group8.bostonmetrosystem;

import org.group8.graph.MultiGraph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
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

    private ArrayList<ArrayList<String>> stations = new ArrayList<ArrayList<String>>();

    private Map<String, ArrayList<String>> orange = new HashMap<String, ArrayList<String>>();
    private Map<String, ArrayList<String>> blue = new HashMap<String, ArrayList<String>>();
    private Map<String, List<String>> red = new HashMap<String, List<String>>();
    private Map<String, List<String>> green = new HashMap<String, List<String>>();
    private Map<String, List<String>> mattapan = new HashMap<String, List<String>>();
    private MultiGraph graph = new MultiGraph();


    /**
     * Prints the current station
     */
    public String getStation(){
        return currentStation;
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

    /**
     * Constructs a new instance MetroMapParser to read the text file and return
     * information about each station
     * @throws BadFileException if you can not read the text file
     */
    public void readMap() throws BadFileException{
        try {
            MetroMapParser read = new MetroMapParser("src/main/resources/bostonmetro.txt");
            stations = read.generateGraphFromFile();
            System.out.println(stations);
        } catch (IOException e) {
            throw new BadFileException("Can not read text file");
        }
    }

    /**
     * Adds all the nodes from the list into the graph
     */
    public void addNodes() {
        for (int i = 0; i < stations.size(); i++){
            graph.addVertex(stations.get(i).get(1));
        }
        System.out.println("Number of Nodes in the graph are: " + graph.getNumVertices());
        System.out.println("Nodes: " + graph.getVertices());
    }

    public void getLines(){
        for (int i = 0; i < stations.size(); i++){
            ArrayList <String> tempList = new ArrayList<String>();
            if (stations.get(i).contains("Orange")){
                tempList.add(stations.get(i).get(1));
                tempList.add(stations.get(i).get(3));
                tempList.add(stations.get(i).get(4));
                orange.put(stations.get(i).get(0), tempList);
            } else if (stations.get(i).contains("Blue")){
                tempList.add(stations.get(i).get(1));
                tempList.add(stations.get(i).get(3));
                tempList.add(stations.get(i).get(4));
                blue.put(stations.get(i).get(0), tempList);
            } else if (stations.get(i).contains("Mattapan")){
                tempList.add(stations.get(i).get(1));
                tempList.add(stations.get(i).get(3));
                tempList.add(stations.get(i).get(4));
                mattapan.put(stations.get(i).get(0), tempList);
            } else if (stations.get(i).contains("Red") ||stations.get(i).contains("RedA") || stations.get(i).contains("RedB")){
                tempList.add(stations.get(i).get(1));
                tempList.add(stations.get(i).get(3));
                tempList.add(stations.get(i).get(4));
                red.put(stations.get(i).get(0), tempList);
            } else {
                tempList.add(stations.get(i).get(1));
                tempList.add(stations.get(i).get(3));
                tempList.add(stations.get(i).get(4));
                green.put(stations.get(i).get(0), tempList);
            }
        }
        System.out.println("Orange Line");
        orange.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println("===============================");
        System.out.println("Blue Line");
        blue.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println("===============================");
        System.out.println("Red Line");
        red.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println("===============================");
        System.out.println("Green Line");
        green.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println("===============================");
        System.out.println("Mattapan Line");
        mattapan.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    public static void main(String[] args) throws BadFileException {
        BostonMetro Metro = new BostonMetro();
        try {
            Metro.readMap();
        } catch (BadFileException e) {
            System.out.println("File has wrong format");
        }
        Metro.addNodes();
//        Metro.getLines();
//        Metro.setStation();
//        Metro.setDestination();
//        Metro.getStation();
//        Metro.getDestination();
    }

}
