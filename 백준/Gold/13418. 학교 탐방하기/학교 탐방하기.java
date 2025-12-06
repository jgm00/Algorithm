import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static class Pair{
        int x,y,z;
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
    static long sm;
    static int cnt;
    static ArrayList<Pair>[] adj;
    static PriorityQueue<Pair> pq1 = new PriorityQueue<>((o1,o2)->{
        return o1.x - o2.x;
    });
    static PriorityQueue<Pair> pq2 = new PriorityQueue<>((o1,o2)->{
        return o2.x - o1.x;
    });
    static void prim(PriorityQueue<Pair> pq){
        sm = 0;
        cnt = 0;
        chk = new int[N+1];
        chk[0]=1;
        cnt++;
        for(Pair p : adj[0]){
            pq.add(new Pair(p.x,0,p.y));
        }
        while(cnt <= N){
            Pair p = pq.poll();
            int cost = p.x; int a = p.y; int b = p.z;
            if(chk[b] == 1) continue;
            chk[b] = 1;
            cnt++;
            sm += cost;
            for(Pair nxt : adj[b]){
                if(chk[nxt.y] == 0){
                    pq.add(new Pair(nxt.x,b,nxt.y));
                }
            }
        }
        
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            c = (c==0) ? 1 : 0;
            adj[a].add(new Pair(c,b));
            adj[b].add(new Pair(c,a));
        }
        prim(pq1);
        long ans1 = sm*sm;
        prim(pq2);
        long ans2 = sm*sm;
        System.out.println(ans2 - ans1);
        
	}
}