import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int[] num;
    static ArrayList<Integer>[] adj;
    static int[][] dp;
    static int[] parent;
    static void makep(int n){
        for(int k : adj[n]){
            if(parent[n] == k) continue;
            parent[k] = n;
            makep(k);
        }
    }
    static void dfs(int n){
        dp[n][0] = 0;
        dp[n][1] = num[n];
        for(int k : adj[n]){
            if(parent[n] == k) continue;
            dfs(k);
            dp[n][1] += dp[k][0];
            dp[n][0] = Math.max(dp[k][1],dp[k][0]) + dp[n][0];
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N+1];
        parent = new int[N+1];
        adj = new ArrayList[N+1];
        dp = new int[N+1][2];
        for(int i=1;i<=N;i++){
            num[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        parent[1] = -1;
        makep(1);
        dfs(1);
        int ans = Math.max(dp[1][0], dp[1][1]);
        System.out.println(ans);
	}
}