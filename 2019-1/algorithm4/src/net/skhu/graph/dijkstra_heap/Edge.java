package net.skhu.graph.dijkstra_heap;

public class Edge {
    int weight;
    Vertex vertex;

    public Edge(int weight, Vertex vertex) {
        this.weight = weight;
        this.vertex = vertex;
    }
}
