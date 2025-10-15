import java.util.*;
import java.io.*;

class Solution {
    static Queue<Integer> q = new LinkedList<>();
    static int[] vis;
    static int mx = -1;
    static void bfs(){
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nxt : adj[cur]){
                if(vis[nxt] != 0) continue;
                vis[nxt] = vis[cur] + 1;
                q.add(nxt);
                mx = Math.max(vis[nxt],mx);
            }
        }
    }
    static ArrayList<Integer>[] adj;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        vis = new int[n+1];
        adj = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<edge.length;i++){
            int a = edge[i][0];
            int b = edge[i][1];
            adj[a].add(b);
            adj[b].add(a);
        }
        q.add(1);
        vis[1] = 1;
        bfs();
        for(int i=1;i<=n;i++){
            if(vis[i] == mx){
                answer+=1;
            }
        }
        return answer;
    }
}