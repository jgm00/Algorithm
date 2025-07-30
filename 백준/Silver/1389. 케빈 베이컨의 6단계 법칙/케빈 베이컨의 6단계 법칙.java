import java.io.*;
import java.util.*;

public class Main
{
    static int N,M;
    static ArrayList<Integer>[] adj;
    static int[] vis;
    static int[][] cal;
    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        vis = new int[N+1];
        q.add(x);
        vis[x] = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int k : adj[cur]){
                if(vis[k]!=0) continue;
                q.add(k);
                vis[k] =vis[cur] +  1;
            }
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            adj[i] = new ArrayList<>();
        }
        cal = new int[N+1][N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b); adj[b].add(a);
        }
        vis = new int[N+1];
        for(int i=1;i<N+1;i++){
            bfs(i);
            for(int j=1;j<N+1;j++){
                if(i==j) continue;
                cal[i][j] = vis[j] - 1;
            }
        }
        int ans =0;
        int mn = Integer.MAX_VALUE;
        for(int i=N;i>0;i--){
            int sum =0;
            for(int j=1;j<N+1;j++){
                sum += cal[i][j];
        }
        if(sum <= mn){
            mn = sum;
            ans = i;
            
        }
           
        }
         System.out.println(ans);
	}
}