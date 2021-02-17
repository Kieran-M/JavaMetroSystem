package org.group8.graph;

import java.util.*;

/**
 * A Multi-graph implementation of the {@code Graph} interface. It makes use of the {@code Edge} class to store the
 * links between vertices.
 *
 * @param <E> The type of the vertices held within the graph
 * @see Graph
 * @see Edge
 */
public class MultiGraph<E> implements Graph<E> {

    /**
     * A {@code List} which stores the vertices of the graph.
     */
    List<E> vertices;

    /**
     * A {@code List} which stores the edges of the graph. Uses {@code Edge} to store which nodes are linked.
     * @see Edge
     */
    List<Edge<E>> edges;

    /**
     * Constructs an empty graph.
     */
    MultiGraph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    /**
     * Adds a vertex to the graph.
     *
     * @param vertex the vertex to be added to the graph
     * @return {@code true} if the graph changed as a result of the call
     */
    @Override
    public boolean addVertex(E vertex) {
        return vertices.add(vertex);
    }

    /**
     * Adds vertices from a {@code Collection} of vertices.
     *
     * @param vertices collection of vertices to be added to the graph
     * @return {@code true} if the graph changed as a result of the call
     */
    @Override
    public boolean addVertices(Collection<? extends E> vertices) {
        return this.vertices.addAll(vertices);
    }

    /**
     * Adds an edge to the graph. Edges cannot exist without vertices to connect, therefore vertices must be added
     * before adding edges.
     *
     * @param startVertex the starting vertex of the edge
     * @param endVertex the ending vertex of the edge
     * @throws VertexNotFoundException if the queried vertex is not found in the graph
     * @return {@code true} if the graph changed as a result of the call
     */
    @Override
    public boolean addEdge(E startVertex, E endVertex) throws VertexNotFoundException {
        if (!vertices.contains(startVertex)) {
            throw new VertexNotFoundException("Start vertex not found in graph");
        }
        if (!vertices.contains(endVertex)) {
            throw new VertexNotFoundException("End vertex not found in graph");
        }

        return edges.add(new Edge<>(startVertex, endVertex));
    }

    /**
     * Removes the first occurrence of the specified vertex from the graph if it is present. If the vertex is contained
     * within an edge it will also remove that edge.
     *
     * @param vertex the vertex to be removed from the graph
     * @return {@code true} if the graph contained the specified vertex object
     */
    @Override
    public boolean removeVertex(E vertex) {
        edges.removeIf(edge -> edge.getStartVertex().equals(vertex) || edge.getEndVertex().equals(vertex));
        return vertices.remove(vertex);
    }

    /**
     * Removes the edge denoted by the specified start and end vertices.
     *
     * @param startVertex the starting vertex of the edge to be removed
     * @param endVertex   the ending vertex of the edge to be removed
     * @return {@code true} if the graph contained an edge between the specified vertex objects
     */
    @Override
    public boolean removeEdge(E startVertex, E endVertex) {
        return edges.remove(new Edge<>(startVertex, endVertex));
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
        return edges.contains(new Edge<>(startVertex, endVertex));
    }

    /**
     * Checks if the graph contains any vertices.
     *
     * @return {@code true} if the graph contains vertices
     */
    @Override
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    /**
     * Returns the number of vertices in the list.
     *
     * @return the number of vertices in the list
     */
    @Override
    public int getNumVertices() {
        return vertices.size();
    }

    /**
     * Returns the number of edges in the list.
     *
     * @return the number of edges in the list
     */
    @Override
    public int getNumEdges() {
        return edges.size();
    }

    /**
     * Returns a {@code list} of all vertices adjacent to the specified vertex.
     *
     * @param vertex the vertex to find the adjacent vertices of
     * @return a {@code list} of all vertices adjacent to the specified vertex
     */
    @Override
    public List<E> getAdjacent(E vertex) {
        List<E> adjacentVertices = new ArrayList<>();
        for (Edge<E> edge: edges) {
            if (edge.getStartVertex() == vertex) {
                adjacentVertices.add(edge.getEndVertex());
            }
        }
        return adjacentVertices;
    }

    /**
     * Returns a {@code list} of all vertices in the graph.
     *
     * @return a {@code list} of all vertices in the graph
     */
    @Override
    public List<E> getVertices() {
        return vertices;
    }
}
