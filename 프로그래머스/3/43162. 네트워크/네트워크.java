import java.util.*;
import java.io.*;

class Solution {
    static Queue<Integer> q = new LinkedList<>();
    static int ans, N;
    static int[] vis;
    static void bfs(int[][] computers, int i){
        if(vis[i] == 1) return;
        q.add(i);
        vis[i] = 1;
        ans += 1;
        while(!q.isEmpty()){
            int k = q.poll();
                for(int j=0;j<N;j++){
                    if(computers[k][j] == 0) continue;
                    if(vis[j] == 1) continue;
                    q.add(j);
                    vis[j] = 1;
                }
        }
    }
    public int solution(int n, int[][] computers) {
        N = n;
        vis = new int[n];
        for(int i=0;i<n;i++){
            bfs(computers, i);
        }
        return ans;
    }
}