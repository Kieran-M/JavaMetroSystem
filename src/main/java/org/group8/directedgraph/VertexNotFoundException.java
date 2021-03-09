package org.group8.directedgraph;

/**
 * This exception is thrown when an edge is trying to be constructed from vertices which have not been added to the directedgraph.
 *
 * @see MultiGraph
 */
public class VertexNotFoundException extends Exception {
    /**
     * Constructs a new instance of {@code VertexNotFoundException} with the error message.
     *
     * @param message Which missing vertex caused the exception
     */
    VertexNotFoundException(String message) {
        super(message);
    }
}
