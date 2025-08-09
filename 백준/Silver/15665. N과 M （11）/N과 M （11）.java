import java.util.*;
import java.io.*;

public class Main
{   

    static int N,M,chk;
    static int[] arr;
    static int[] vis;
    static int[] num;
    static int st =0;
    static StringBuilder sb = new StringBuilder();
    static void dfs(int k, int pre){
        if(k==M){
            for(int i=0;i<M;i++){
                sb.append(num[arr[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }
        chk = 0;
        for(int i=1;i<=N;i++){
            if(num[chk] == num[i]) continue;
            if(vis[i] == 1) continue;
            arr[k] = i;
            dfs(k+1,arr[k]);
            chk = i;
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        vis = new int[N+1];
        num = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        num[0] = -1;
        Arrays.sort(num);
        dfs(0,0);
        System.out.println(sb.toString());
	}
}