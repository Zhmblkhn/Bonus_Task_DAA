import java.util.ArrayList;
import java.util.List;

public class Graph {
    int vertices;
    List<Edge> edges = new ArrayList<>();

    public Graph(int vertices) {
        this.vertices = vertices;
    }

    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
