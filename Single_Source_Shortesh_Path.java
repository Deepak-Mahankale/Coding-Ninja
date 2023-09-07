import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

public class Solution {
    public static int[] shortestPath(int n, int [][]edges, int src) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] dist=new int[n];
        for(int i=0;i<n;i++){
        dist[i]=(int)1e9;
        }

        dist[src]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()){
            int node =q.peek();
            q.remove();
            for(int it:adj.get(node)){
                if(dist[node]+1<dist[it]){
                    dist[it]=dist[node]+1;
                    q.add(it);
                }
            }  
        }

        for(int i=0;i<n;i++){
            if(dist[i]==1e9){
                dist[i]=-1;
            }
        }

        return dist;
    }
}