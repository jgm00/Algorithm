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
    static int[] dist;
    static StringTokenizer st;
    static PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2) -> o1.y - o2.y);
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        adj = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adj[a].add(new Pair(b,d));
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dist[s] = 0;
        pq.add(new Pair(s,0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(dist[p.x] < p.y) continue;
            for(Pair node : adj[p.x]){
                if(dist[node.x] <= (dist[p.x] + node.y)) continue;
                dist[node.x] = dist[p.x] + node.y;
                pq.add(new Pair(node.x, dist[node.x]));
            }
        }
	    System.out.println(dist[e]);
	}
}