import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static int[] deg,ans;
    static ArrayList<Integer>[] adj;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        deg = new int[N+1];
        ans = new int[N];
        for(int i = 1; i<=N;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            deg[b]+=1;
        }
        int idx = 0;
        for(int i=1;i<=N;i++){
            if(deg[i]==0) pq.add(i);
        }
        while(!pq.isEmpty()){
            int cur = pq.poll();
            ans[idx++] = cur;
            for(int k : adj[cur]){
                deg[k] -= 1;
                if(deg[k]==0) pq.add(k);
            }
        }
        for(int i=0;i<N;i++){
            System.out.print(ans[i] + " ");
        }
	}
}