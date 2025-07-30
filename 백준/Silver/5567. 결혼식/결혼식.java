import java.io.*;
import java.util.*;

public class Main
{
    static int N,M;
    static int[] vis;
    static ArrayList<Integer>[] adj;
    static Queue<Integer> q = new LinkedList<>();
    static void bfs(int x){
        vis[x] = 1;
        q.add(x);
        while(!q.isEmpty()){
        
        int cur = q.poll();
        for(int k : adj[cur]){
            if(vis[k] != 0) continue;
            q.add(k);
            
            vis[k] = vis[cur] + 1;
        }}
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        vis = new int[N+1];
        for(int i=1;i<N+1;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b); adj[b].add(a);
        }
        bfs(1);
        int cnt = 0;
        for(int i=2;i<N+1;i++){
            if(vis[i] == 3 || vis[i] == 2){
                cnt+=1;
            }
        }
        System.out.println(cnt);
	}
}