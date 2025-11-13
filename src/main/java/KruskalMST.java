import java.util.*;

public class KruskalMST {
    public static List<Edge> buildMST(Graph graph) {
        List<Edge> mst = new ArrayList<>();
        DisjointSet ds = new DisjointSet();

        for (int i = 0; i < graph.vertices; i++)
            ds.makeSet(i);

        List<Edge> sortedEdges = new ArrayList<>(graph.getEdges());
        Collections.sort(sortedEdges);

        for (Edge edge : sortedEdges) {
            int root1 = ds.find(edge.src);
            int root2 = ds.find(edge.dest);

            if (root1 != root2) {
                mst.add(edge);
                ds.union(edge.src, edge.dest);
            }
        }
        return mst;
    }

    public static int getMSTWeight(List<Edge> mst) {
        return mst.stream().mapToInt(e -> e.weight).sum();
    }
}
