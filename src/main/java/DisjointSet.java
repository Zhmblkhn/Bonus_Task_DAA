import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    private final Map<Integer, Integer> parent = new HashMap<>();
    private final Map<Integer, Integer> rank = new HashMap<>();

    public void makeSet(int v) {
        parent.put(v, v);
        rank.put(v, 0);
    }

    public int find(int v) {
        if (parent.get(v) != v) {
            parent.put(v, find(parent.get(v))); // path compression
        }
        return parent.get(v);
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU == rootV) return;

        if (rank.get(rootU) < rank.get(rootV)) {
            parent.put(rootU, rootV);
        } else if (rank.get(rootU) > rank.get(rootV)) {
            parent.put(rootV, rootU);
        } else {
            parent.put(rootV, rootU);
            rank.put(rootU, rank.get(rootU) + 1);
        }
    }
}
