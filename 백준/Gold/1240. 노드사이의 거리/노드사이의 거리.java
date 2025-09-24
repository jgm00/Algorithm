import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Pair>[] adj;
    static int[] vis;
    static Queue<Pair> q = new LinkedList<>();
    static int bfs(int cur, int nxt){
        q = new LinkedList<>();
        vis = new int[N+1];
        q.add(new Pair(cur,0));
        vis[cur] = 1;
        while(!q.isEmpty()){
            Pair curi = q.poll();
            int d = curi.y;
            int curx = curi.x;
            if(curx == nxt){
                return d;
            }
            for(Pair p : adj[curx]){
                int k = p.x;
                int nd = p.y;
                if(vis[k] == 1) continue;
                q.add(new Pair(k, nd+d));
                vis[k] = 1;
            }
        }
        return -1;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		for(int i=1; i<=N;i++){
		    adj[i] = new ArrayList<>();
		}
		for(int i=0;i<(N-1);i++){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int d = Integer.parseInt(st.nextToken());
		    adj[a].add(new Pair(b,d));
		    adj[b].add(new Pair(a,d));
		}
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    int k1 = Integer.parseInt(st.nextToken());
		    int k2 = Integer.parseInt(st.nextToken());
		    int k3 = bfs(k1,k2);
		    System.out.println(k3);
		}
	}
}