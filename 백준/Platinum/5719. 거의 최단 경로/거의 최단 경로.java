import java.util.*;
import java.io.*;

public class Main
{
    static int N,M,S,D;
    static class Pair{
        int x,y,z;
        Pair(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static boolean[][] removed;
    static ArrayList<Integer>[] pre;
    static ArrayList<Pair>[] adj;
    static PriorityQueue<Pair> pq;
    static int[] dist;
    static void removeP(){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[N];
        
        q.add(D);
        vis[D] = true;
        
        while(!q.isEmpty()){
            int v = q.poll();
            for(int u : pre[v]){
                if(removed[u][v] == false){
                    removed[u][v] = true;
                    if(!vis[u]){
                        vis[u] = true;
                        q.add(u);
                    }
                }
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    N = Integer.parseInt(st.nextToken());
		    M = Integer.parseInt(st.nextToken());
		    if(N == 0 && M == 0){
		        break;
		    }
		    pq = new PriorityQueue<Pair>((o1,o2)->{
		        return o1.x - o2.x;
		    });
		    dist = new int[N];
		    adj = new ArrayList[N];
		    pre = new ArrayList[N];
		    removed = new boolean[N][N];
		    for(int i=0;i<N;i++){
		        dist[i] = Integer.MAX_VALUE;
		        adj[i] = new ArrayList<>();
		        pre[i] = new ArrayList<>();
		    }
		    st = new StringTokenizer(br.readLine());
		    S = Integer.parseInt(st.nextToken());
		    D = Integer.parseInt(st.nextToken());
		    dist[S] = 0;
		    pq.add(new Pair(0,S));
		    for(int i=0;i<M;i++){
    		    st = new StringTokenizer(br.readLine());
    		    int U = Integer.parseInt(st.nextToken());
    		    int V = Integer.parseInt(st.nextToken());
    		    int P = Integer.parseInt(st.nextToken());
    		    adj[U].add(new Pair(V,P));
		    }
		    while(!pq.isEmpty()){
		        Pair p = pq.poll();
		        if(dist[p.y] != p.x) continue;
		        for(Pair nxt : adj[p.y]){
		            if(dist[nxt.x] > dist[p.y] + nxt.y){
		                dist[nxt.x] = dist[p.y] + nxt.y;
		                pq.add(new Pair(dist[nxt.x],nxt.x));
		                pre[nxt.x].clear();
		                pre[nxt.x].add(p.y);
		            }else if(dist[nxt.x] == dist[p.y] + nxt.y){
		                pre[nxt.x].add(p.y);
		            }
		        }
		    }
		    removeP();
		    Arrays.fill(dist,Integer.MAX_VALUE);
		    dist[S] = 0;
		    pq.add(new Pair(0,S));
		    while(!pq.isEmpty()){
		        Pair p = pq.poll();
		        if(dist[p.y] != p.x) continue;
		        for(Pair nxt : adj[p.y]){
		            if(removed[p.y][nxt.x]) continue;
		            if(dist[nxt.x] > dist[p.y] + nxt.y){
		                dist[nxt.x] = dist[p.y] + nxt.y;
		                pq.add(new Pair(dist[nxt.x],nxt.x));
		            }
		        }
		    }
		    int ans = dist[D];
		    if(ans == Integer.MAX_VALUE){
		        ans = -1;
		    }
            System.out.println(ans);
		}
	}
}