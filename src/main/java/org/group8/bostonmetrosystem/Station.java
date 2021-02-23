package org.group8.bostonmetrosystem;

public class Station {
    /**
     * An {@code int} which stores the stations ID
     */
    private int id;
    /**
     * A {@code String} which stores the station name
     */
    private String station;
    /**
     * A {@code String} which stores which line the metro takes
     */
    private String metroLine;

    /**
     * Constructs a station with the specified ID and Name
     * @param id the ID of a Station
     * @param station the name of the station
     */
    Station(int id, String station) {
        this.id = id;
        this.station = station;
    }

    /**
     * Gets the station ID
     * @return station ID
     */
    public int getID(){
        return id;
    }

    /**
     * Gets the station name
     * @return station name
     */
    public String getName(){
        return station;
    }

    /**
     * Gets the Metro Line
     * @return the metro line
     */
    public String getMetroLine(){
        return metroLine;
    }

    /**
     * Sets the line for the metro
     * @param line the line the metro is going to take from the station
     */
    public void setMetroLine(String line){
        metroLine = line;
    }
}