import java.io.*;
import java.util.*;

public class Main
{
    static int N,T,ans;
    static int[] vis, done, num;
    static void dfs(int k){
        if(done[k] == 1) return;
        if(vis[k] == 1){
            done[k] = 1;
            ans +=1;
        }
        vis[k]= 1;
        dfs(num[k]);
        done[k] = 1;
        vis[k] = 0;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while(T -- > 0){
		    ans = 0;
		    N = Integer.parseInt(br.readLine());
		    num = new int[N+1];
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int i=1;i<=N;i++){
		        num[i] = Integer.parseInt(st.nextToken());
		    }
		    vis = new int[N+1];
		    done = new int[N+1];
		    for(int i=1;i<=N;i++){
		        if(done[i] == 1) continue;
		        dfs(i);
		    }
		    System.out.println(N-ans);
		}
		

	}
}