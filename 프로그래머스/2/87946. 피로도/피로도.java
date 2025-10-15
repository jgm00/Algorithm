import java.util.*;
import java.io.*;

class Solution {
    static int[] arr;
    static int[] vis;
    static int N, ans;
    static void dfs(int k, int nw, int[][] dungeons){
        if(k==N){
            int now = nw;
            int cnt = 0;
            for(int i=0;i<k;i++){
                if(dungeons[arr[i]][0] <= now){
                    now -= dungeons[arr[i]][1];
                    cnt += 1;
                }
            }
            ans = Math.max(cnt,ans);
            return;
        }
        for(int i=0;i<N;i++){
            if(vis[i] == 1) continue;
            vis[i] = 1;
            arr[k] = i;
            dfs(k+1,nw,dungeons);
            vis[i] = 0;
        }
    }
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        N = dungeons.length;
        arr = new int[N];
        vis = new int[N];
        dfs(0, k, dungeons);
        return ans;
    }
}