import java.util.*;
import java.io.*;

public class Main
{   
    static int U,V;
    static int cnt =0;
    static ArrayList<Integer>[] adj;
    static int[] vis;
    static void dfs(int s){
        vis[s] = 1;
        cnt += 1;
        for(int k : adj[s]){
            if(vis[k] == 1) continue;
            dfs(k);
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		U = Integer.parseInt(br.readLine());
		V = Integer.parseInt(br.readLine());
		adj = new ArrayList[U+1];
		vis = new int[U+1];
		for(int i=1; i<U+1;i++){
		    adj[i] = new ArrayList<>();
		}
		for(int i=0;i<V;i++){
		   StringTokenizer st = new StringTokenizer(br.readLine());
		   int s = Integer.parseInt(st.nextToken());
		   int v = Integer.parseInt(st.nextToken());
		   adj[s].add(v); adj[v].add(s);
		}
		dfs(1);
		System.out.println(cnt - 1);
	}
}