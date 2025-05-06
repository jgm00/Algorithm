import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] par;
    static void dfs(int cur, int parent){
        for(int nxt : graph[cur]){
            if(nxt == parent) continue;
            par[nxt] = cur;
            dfs(nxt,cur);
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		for(int i=0;i<N+1;i++){
		    graph[i] = new ArrayList<>();
		}
		par = new int[N+1];
		for(int i=0;i<N-1;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int v1 = Integer.parseInt(st.nextToken());
		    int v2 = Integer.parseInt(st.nextToken());
		    graph[v1].add(v2);
		    graph[v2].add(v1);
		}
		par[1] = -1;
		dfs(1,-1);
		for(int i=2;i<N+1;i++){
		    System.out.println(par[i]);
		}
	}
}