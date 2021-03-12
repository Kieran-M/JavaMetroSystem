package org.group8.directedgraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A Multi-Graph implementation of the {@code DirectedGraph} interface.
 *
 * @param <V> The type of the vertices held within the graph
 * @param <E> the concrete implementation of the {@code DirectedEdge} interface
 * @see DirectedGraph
 * @see DirectedEdge
 */
public class MultiGraph<V, E extends DirectedEdge<V>> implements DirectedGraph<V, E> {

    private ArrayList<V> vertices;

    private ArrayList<E> edges;

    public MultiGraph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    /**
     * Adds a vertex to the directed graph.
     *
     * @param vertex the vertex to be added to the directed graph
     * @return {@code true} if the directed graph changed as a result of the call
     */
    @Override
    public boolean addVertex(V vertex) {
        return vertices.add(vertex);
    }

    /**
     * Adds vertices from a {@code Collection} of vertices. The collection's type must be of or extend the
     * type {@code V}.
     *
     * @param vertices collection of vertices to be added to the directed graph
     * @return {@code true} if the directed graph changed as a result of the call
     */
    @Override
    public boolean addVertices(Collection<? extends V> vertices) {
        return this.vertices.addAll(vertices);
    }

    /**
     * Adds a directed edge between two existing vertices to the directed graph. If the one or both vertices have not already
     * been added to the directed graph a {@code VertexNotFoundException} is thrown.
     *
     * @param edge the edge to be added to the directed graph.
     * @return {@code true} if the directed graph changed as a result of the call
     */
    @Override
    public boolean addEdge(E edge) throws VertexNotFoundException {
        if (!vertices.contains(edge.getSourceVertex()) || !vertices.contains(edge.getTargetVertex())) {
            throw new VertexNotFoundException(NOVERTEXERROR);
        }
        return edges.add(edge);
    }

    /**
     * Adds edges to the directed graph from a {@code Collection} of edges. The collection's type must be of or extend the
     * {@code Edge} interface.
     *
     * @param edges collection of edges to be added to the directed graph
     * @return {@code true} if the directed graph changed as a result of the call
     */
    @Override
    public boolean addEdges(Collection<? extends E> edges) throws VertexNotFoundException {
        for (E edge: edges) {
            if (!vertices.contains(edge.getSourceVertex()) || !vertices.contains(edge.getTargetVertex())) {
                throw new VertexNotFoundException(NOVERTEXERROR);
            }
        }
        return this.edges.addAll(edges);
    }

    /**
     * Removes the first occurrence of the specified vertex from the directed graph if it is present. If the vertex is
     * part of an edge the edge is also removed.
     *
     * @param vertex the vertex to be removed from the directed graph
     * @return {@code true} if the specified vertex was removed from the directed graph
     */
    @Override
    public boolean removeVertex(V vertex) {
        edges.removeIf(e -> e.getSourceVertex().equals(vertex) || e.getTargetVertex().equals(vertex));
        return vertices.remove(vertex);
    }

    /**
     * Removes the edge denoted by the specified source and target vertices from the directed graph.
     *
     * @param sourceVertex the source vertex of the edge to be removed from the directed graph
     * @param targetVertex the target vertex of the edge to be removed from the directed graph
     * @return {@code true} if the directed graph contained an edge between the specified vertices
     */
    @Override
    public boolean removeEdge(V sourceVertex, V targetVertex) {
        return edges.removeIf(e -> e.getSourceVertex().equals(sourceVertex) && e.getTargetVertex().equals(targetVertex));
    }

    /**
     * Removes the specified edge from the directed graph.
     *
     * @param edge the edge to be removed from the directed graph
     * @return {@code true} if the directed graph contained the specified edge
     */
    @Override
    public boolean removeEdge(E edge) {
        return edges.remove(edge);
    }

    /**
     * Checks if the specified vertices are connected by an edge.
     *
     * @param sourceVertex the source vertex of the edge
     * @param targetVertex the target vertex of the edge
     * @return {@code true} if the vertices are connected by an edge
     */
    @Override
    public boolean isAdjacent(V sourceVertex, V targetVertex) {
        for (E edge: edges) {
            if (edge.getSourceVertex().equals(sourceVertex) && edge.getTargetVertex().equals(targetVertex)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the directed graph contains no elements.
     *
     * @return {@code true} if the directed graph contains no elements
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
     * Returns a {@code List} of all vertices adjacent to the specified vertex.
     *
     * @param vertex the vertex to find the adjacent vertices of
     * @return a {@code List} of all vertices adjacent to the specified vertex
     */
    @Override
    public List<V> getAdjacent(V vertex) {
        List<V> adjacent = new ArrayList<>();
        for (E edge: edges) {
            if (edge.getSourceVertex().equals(vertex)) {
                adjacent.add(edge.getTargetVertex());
            }
        }
        return adjacent;
    }

    /**
     * Returns a {@code List} of all vertices in the directed graph.
     *
     * @return a {@code List} of all vertices in the directed graph
     */
    @Override
    public List<V> getVertices() {
        return vertices;
    }
}
