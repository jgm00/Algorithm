import java.util.*;
import java.io.*;

public class Main
{
    static class Pair{
        int x, y,z;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        Pair(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int[] chk;
    static int cnt,sm;
    static ArrayList<Pair>[] adj;
	static int V,E;
	static PriorityQueue<Pair> pq = new PriorityQueue<>(
	    (o1,o2)->{
	        return o1.x - o2.x;
	    });
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList[V+1];
        chk = new int[V+1];
        for(int i=1;i<=V;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            adj[A].add(new Pair(C,B));
            adj[B].add(new Pair(C,A));
        }
        chk[1] = 1;
        for(Pair p : adj[1]){
            pq.add(new Pair(p.x,1,p.y));
        }
        while(cnt < (V-1)){
            Pair p = pq.poll();
            int cost = p.x; int a = p.y; int b = p.z;
            if(chk[b]==1) continue;
            sm += cost;
            cnt++;
            chk[b] = 1;
            for(Pair nxt : adj[b]){
                if(chk[nxt.y] == 0){
                    pq.add(new Pair(nxt.x,b,nxt.y));
                }
            }
        }
        System.out.println(sm);
	}
}