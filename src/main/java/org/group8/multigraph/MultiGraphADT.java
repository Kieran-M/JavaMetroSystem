package org.group8.multigraph;

import java.util.ArrayList;

public interface MultiGraphADT<E> {

    void createGraph();

    boolean isEmpty();

    boolean isEdge(E node1, E node2);

    int numOfNodes();

    int numOfEdges();

    void newNode(E value);

    void newEdge(E node1, E node2);

    int getDegree(E node);

    ArrayList<E> getAdjacent(E node);

    boolean isAdjacentTo(E node1, E node2);
}
