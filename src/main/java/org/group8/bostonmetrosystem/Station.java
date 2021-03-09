package org.group8.bostonmetrosystem;

import java.util.Objects;

public class Station {
    /**
     * An {@code int} which stores the stations ID
     */
    private int id;
    /**
     * A {@code String} which stores the station name
     */
    private String name;

    /**
     * Constructs a station with the specified ID and Name
     * @param id the ID of a Station
     * @param name the name of the station
     */
    Station(int id, String name) {
        this.id = id;
        this.name = name;
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
        return name;
    }

    /**
     * Overrides the equals function to allow for proper comparison between stations.
     * @param o The object to compare to this object
     * @return {@code true} if the object is the same as this object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Station station = (Station) o;
        return id == station.id && getName().equals(station.getName());
    }

    /**
     * Overrides the {@code hashCode} method for proper comparison between stations.
     * @return the hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, getName());
    }
}