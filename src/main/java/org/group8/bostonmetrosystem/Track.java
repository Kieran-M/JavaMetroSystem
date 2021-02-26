package org.group8.bostonmetrosystem;

import org.group8.directedgraph.DirectedEdge;

public class Track<V> implements DirectedEdge<V> {

    private String lineColour;

    private V sourceVertex;

    private V targetVertex;

    public Track(String lineColour, V sourceVertex, V targetVertex) {
        this.lineColour = lineColour;
        this.sourceVertex = sourceVertex;
        this.targetVertex = targetVertex;
    }

    public String getLineColour() {
        return lineColour;
    }

    /**
     * Returns the source vertex of the {@code Edge}
     *
     * @return the source vertex of the {@code Edge}
     */
    @Override
    public V getSourceVertex() {
        return sourceVertex;
    }

    /**
     * Returns the target vertex of the {@code Edge}
     *
     * @return the target vertex of the {@code Edge}
     */
    @Override
    public V getTargetVertex() {
        return targetVertex;
    }
}
