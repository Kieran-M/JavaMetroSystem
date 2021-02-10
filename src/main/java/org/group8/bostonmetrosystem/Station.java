package org.group8.bostonmetrosystem;

import org.group8.graph.Vertex;

public class Station implements Vertex {

    private int id;
    private String label;

    Station(int id, String label) {
        this.id = id;
        this.label = label;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }
}