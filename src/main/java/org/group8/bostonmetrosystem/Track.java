package org.group8.bostonmetrosystem;

import org.group8.directedgraph.DirectedEdge;

import java.util.Objects;

public class Track<V> implements DirectedEdge<V> {

    private final String lineColour;

    private final V sourceVertex;

    private final V targetVertex;

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

    /**
     * Overrides the equals method to allow for proper comparison between tracks.
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
        Track<?> track = (Track<?>) o;
        return getLineColour().equals(track.getLineColour()) && getSourceVertex().equals(track.getSourceVertex()) &&
                getTargetVertex().equals(track.getTargetVertex());
    }

    /**
     * Overrides the {@code hashCode} method for proper comparison between tracks.
     * @return the hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(getLineColour(), getSourceVertex(), getTargetVertex());
    }
}
