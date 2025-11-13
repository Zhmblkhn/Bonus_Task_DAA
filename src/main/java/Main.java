import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 2);
        g.addEdge(2, 3, 4);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 5, 6);

        List<Edge> mst = KruskalMST.buildMST(g);
        System.out.println("Initial MST edges:");
        mst.forEach(System.out::println);
        System.out.println("Total weight = " + KruskalMST.getMSTWeight(mst));

        Edge removed = mst.remove(1);
        System.out.println("\nRemoved edge: " + removed);

        DisjointSet ds = new DisjointSet();
        for (int i = 0; i < g.vertices; i++)
            ds.makeSet(i);
        for (Edge e : mst)
            ds.union(e.src, e.dest);

        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < g.vertices; i++) {
            int root = ds.find(i);
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        System.out.println("\nComponents after removal:");
        for (List<Integer> comp : components.values())
            System.out.println(comp);

        Edge bestReplacement = null;
        int bestWeight = Integer.MAX_VALUE;
        List<Integer> compA = new ArrayList<>(components.values().iterator().next());
        Set<Integer> compASet = new HashSet<>(compA);

        for (Edge e : g.getEdges()) {
            if ((e.src == removed.src && e.dest == removed.dest && e.weight == removed.weight)
                    || (e.src == removed.dest && e.dest == removed.src && e.weight == removed.weight)) {
                continue;
            }

            boolean connects = (compASet.contains(e.src) && !compASet.contains(e.dest))
                    || (compASet.contains(e.dest) && !compASet.contains(e.src));

            if (connects && e.weight < bestWeight) {
                bestWeight = e.weight;
                bestReplacement = e;
            }
        }

        if (bestReplacement != null) {
            mst.add(bestReplacement);
            System.out.println("\nReplacement edge found: " + bestReplacement);
        } else {
            System.out.println("\nNo replacement edge found!");
        }

        System.out.println("\nNew MST edges:");
        mst.forEach(System.out::println);
        System.out.println("New total weight = " + KruskalMST.getMSTWeight(mst));
    }
}
