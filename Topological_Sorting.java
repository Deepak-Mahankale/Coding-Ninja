import java.util.*;
import java.util.Stack;

public class Solution {

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int[] vist, Stack<Integer> st, int node) {
        vist[node] = 1;
        for (int it : adj.get(node)) {
            if (vist[it] == 0) {
                dfs(adj, vist, st, it);
            }
        }
        st.push(node);
    }

    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        List<Integer> topo = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int[] vist = new int[v];

        for (int i = 0; i < v; i++) {
            if (vist[i] == 0) {
                dfs(adj, vist, st, i);
            }
        }

        while (!st.isEmpty()) {
            int val = st.peek();
            topo.add(val);
            st.pop();
        }
        return topo;
    }

}