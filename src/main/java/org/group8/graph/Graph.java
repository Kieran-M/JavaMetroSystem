package org.group8.graph;

import java.util.Collection;
import java.util.List;

/**
 * A directed graph with vertices and edges. The user of this graph can determine whether the same two nodes can have
 * multiple edges or a single edge connecting them.
 *
 * @param <E> the type of vertices in the graph
 */
public interface Graph<E> {

    /**
     * Adds a vertex to the graph.
     *
     * @param vertex the vertex to be added to the graph
     * @return {@code true} if the graph changed as a result of the call
     */
    boolean addVertex(E vertex);

    /**
     * Adds vertices from a {@code Collection} of vertices.
     *
     * @param vertices collection of vertices to be added to the graph
     * @return {@code true} if the graph changed as a result of the call
     */
    boolean addVertices(Collection<? extends E> vertices);

    /**
     * Adds an edge to the graph. Edges cannot exist without vertices to connect, therefore vertices must be added
     * before adding edges. Many edges can have the same label.
     *
     * @param startVertex the starting vertex of the edge
     * @param endVertex the ending vertex of the edge
     * @return {@code true} if the graph changed as a result of the call
     */
    boolean addEdge(E startVertex, E endVertex) throws VertexNotFoundException;

    /**
     * Removes the first occurrence of the specified vertex from the graph if it is present.
     *
     * @param vertex the vertex to be removed from the graph
     * @return {@code true} if the graph contained the specified vertex object
     */
    boolean removeVertex(E vertex);

    /**
     * Removes the edge denoted by the specified start and end vertices.
     *
     * @param startVertex the starting vertex of the edge to be removed
     * @param endVertex the ending vertex of the edge to be removed
     * @return {@code true} if the graph contained an edge between the specified vertex objects
     */
    boolean removeEdge(E startVertex, E endVertex);

    /**
     * Checks if the specified elements are connected by an edge.
     *
     * @param startVertex the vertex at the beginning of the edge
     * @param endVertex the vertex at the end of the edge
     * @return {@code true} if the vertices are connected by an edge
     */
    boolean isAdjacent(E startVertex, E endVertex);

    /**
     * Checks if the graph contains any vertices.
     *
     * @return {@code true} if the graph contains vertices
     */
    boolean isEmpty();

    /**
     * Returns the number of vertices in the list.
     *
     * @return the number of vertices in the list
     */
    int getNumVertices();

    /**
     * Returns the number of edges in the list.
     *
     * @return the number of edges in the list
     */
    int getNumEdges();

    /**
     * Returns a {@code list} of all vertices adjacent to the specified vertex.
     *
     * @param vertex the vertex to find the adjacent vertices of
     * @return a {@code list} of all vertices adjacent to the specified vertex
     */
    List<E> getAdjacent(E vertex);

    /**
     * Returns a {@code list} of all vertices in the graph.
     *
     * @return a {@code list} of all vertices in the graph
     */
    List<E> getVertices();
}