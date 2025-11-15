import java.util.*;
import java.io.*;

public class Main
{
    static int TC, N, M, W;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static long[] dist;
    static boolean isC;
    static ArrayList<Pair>[] adj;
    static long INF = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    TC = Integer.parseInt(br.readLine());
	    while(TC-- > 0){
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        W = Integer.parseInt(st.nextToken());
	        dist = new long[N+1];
	        adj = new ArrayList[N+1];
	        for(int i=1;i<=N;i++){
	            adj[i] = new ArrayList<>();
	        }
	        for(int i=0;i<M;i++){
	            st = new StringTokenizer(br.readLine());
	            int s = Integer.parseInt(st.nextToken());
	            int e = Integer.parseInt(st.nextToken());
	            int t = Integer.parseInt(st.nextToken());
	            adj[s].add(new Pair(e,t));
                adj[e].add(new Pair(s,t));
	        }
	        for(int i=0;i<W;i++){
	           	st = new StringTokenizer(br.readLine());
	            int s = Integer.parseInt(st.nextToken());
	            int e = Integer.parseInt(st.nextToken());
	            int t = Integer.parseInt(st.nextToken());
	            adj[s].add(new Pair(e,-1*t)); 
	        }
	        isC = false;
	        for(int i=0;i<N;i++){
	            for(int here = 1; here<=N; here++){
	                for(Pair p : adj[here]){
	                    int to = p.x;
	                    int d = p.y;
	                    if(dist[here] + d < dist[to]){
	                        if(i==N-1){
	                            isC = true;
	                        }
	                        dist[to] = dist[here] + d;
	                    }
	                }
	            }
	        }
	        System.out.println(isC ? "YES" : "NO");
	    }
	}
}