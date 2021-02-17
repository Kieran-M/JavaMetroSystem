package org.group8.bostonmetrosystem;

public class Station {

    private int id;
    private String station;
    private String metroLine;

    Station(int id, String station, String metroLine) {
        this.id = id;
        this.station = station;
        this.metroLine = metroLine;
    }

    public int getID(){
        return id;
    }

    public String getName(){
        return station;
    }

    public String getMetroLine(){
        return metroLine;
    }
}