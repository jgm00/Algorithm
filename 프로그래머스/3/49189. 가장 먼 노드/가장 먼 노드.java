import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<Integer>[] alist;
    static Queue<Integer> q;
    static int[] vis;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        q = new LinkedList<>();
        vis = new int[n+1];
        alist = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            alist[i] = new ArrayList<>();
        }
        for(int i=0;i<edge.length;i++){
            int a = edge[i][0];
            int b = edge[i][1];
            alist[a].add(b);
            alist[b].add(a);
        }
        int mx = -1;
        vis[1] = 1;
        q.add(1);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nxt : alist[cur]){
                if(vis[nxt] != 0) continue;
                vis[nxt] = 1+vis[cur];
                q.add(nxt);
            }
        }
        for(int i=1;i<n+1;i++){
            mx = Math.max(mx, vis[i]);
        }
        for(int i=1;i<n+1;i++){
            if(mx == vis[i]){
                answer += 1;
            }
        }
        return answer;
    }
}