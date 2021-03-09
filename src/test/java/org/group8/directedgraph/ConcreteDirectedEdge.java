package org.group8.directedgraph;

import org.group8.bostonmetrosystem.Station;

import java.util.Objects;

public class ConcreteDirectedEdge<V> implements DirectedEdge<V> {

    private V sourceVertex;

    private V targetVertex;

    public ConcreteDirectedEdge(V sourceVertex, V targetVertex) {
        this.sourceVertex = sourceVertex;
        this.targetVertex = targetVertex;
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

    /**
     * Overrides the equals method to allow for proper comparison between edges.
     * @param o The object to compare to this object
     * @return {@code true} if the object is the same as this object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConcreteDirectedEdge<?> that = (ConcreteDirectedEdge<?>) o;
        return getSourceVertex().equals(that.getSourceVertex()) && getTargetVertex().equals(that.getTargetVertex());
    }

    /**
     * Overrides the {@code hashCode} method for proper comparison between tracks.
     * @return the hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(getSourceVertex(), getTargetVertex());
    }
}
