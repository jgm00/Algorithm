import java.util.*;
import java.io.*;

public class Main {
    static int N, E;
    static class Pair {
        int x;
        long y; 
        Pair(int x, long y) { this.x = x; this.y = y; }
    }
    static List<Pair>[] adj;
    static long[] dist;
    static long[][] ans; 
    static PriorityQueue<Pair> pq;
    static final long INF = Long.MAX_VALUE / 4;

    static void daik(int s){
        pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.y, o2.y));
        dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        pq.add(new Pair(s, 0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if (p.y != dist[p.x]) continue;
            for (Pair e : adj[p.x]){
                long nd = p.y + e.y;
                if (nd < dist[e.x]){
                    dist[e.x] = nd;
                    pq.add(new Pair(e.x, nd));
                }
            }
        }
        for (int i=1;i<=N;i++) ans[s][i] = dist[i];
    }

    static long safeSum(long... xs){
        long s = 0;
        for (long x : xs){
            if (x >= INF) return INF;
            s += x;
            if (s >= INF) return INF;
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        ans = new long[N+1][N+1];
        for (int i=1;i<=N;i++) adj[i] = new ArrayList<>();

        for (int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            adj[a].add(new Pair(b, d));
            adj[b].add(new Pair(a, d)); 
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        daik(1);
        daik(u);
        daik(v);

        long ans1 = safeSum(ans[1][u], ans[u][v], ans[v][N]); 
        long ans2 = safeSum(ans[1][v], ans[v][u], ans[u][N]); 
        long ret = Math.min(ans1, ans2);

        System.out.println(ret >= INF ? -1 : ret);
    }
}
