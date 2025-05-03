import java.io.*;
import java.util.*;

public class Main
{
    static int V,E,K;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Pair>[] graph;
    static int[] dist;
    static PriorityQueue<Pair> pq = new PriorityQueue<Pair>((o1,o2)->{
        return o1.y - o2.y;
    });
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        dist = new int[V+1];
        graph = new ArrayList[V+1];
        for(int i=0;i<V+1;i++){
            dist[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            graph[u].add(new Pair(v,w));
        }
        dist[K] = 0;
        pq.add(new Pair(K,0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            for(Pair nxt : graph[p.x]){
                if(dist[p.x] != p.y) continue;
                int dn = dist[p.x] + nxt.y;
                if(dist[nxt.x] > dn){
                    pq.add(new Pair(nxt.x,dn));
                    dist[nxt.x] = dn;
                }
            }
        }
        for(int i=1;i<V+1;i++){
            if(dist[i]!=Integer.MAX_VALUE){
            System.out.println(dist[i]);} else{
                System.out.println("INF");
            }
        }
	}
}