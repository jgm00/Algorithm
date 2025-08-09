import java.util.*;
import java.io.*;

public class Main
{
    static int N,M,X;
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int mn = Integer.MIN_VALUE;
    static ArrayList<Pair>[] adj,revadj;
    static int[] dist;
    static PriorityQueue<Pair> pq;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        revadj = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<>();
            revadj[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adj[a].add(new Pair(b,d));
            revadj[b].add(new Pair(a,d));
        }
        int[] ans = new int[N+1];
            pq = new PriorityQueue<>((o1,o2)->{return o1.y-o2.y;});
            Arrays.fill(ans, Integer.MAX_VALUE);
            ans[X] = 0;
            pq.add(new Pair(X,0));
            while(!pq.isEmpty()){
                Pair p = pq.poll();
                if(p.y != ans[p.x]) continue;
                for(Pair e : revadj[p.x]){
                    if((ans[p.x] + e.y) >= ans[e.x]) continue;
                    ans[e.x] = ans[p.x] + e.y;
                    pq.add(new Pair(e.x,ans[e.x]));
                }
            }
            pq = new PriorityQueue<>((o1,o2)->{return o1.y-o2.y;});
            dist = new int[N+1];
            Arrays.fill(dist, Integer.MAX_VALUE);        
            dist[X] = 0;
            pq.add(new Pair(X,0));
            while(!pq.isEmpty()){
                Pair p = pq.poll();
                if(p.y != dist[p.x]) continue;
                for(Pair e : adj[p.x]){
                    if((dist[p.x] + e.y) >= dist[e.x]) continue;
                    dist[e.x] = dist[p.x] + e.y;
                    pq.add(new Pair(e.x,dist[e.x]));
                }
            }
        for(int i=1;i<=N;i++){
            mn = Math.max(mn, (dist[i]+ans[i]) );
        }
        System.out.println(mn);
	}
}