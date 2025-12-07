import java.io.*;
import java.util.*;

public class Main
{   
    static int N,M;
    static int mxL;
    static int[][] parent;
    static int[] depth;
    static int[] dist;
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Pair>[] adj;
    static int LCA(int a, int b){
        if(depth[a] > depth[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }
        for(int i=mxL;i>=0;i--){
            if(depth[b] - depth[a] >= (1<<i)){
                b = parent[b][i];
            }
        }
        if(a==b){
            return a;
        }
        for(int i=mxL;i>=0;i--){
            if(parent[a][i] != parent[b][i]){
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }
    
    static void dfs(int k){
        for(Pair nxt : adj[k]){
            if(parent[k][0] == nxt.x) continue;
            parent[nxt.x][0] = k;
            depth[nxt.x] = depth[k] + 1;
            dist[nxt.x] = dist[k] + nxt.y;
            dfs(nxt.x);
        }
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mxL = (int) Math.floor(Math.log10(N) / Math.log10(2));
        adj = new ArrayList[N+1];
        parent = new int[N+1][mxL+1];
        depth = new int[N+1];
        dist = new int[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            adj[v].add(new Pair(e,k));
            adj[e].add(new Pair(v,k));
        }
        parent[1][0] = 0;
        depth[1]= 0;
        dfs(1);
        for(int i=1;i<=mxL;i++){
            for(int j=1;j<=N;j++){
                parent[j][i] = parent[parent[j][i-1]][i-1];
            }
        }
        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int r = LCA(v,e);
            System.out.println(dist[v] + dist[e] - 2*dist[r]);
        }
	}
}