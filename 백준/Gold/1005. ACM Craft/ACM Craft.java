import java.util.*;
import java.io.*;

public class Main
{
    static int N,K,T,W;
    static int[] D,deg;
    static long[] ans;
    static ArrayList<Integer>[] adj;
    static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq = new PriorityQueue<>();
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            D = new int[N+1];
            adj = new ArrayList[N+1];
            ans = new long[N+1];
            deg = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                D[i] = Integer.parseInt(st.nextToken());
                adj[i] = new ArrayList<>();
            }
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                deg[b]++;
            }
            W = Integer.parseInt(br.readLine());
            for(int i=1;i<=N;i++){
                if(deg[i] == 0) pq.add(i);
            }
            while(!pq.isEmpty()){
                int cur = pq.poll();
                ans[cur] = Math.max(ans[cur],D[cur]);
                for(int k : adj[cur]){
                    ans[k] = Math.max(ans[k], ans[cur] + D[k]);
                    deg[k] -= 1;
                    if(deg[k] == 0) pq.add(k);
                }
            }
            System.out.println(ans[W]);
        }
	}
}