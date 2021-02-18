package org.group8.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for the {@code MultiGraph} class.
 */
class MultiGraphTest {

    /**
     * Test vertex 1 ({@code String} "Hello")
     */
    static final String VERTEX1 = "Hello";

    /**
     * Test vertex 2 ({@code String}: "World!")
     */
    static final String VERTEX2 = "World!";

    /**
     * Test vertex {@code List} for testing with many vertices.
     */
    static List<Integer> VERTICES;

    /**
     * Initialises the test vertex {@code List}.
     */
    @BeforeAll
    static void init() {
        VERTICES = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            VERTICES.add(i);
        }
    }

    /**
     * Tests the creation of an empty {@code MultiGraph} object.
     */
    @Test
    void createGraph() {
        Graph<Boolean> graph = new MultiGraph<>();
        Assertions.assertTrue(graph.isEmpty());
    }

    /**
     * Tests the addition of a vertex to the graph.
     */
    @Test
    void addVertex() {
        Graph<String> graph = new MultiGraph<>();
        graph.addVertex(VERTEX1);
        Assertions.assertEquals(1, graph.getNumVertices());
        Assertions.assertTrue(graph.getVertices().contains(VERTEX1));
    }

    /**
     * Tests the addition of a collection of vertices to the graph.
     */
    @Test
    void addVertices() {
        Graph<Integer> graph = new MultiGraph<>();
        graph.addVertices(VERTICES);

        Assertions.assertEquals(VERTICES.size(), graph.getNumVertices());
        Assertions.assertEquals(VERTICES, graph.getVertices());
    }

    /**
     * Tests the addition of an edge to the graph.
     *
     * @throws VertexNotFoundException If the vertices are not in the graph
     */
    @Test
    void addEdge() throws VertexNotFoundException {
        Graph<String> graph = new MultiGraph<>();
        graph.addVertex(VERTEX1);
        graph.addVertex(VERTEX2);
        graph.addEdge(VERTEX1, VERTEX2);

        Assertions.assertEquals(1, graph.getNumEdges());
    }

    /**
     * Tests the addition of multiple edges.
     *
     * @throws VertexNotFoundException If the vertices are not in the graph
     */
    @Test
    void addEdgeWithMultiValues() throws VertexNotFoundException {
        Graph<Integer> graph = new MultiGraph<>();
        graph.addVertices(VERTICES);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(0,1);
        graph.addEdge(3,1);

        Assertions.assertEquals(4, graph.getNumEdges());
    }

    /**
     * Tests that an exception is thrown when one or both of the vertices aren't already present on the graph.
     */
    @Test
    void exceptionThrownWhenVerticesDoNotExist() {
        Graph<String> graph = new MultiGraph<>();

        Exception exception = Assertions.assertThrows(VertexNotFoundException.class, () -> graph.addEdge(VERTEX1, VERTEX2));
        Assertions.assertEquals(Graph.STARTVERTEXERROR, exception.getMessage());

        graph.addVertex(VERTEX1);
        exception = Assertions.assertThrows(VertexNotFoundException.class, () -> graph.addEdge(VERTEX1, VERTEX2));
        Assertions.assertEquals(Graph.ENDVERTEXERROR, exception.getMessage());
    }

    /**
     * Tests the removal of a vertex.
     */
    @Test
    void removeVertex() {
        Graph<String> graph = new MultiGraph<>();
        graph.addVertex(VERTEX1);
        graph.addVertex(VERTEX2);
        graph.removeVertex(VERTEX1);

        Assertions.assertEquals(1, graph.getNumVertices());
        Assertions.assertFalse(graph.getVertices().contains(VERTEX1));
        Assertions.assertTrue(graph.getVertices().contains(VERTEX2));
    }

    /**
     * Tests that when a vertex with edge(s) is removed the edges are also removed.
     *
     * @throws VertexNotFoundException If the vertices are not in the graph
     */
    @Test
    void removeEdgeWithVertex() throws VertexNotFoundException {
        Graph<Integer> graph = new MultiGraph<>();
        graph.addVertices(VERTICES);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(1,3);

        graph.removeVertex(1);
        Assertions.assertEquals(1, graph.getNumEdges());
    }

    /**
     * Tests the removal of an edge from the graph.
     *
     * @throws VertexNotFoundException If the vertices of the edge to be removed are not in the graph
     */
    @Test
    void removeEdge() throws VertexNotFoundException {
        Graph<String> graph = new MultiGraph<>();
        graph.addVertex(VERTEX1);
        graph.addVertex(VERTEX2);
        graph.addEdge(VERTEX1, VERTEX2);
        graph.addEdge(VERTEX2, VERTEX1);
        graph.removeEdge(VERTEX1, VERTEX2);

        Assertions.assertEquals(1, graph.getNumEdges());
    }

    /**
     * Tests the adjacent method
     *
     * @throws VertexNotFoundException If the vertices are not in the graph
     */
    @Test
    void isAdjacent() throws VertexNotFoundException {
        Graph<String> graph = new MultiGraph<>();
        graph.addVertex(VERTEX1);
        graph.addVertex(VERTEX2);
        graph.addEdge(VERTEX1, VERTEX2);

        Assertions.assertTrue(graph.isAdjacent(VERTEX1, VERTEX2));
        Assertions.assertFalse(graph.isAdjacent(VERTEX2, VERTEX1));
    }

    /**
     * Tests the getting of adjacent nodes from the graph.
     *
     * @throws VertexNotFoundException If the vertices are not in the graph
     */
    @Test
    void getAdjacent() throws VertexNotFoundException {
        Graph<Integer> graph = new MultiGraph<>();
        graph.addVertices(VERTICES);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);
        expected.add(4);

        Assertions.assertEquals(expected,graph.getAdjacent(1));
    }
}
