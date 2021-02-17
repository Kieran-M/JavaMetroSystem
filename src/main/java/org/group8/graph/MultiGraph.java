package org.group8.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MultiGraph<E> implements GraphADT<E> {

    ArrayList<E> vertices;
    ArrayList<E> edges;

    MultiGraph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    /**
     * Adds a vertex to the graph.
     *
     * @param vertex the vertex to be added to the graph
     */
    @Override
    public void addVertex(E vertex) {
        vertices.add(vertex);
    }

    /**
     * Adds vertices from a {@code Collection} of vertices.
     *
     * @param vertices collection of vertices to be added to the graph
     */
    @Override
    public void addVertices(Collection<E> vertices) {
        this.vertices.addAll(vertices);
    }

    /**
     * Adds an edge to the graph. Edges cannot exist without vertices to connect, therefore vertices must be added
     * before adding edges.
     *
     * @param vertexStart the starting vertex of the edge
     * @param vertexEnd   the ending vertex of the edge
     */
    @Override
    public void addEdge(E vertexStart, E vertexEnd) {
        
    }

    /**
     * Removes the first occurrence of the specified vertex from the graph if it is present.
     *
     * @param vertex the vertex to be removed from the graph
     */
    @Override
    public void removeVertex(E vertex) {

    }

    /**
     * Removes the edge denoted by the specified start and end vertices.
     *
     * @param vertexStart the starting vertex of the edge to be removed
     * @param vertexEnd   the ending vertex of the edge to be removed
     */
    @Override
    public void removeEdge(E vertexStart, E vertexEnd) {

    }

    /**
     * Checks if the specified elements are connected by an edge.
     *
     * @param startVertex the vertex at the beginning of the edge
     * @param endVertex   the vertex at the end of the edge
     * @return {@code true} if the vertices are connected by an edge
     */
    @Override
    public boolean isAdjacent(E startVertex, E endVertex) {
        return false;
    }

    /**
     * Checks if the graph contains any vertices.
     *
     * @return {@code true} if the graph contains vertices
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns the number of vertices in the list.
     *
     * @return the number of vertices in the list
     */
    @Override
    public int getNumVertices() {
        return 0;
    }

    /**
     * Returns the number of edges in the list.
     *
     * @return the number of edges in the list
     */
    @Override
    public int getNumEdges() {
        return 0;
    }

    /**
     * Returns a {@code list} of all vertices adjacent to the specified vertex.
     *
     * @param vertex the vertex to find the adjacent vertices of
     * @return a {@code list} of all vertices adjacent to the specified vertex
     */
    @Override
    public List<E> getAdjacent(E vertex) {
        return null;
    }

    /**
     * Returns a {@code list} of all vertices in the graph.
     *
     * @return a {@code list} of all vertices in the graph
     */
    @Override
    public List<E> getVertices() {
        return null;
    }
}
