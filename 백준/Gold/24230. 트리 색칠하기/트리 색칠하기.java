import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int[] color, p, cols,vis;
    static ArrayList<Integer>[] adj;
    static void dfsT(int cur){
        vis[cur] = 1;
        for(int nxt : adj[cur]){
            if(vis[nxt] == 1) continue;
            p[nxt] = cur;
            dfsT(nxt);
        }
    }
    static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		color = new int[N+1];
		p = new int[N+1];
		vis = new int[N+1];
		adj = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            color[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList();
        }
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        dfsT(1);
        p[1] = 0;
        if(color[1] != 0){
            answer += 1;
        }
        for(int i=2;i<=N;i++){
            if (color[i] != color[p[i]]){
                answer += 1;
            }
        }
        System.out.println(answer);
		
	}
}