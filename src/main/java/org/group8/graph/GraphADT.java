package org.group8.graph;

import java.util.ArrayList;

public interface GraphADT {

    ArrayList<Vertex> getVertices();

    ArrayList<Edge> getEdges();

    boolean hasEdge(Vertex startVertex, Vertex endVertex);

    boolean isEmpty();

    int getNumVertices();

    int getNumEdges();

    void addVertex(Vertex vertex);

    void addEdge(Edge edge);

    Vertex getVertex(int id);
}
