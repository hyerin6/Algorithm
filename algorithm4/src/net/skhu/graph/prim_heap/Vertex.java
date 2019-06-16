package net.skhu.graph.prim_heap;

public class Vertex implements Comparable<Vertex> {
    String title;
    Edge[] edge;
    int distance, index;
    boolean visited;

    public Vertex(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Vertex v) {
        return this.distance - v.distance;
    }
}
