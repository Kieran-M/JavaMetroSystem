package org.group8.multigraph;

public interface Edge {

    String getLabel();

    void setLabel(String label);

    Vertex getStartVertex();
    
    void setStartVertex(Vertex vertex);

    Vertex getEndVertex();

    void setEndVertex(Vertex vertex);
}
