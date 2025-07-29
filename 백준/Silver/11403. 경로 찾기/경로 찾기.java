import java.io.*;
import java.util.*;

public class Main
{
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] vis;
    static int[][] ans;
    static void dfs(int t,int s){
        vis[s] = 1;
        for(int k : adj[s]){
            ans[t][k] = 1;
            ans[s][k] = 1;
            if(vis[k] == 1) continue;
            dfs(t,k);
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = new int[N][N];
        vis = new int[N];
        adj = new ArrayList[N];
        for(int i=0;i<N;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int k = Integer.parseInt(st.nextToken());
                if(k == 1){
                    adj[i].add(j);
                }
            }
        }
        for(int i=0;i<N;i++){
            vis = new int[N];
            dfs(i,i);
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
	}
}