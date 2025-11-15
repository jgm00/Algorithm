import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, K, X;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int INF = Integer.MAX_VALUE;
    static ArrayList<Pair>[] adj;
    static int[] dist;
    static PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2)->{
        return o1.x - o2.x;
    });
    static ArrayList<Integer> alst = new ArrayList<>();
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<>();
        }
        dist = new int[N+1];
        Arrays.fill(dist,INF);
	    for(int i=0;i<M;i++){
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        adj[a].add(new Pair(b,1));
	    }
	    dist[X] = 0;
	    pq.add(new Pair(dist[X],X));
	    while(!pq.isEmpty()){
	        Pair p = pq.poll();
	        if(dist[p.y] != p.x) continue;
	        for(Pair k : adj[p.y]){
	            if(dist[p.y] + k.y < dist[k.x]){
	                dist[k.x] = dist[p.y] + k.y;
	                pq.add(new Pair(dist[k.x],k.x));
	            }
	        }
	    }
	    for(int i=1;i<=N;i++){
	        if(dist[i] == K){
	            alst.add(i);
	        }
	    }
        if(alst.size()==0){
            System.out.println("-1");
            return;
        }
	    Collections.sort(alst);
	    for(int i=0;i<alst.size();i++){
	        System.out.println(alst.get(i));
	    }
	}
}