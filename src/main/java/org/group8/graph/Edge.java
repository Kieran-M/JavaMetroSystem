package org.group8.graph;

/**
 * A link between two vertices for use in implementations of the {@code graph} interface.
 *
 * @param <E> The type of vertices in this edge
 * @see Graph
 * @see MultiGraph
 */
public class Edge<E> {

    /**
     * The vertex object that is at the start of the edge.
     */
    private final E startVertex;

    /**
     * The vertex object that is at the end of the edge.
     */
    private final E endVertex;

    /**
     * Constructs an edge with the specified start and end vertices.
     *
     * @param vertexStart the vertex to start the edge with
     * @param endVertex the vertex to end the edge with
     */
    Edge(E vertexStart, E endVertex) {
        this.startVertex = vertexStart;
        this.endVertex = endVertex;
    }

    /**
     * Gets the vertex the edge starts with.
     *
     * @return the vertex at the start of the edge
     */
    public E getStartVertex() {
        return startVertex;
    }

    /**
     * Gets the vertex the edge ends with.
     *
     * @return the vertex at the end of the edge
     */
    public E getEndVertex() {
        return endVertex;
    }
}
