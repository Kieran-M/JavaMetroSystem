package org.group8.graph;

public interface EdgeADT<E> {

    E getStartVertex();

    void setStartVertex(E vertex);

    E getEndVertex();

    void setEndVertex(E vertex);
}
