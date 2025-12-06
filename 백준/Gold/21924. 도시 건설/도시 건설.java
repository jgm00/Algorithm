import java.util.*;
import java.io.*;

public class Main
{
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
    static int N,M,cnt;
    static ArrayList<Pair>[] adj;
    static long sm,all;
    static int[] chk;
    static PriorityQueue<Pair> pq = new PriorityQueue<>(
        (o1,o2)->{
            return o1.x - o2.x;
        });
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<>();
        }
        chk = new int[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Pair(c,b));
            adj[b].add(new Pair(c,a));
            all+=c;
        }
        chk[1] = 1;
        cnt += 1;
        for(Pair p : adj[1]){
            pq.add(new Pair(p.x,1,p.y));
        }
        while(cnt <= (N-1)){
            if(pq.isEmpty()){
                System.out.println("-1");
                return;
            }
            Pair p = pq.poll();
            int cost = p.x; int a = p.y; int b = p.z;
            if(chk[b] == 1) continue;
            sm += cost;
            cnt++;
            chk[b] = 1;
            for(Pair nxt : adj[b]){
                if(chk[nxt.y] == 0){
                    pq.add(new Pair(nxt.x,b,nxt.y));
                }
            }
        }
        System.out.println(all - sm);
	}
}