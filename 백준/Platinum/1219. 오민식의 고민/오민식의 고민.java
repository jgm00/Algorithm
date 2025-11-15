import java.util.*;
import java.io.*;

public class Main
{
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N, start, en, M;
    static int[] nums, vis;
    static long[] dist;
    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<Pair>[] adj;
    static int INF = Integer.MIN_VALUE;
    static ArrayList<Integer> alst = new ArrayList<>();
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        en = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        for(int i = 0; i<N;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int st1 = Integer.parseInt(st.nextToken());
            int en1 = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            adj[st1].add(new Pair(en1,m));
        }
        dist = new long[N];
        Arrays.fill(dist,INF);
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dist[start] = nums[start];
        for(int i=0;i<N;i++){
            for(int here = 0; here < N; here++){
                for(Pair p : adj[here]){
                    int to = p.x;
                    int dnxt = p.y;
                    if(dist[here] != INF && dist[here] + nums[to] - dnxt > dist[to]){
                        dist[to] = dist[here] + nums[to] - dnxt;
                        if(i == N-1){
                            q.add(here);
                        }
                    }
                }
            }
        }
        int flag = 0;
        vis = new int[N];
        while(!q.isEmpty()){
            int k = q.poll();
            for(Pair nxt : adj[k]){
                if(vis[nxt.x] == 0){
                    vis[nxt.x] = 1;
                    q.add(nxt.x);
                }
            }
            if(vis[en]==1){
                flag = 1;
            }
        }
        if(flag == 1){
            System.out.println("Gee");
        }else if(dist[en] == INF){
            System.out.println("gg");
        }else{
            System.out.println(dist[en]);
        }
	}
}