import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static ArrayList<Integer> alist = new ArrayList<Integer>();
    static int mx = Integer.MIN_VALUE;
    static ArrayList<Integer>[] adj;
    static int[] vis,ans;
    static int cnt = 0;
    static Queue<Integer> q;
    static void bfs(){
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int n : adj[cur]){
                if(vis[n] == 1) continue;
                q.add(n);
                cnt += 1;
                vis[n] = 1;
            }
        }
        
    }
	public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		vis = new int[N+1];
        ans = new int[N+1];
		for(int i=0;i<N+1;i++){
		    adj[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    int A = Integer.parseInt(st.nextToken());
		    int B = Integer.parseInt(st.nextToken());
		    adj[B].add(A);
		}
		for(int i=1;i<=N;i++){
		    vis = new int[N+1];
            q = new LinkedList<>();
            q.add(i);
            vis[i] = 1;
		    cnt = 0;
		    bfs();
		    mx = Math.max(mx,cnt);
            ans[i] = cnt;
		}
		for(int i=1;i<=N;i++){
		    if(ans[i] == mx){
                sb.append(i + " ");
            }
		}
        System.out.println(sb.toString());
	}
}