package org.group8.directedgraph;

import java.util.Collection;
import java.util.List;

/**
 * A directed directed graph with vertices and edges. The user of this interface can determine whether the same two nodes can
 * have multiple edges or a single edge connecting them.
 *
 * <p>The type of {@code E} must be an implementation of the {@code DirectedEdge} interface.</p>
 *
 * @param <V> the type of vertices in the directed graph
 * @param <E> the concrete implementation of the {@code DirectedEdge} interface
 * @see DirectedEdge
 * @see MultiGraph
 */
public interface DirectedGraph<V, E extends DirectedEdge<V>> {

    /**
     * Error message for when the {@code VertexNotFoundException} is thrown.
     */
    String NOVERTEXERROR = "Graph does not contain one or both of the specified vertices";

    /**
     * Adds a vertex to the directed graph.
     *
     * @param vertex the vertex to be added to the directed graph
     * @return {@code true} if the directed graph changed as a result of the call
     */
    boolean addVertex(V vertex);

    /**
     * Adds vertices from a {@code Collection} of vertices. The collection's type must be of or extend the
     * type {@code V}.
     *
     * @param vertices collection of vertices to be added to the directed graph
     * @return {@code true} if the directed graph changed as a result of the call
     */
    boolean addVertices(Collection<? extends V> vertices);

    /**
     * Adds a directed edge between two existing vertices to the directed graph. If the one or both vertices have not already
     * been added to the directed graph a {@code VertexNotFoundException} is thrown.
     *
     * @param edge the edge to be added to the directed graph.
     * @return {@code true} if the directed graph changed as a result of the call
     */
    boolean addEdge(E edge) throws VertexNotFoundException;

    /**
     * Adds edges to the directed graph from a {@code Collection} of edges. The collection's type must be of or extend the
     * {@code Edge} interface.
     *
     * @param edges collection of edges to be added to the directed graph
     * @return {@code true} if the directed graph changed as a result of the call
     */
    boolean addEdges(Collection<? extends E> edges) throws VertexNotFoundException;

    /**
     * Removes the first occurrence of the specified vertex from the directed graph if it is present. The implementor
     * can decide what happens if the vertex is part of an edge.
     *
     * @param vertex the vertex to be removed from the directed graph
     * @return {@code true} if the specified vertex was removed from the directed graph
     */
    boolean removeVertex(V vertex);

    /**
     * Removes the edge denoted by the specified source and target vertices from the directed graph.
     *
     * @param sourceVertex the source vertex of the edge to be removed from the directed graph
     * @param targetVertex the target vertex of the edge to be removed from the directed graph
     * @return {@code true} if the directed graph contained an edge between the specified vertices
     */
    boolean removeEdge(V sourceVertex, V targetVertex);

    /**
     * Removes the specified edge from the directed graph.
     *
     * @param edge the edge to be removed from the directed graph
     * @return {@code true} if the directed graph contained the specified edge
     */
    boolean removeEdge(E edge);

    /**
     * Checks if the specified vertices are connected by an edge.
     *
     * @param sourceVertex the source vertex of the edge
     * @param targetVertex the target vertex of the edge
     * @return {@code true} if the vertices are connected by an edge
     */
    boolean isAdjacent(V sourceVertex, V targetVertex);

    /**
     * Checks if the directed graph contains no elements.
     *
     * @return {@code true} if the directed graph contains no elements
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
     * Returns a {@code List} of all vertices adjacent to the specified vertex.
     *
     * @param vertex the vertex to find the adjacent vertices of
     * @return a {@code List} of all vertices adjacent to the specified vertex
     */
    List<V> getAdjacent(V vertex);

    /**
     * Returns a {@code List} of all vertices in the directed graph.
     *
     * @return a {@code List} of all vertices in the directed graph
     */
    List<V> getVertices();
}