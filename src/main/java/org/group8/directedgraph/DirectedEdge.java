package org.group8.directedgraph;

public interface DirectedEdge<V> {
    /**
     * Returns the source vertex of the {@code Edge}
     *
     * @return the source vertex of the {@code Edge}
     */
    V getSourceVertex();

    /**
     * Returns the target vertex of the {@code Edge}
     *
     * @return the target vertex of the {@code Edge}
     */
    V getTargetVertex();
}
