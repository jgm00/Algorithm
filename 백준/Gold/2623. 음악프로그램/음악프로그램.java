import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer> lst;
    static int[] deg,ans;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        deg = new int[N+1];
        ans = new int[N];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            lst = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int sz = Integer.parseInt(st.nextToken());
            while(sz-->0){
                int k = Integer.parseInt(st.nextToken());
                lst.add(k);
            }
            for(int j=1;j<lst.size();j++){
                adj[lst.get(j-1)].add(lst.get(j));
                deg[lst.get(j)]+=1;
            }
        }
        for(int i=1;i<=N;i++){
            if(deg[i] == 0) pq.add(i);
        }
        int idx = 0;
        while(!pq.isEmpty()){
            int cur = pq.poll();
            ans[idx++] = cur;
            for(int k : adj[cur]){
                deg[k] -= 1;
                if(deg[k] == 0) pq.add(k);
            }
        }
        if(idx != N){
            System.out.println("0");
            return;
        }
        for(int i=0;i<N;i++){
            System.out.println(ans[i]);
        }
	}
}