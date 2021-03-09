package org.group8.directedgraph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MultiGraphTest {

    @Test
    void CreateEmptyGraph() {
        DirectedGraph<Boolean, ConcreteDirectedEdge<Boolean>> graph = new MultiGraph<>();

        Assertions.assertTrue(graph.isEmpty());
        Assertions.assertEquals(0, graph.getNumEdges());
        Assertions.assertEquals(0, graph.getNumVertices());
    }

    @Test
    void addingSingleVertex() {
        DirectedGraph<String, ConcreteDirectedEdge<String>> graph = new MultiGraph<>();
        Assertions.assertTrue(graph.addVertex("v1"));
        Assertions.assertEquals("v1", graph.getVertices().get(0));
        Assertions.assertEquals(1, graph.getNumVertices());
    }

    @Test
    void addingMultipleVertices() {
        DirectedGraph<Integer, ConcreteDirectedEdge<Integer>> graph = new MultiGraph<>();
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            vertices.add(i);
        }

        Assertions.assertTrue(graph.addVertices(vertices));
        Assertions.assertEquals(10, graph.getNumVertices());
        Assertions.assertEquals(vertices, graph.getVertices());
    }

    @Test
    void addingSingleEdge() throws VertexNotFoundException {
        DirectedGraph<String, ConcreteDirectedEdge<String>> graph = new MultiGraph<>();
        graph.addVertex("v1");
        graph.addVertex("v2");
        ConcreteDirectedEdge<String> edge = new ConcreteDirectedEdge<>("v1", "v2");

        Assertions.assertTrue(graph.addEdge(edge));
        Assertions.assertEquals(1, graph.getNumEdges());
    }

    @Test
    void addMultipleEdges() throws VertexNotFoundException {
        DirectedGraph<Integer, ConcreteDirectedEdge<Integer>> graph = new MultiGraph<>();
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            vertices.add(i);
        }
        graph.addVertices(vertices);

        List<ConcreteDirectedEdge<Integer>> edges = new ArrayList<>();
        edges.add(new ConcreteDirectedEdge<>(0,2));
        edges.add(new ConcreteDirectedEdge<>(2,0));
        edges.add(new ConcreteDirectedEdge<>(5,4));

        Assertions.assertTrue(graph.addEdges(edges));
        Assertions.assertEquals(3, graph.getNumEdges());
    }

    @Test
    void removingVertex() {
        DirectedGraph<String, ConcreteDirectedEdge<String>> graph = new MultiGraph<>();
        graph.addVertex("v1");
        graph.addVertex("v2");

        Assertions.assertEquals(2, graph.getNumVertices());
        Assertions.assertTrue(graph.removeVertex("v2"));
        Assertions.assertEquals(1, graph.getNumVertices());
    }

    @Test
    void removingVertexWithEdgeRemovesEdge() {

    }

    @Test
    void removingEdgeByVertex() throws VertexNotFoundException {
        DirectedGraph<String, ConcreteDirectedEdge<String>> graph = new MultiGraph<>();
        graph.addVertex("v1");
        graph.addVertex("v2");
        ConcreteDirectedEdge<String> edge = new ConcreteDirectedEdge<>("v1", "v2");
        ConcreteDirectedEdge<String> edge1 = new ConcreteDirectedEdge<>("v2", "v1");
        graph.addEdge(edge);
        graph.addEdge(edge1);

        Assertions.assertEquals(2, graph.getNumEdges());
        Assertions.assertTrue(graph.removeEdge("v1", "v2"));
        Assertions.assertEquals(1, graph.getNumEdges());
        Assertions.assertFalse(graph.removeEdge("v1", "v2"));
    }

    @Test
    void removingEdgeByEdge() throws VertexNotFoundException {
        DirectedGraph<String, ConcreteDirectedEdge<String>> graph = new MultiGraph<>();
        graph.addVertex("v1");
        graph.addVertex("v2");
        ConcreteDirectedEdge<String> edge = new ConcreteDirectedEdge<>("v1", "v2");
        ConcreteDirectedEdge<String> edge1 = new ConcreteDirectedEdge<>("v2", "v1");
        graph.addEdge(edge);
        graph.addEdge(edge1);

        Assertions.assertEquals(2, graph.getNumEdges());
        Assertions.assertTrue(graph.removeEdge(new ConcreteDirectedEdge<>("v2", "v1")));
        Assertions.assertEquals(1, graph.getNumEdges());
        Assertions.assertFalse(graph.removeEdge(new ConcreteDirectedEdge<>("non", "existent")));
    }

    @Test
    void isAdjacent() {

    }

    @Test
    void getAdjacentVerticies() {

    }
}