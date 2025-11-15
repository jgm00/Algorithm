import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static boolean isC = false;
    static long[] dist;
    static ArrayList<Integer> alst = new ArrayList<>();
    static long INF = Long.MAX_VALUE;
    static ArrayList<Pair>[] adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		for(int i=1;i<=N;i++){
		    adj[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    adj[a].add(new Pair(b,c));
		}
		dist = new long[N+1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		for(int i=0;i<N;i++){
		    for(int here = 1; here <= N; here++){
		        for(Pair p : adj[here]){
		            int to = p.x;
		            int nxtd = p.y;
		            if(dist[here] != INF && dist[to] > dist[here] + (long) nxtd){
		                if(i == N-1){
                            isC = true;
		                    alst.add(to);
		                }
		                dist[to] = dist[here] + (long) nxtd;
		            }
		        }
		    }
		}
        if(isC){
            System.out.println("-1");
            return;
        }
		for(int i = 2; i<dist.length;i++){
		    if(dist[i] == INF){
		        System.out.println("-1");
		    }else{
		        System.out.println(dist[i]);
		    }
		}
	}
}