package org.group8.multigraph;

import java.util.ArrayList;

public class MultiGraph implements GraphADT {

    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;


    @Override
    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    @Override
    public ArrayList<Edge> getEdges() {
        return edges;
    }

    @Override
    public boolean hasEdge(Vertex startVertex, Vertex endVertex) {
        boolean hasEdge = false;

        for (Edge edge:edges) {
            hasEdge = edge.getStartVertex() == startVertex &&
                    edge.getEndVertex() == endVertex;
            if (hasEdge) {
                break;
            }
        }

        return hasEdge;
    }

    @Override
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    @Override
    public int getNumVertices() {
        return vertices.size();
    }

    @Override
    public int getNumEdges() {
        return edges.size();
    }

    @Override
    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    @Override
    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    @Override
    public Vertex getVertex(int id) {
        for (Vertex vertex: vertices) {
            if (vertex.getID() == id) {
                return vertex;
            }
        }
        return null;
    }
}
