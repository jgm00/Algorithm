import java.io.*;
import java.util.*;

public class Main
{
    static int N,M,V;
    static ArrayList<Integer>[] adj;
    static Queue<Integer> q = new LinkedList<>();
    static int[] vis;
    static void dfs(int s){
        vis[s] = 1;
        System.out.print(s + " ");
        for(int i : adj[s]){
            if(vis[i] == 1) continue;
            dfs(i);
        }
    }
    static void bfs(int s){
        q.add(s);
        vis[s] = 1;
        while(!q.isEmpty()){
            int k = q.poll();
            System.out.print(k + " ");
            for(int v : adj[k]){
            if(vis[v] == 1) continue;
                q.add(v);
                vis[v] = 1;
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		vis = new int[N+1];
		for(int i=1;i<N+1;i++){
		    adj[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    int v1 = Integer.parseInt(st.nextToken());
		    int v2 = Integer.parseInt(st.nextToken());
		    adj[v1].add(v2);
		    adj[v2].add(v1);
		}
		for(int i=1;i<N+1;i++){
		    Collections.sort(adj[i]);
		}
		dfs(V);
		vis = new int[N+1];
		System.out.println();
		bfs(V);
	}
}