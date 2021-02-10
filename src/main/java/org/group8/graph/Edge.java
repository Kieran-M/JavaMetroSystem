package org.group8.graph;

public interface Edge {

    String getLabel();

    void setLabel(String label);

    Vertex getStartVertex();
    
    void setStartVertex(Vertex vertex);

    Vertex getEndVertex();

    void setEndVertex(Vertex vertex);
}
