package org.group8.directedgraph;

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
}
