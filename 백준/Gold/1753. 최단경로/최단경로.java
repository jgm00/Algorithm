import java.util.*;
import java.io.*;

public class Main
{
    static int V,E,K;
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dist;
    static ArrayList<Pair>[] adj;
    static PriorityQueue<Pair> pq = new PriorityQueue<Pair>((o1,o2) -> { return o1.y - o2.y;});
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        dist = new int[V+1];
        adj = new ArrayList[V+1];
        for(int i=1;i<=V;i++){
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i=1;i<=E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Pair(v,w));
        }
        dist[K] = 0;
        pq.add(new Pair(K,0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(dist[p.x] != p.y) continue;
            for(Pair e : adj[p.x]){
                if(dist[e.x] <= (dist[p.x] + e.y)) continue;
                dist[e.x] = dist[p.x] + e.y;
                pq.add(new Pair(e.x,dist[e.x]));
            }
        }
        for(int i=1;i<=V;i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
            System.out.println(dist[i]);}
        }
	}
}