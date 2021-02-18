package org.group8.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for the {@code Edge} class.
 */
class EdgeTests {

    @Test
    /**
     * Tests if an edge can be created.
     */
    void testEdge() {
        Edge<String> edge = new Edge<>("Start", "End");
        Assertions.assertEquals("Start", edge.getStartVertex());
        Assertions.assertEquals("End", edge.getEndVertex());
    }
}
