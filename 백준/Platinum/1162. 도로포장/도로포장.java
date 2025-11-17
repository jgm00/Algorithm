import java.util.*;
import java.io.*;

public class Main

{   
    static long INF = Long.MAX_VALUE;
    static class Pair{
        int x;
        long y;
        Pair(int x, long y){
            this.x = x;
            this.y = y;
        }
    }
    static class Triple{
        int y,z;
        long x;
        Triple(long x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static ArrayList<Pair>[] adj;
    static long[][] dist;
    static PriorityQueue<Triple> pq = new PriorityQueue<>((o1,o2)->{
        return Long.compare(o1.x,o2.x);
    });
    static int N,M,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		for(int i=1;i<=N;i++){
		    adj[i] = new ArrayList<>();
		}
		dist = new long[N+1][K+1];
		for(int i=0;i<=N;i++){
		    Arrays.fill(dist[i], INF);
		}
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    int d = Integer.parseInt(st.nextToken());
		    adj[u].add(new Pair(v,d));
		    adj[v].add(new Pair(u,d));
		}
		dist[1][0] = 0;
		pq.add(new Triple(0,1,0));
		while(!pq.isEmpty()){
		    Triple cur = pq.poll();
		    if(cur.x != dist[cur.y][cur.z]) continue;
		    for(Pair nxt : adj[cur.y]){
		        if(dist[nxt.x][cur.z] > nxt.y + cur.x){
		            dist[nxt.x][cur.z] = nxt.y + cur.x;
		            pq.add(new Triple(dist[nxt.x][cur.z], nxt.x, cur.z));
		        }
		        if(cur.z < K && dist[nxt.x][cur.z + 1] > cur.x){
		            dist[nxt.x][cur.z + 1] = cur.x;
		            pq.add(new Triple(dist[nxt.x][cur.z + 1] , nxt.x, cur.z+1));
		        }
		    }
		}
		long mx = Long.MAX_VALUE;
		for(int i=0;i<=K;i++){
		    mx = Math.min(mx, dist[N][i]);
		}
		System.out.println(mx);
	}
}