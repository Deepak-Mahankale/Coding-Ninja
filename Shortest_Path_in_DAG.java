import java.util.ArrayList;

import java.util.*;

public class Solution {
    static class Pair {
        int first;
        int second;

        public Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }

    public static void dfs(ArrayList<ArrayList<Pair>> adj, Stack<Integer> st, int[] visit, int node) {
        visit[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int dn = adj.get(node).get(i).first;
            if (visit[dn] == 0) {
                dfs(adj, st, visit, dn);
            }
        }
        st.push(node);
    }

    public static int[] shortestPathInDAG(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Pair> temp = new ArrayList<Pair>();
            adj.add(temp);
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        int[] vist = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (vist[i] == 0) {
                dfs(adj, st, vist, i);
            }
        }
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) 1e9;
        }
        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int ver = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;
                if (dist[node] + wt < dist[ver]) {
                    dist[ver] = dist[node] + wt;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
