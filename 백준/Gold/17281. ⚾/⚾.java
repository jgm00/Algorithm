import java.util.*;
import java.io.*;

public class Main
{
    static int N = 9;
    static int M, ans;
    static int outCount = 0;
    static int[] base = new int[5];
    static int batter;
    static int[][] in;
    static int inn = 0;
    static int[] arr,vis;
    static int go(int[] arr){
        int batterIdx = 0;
        int total = 0;
        base = new int[5];
        outCount = 0;
        for(int t = 0; t<M;t++){
            inn = t;
            base = new int[5];
            outCount = 0;
            while(outCount < 3){
                int batter = arr[batterIdx];
                int op = in[inn][batter];
                batterIdx = (batterIdx+1) % 9;
                if(op == 0) {
                    outCount+=1;
                }else{
                    for(int i=3;i>0;i--){
                        if(base[i]!=0){
                            base[Math.min(4,i+op)] += 1;
                            base[i] = 0;
                        }
                    }
                    base[op] += 1;
                }
                total += base[4];
                base[4] = 0;
            }
        }
        return total;
    }
    static void dfs(int k){
        if(k==N){
            ans = Math.max(ans,go(arr));
            return;
        }
        if(k==3){
            arr[3] = 0;
            dfs(k+1);
            return;
        }
        for(int i=1;i<N;i++){
            if(vis[i]==0){
                vis[i] = 1;
                arr[k] = i;
                dfs(k+1);
                vis[i] = 0;
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
	    arr = new int[N]; vis = new int[N];
	    arr[3] = 1; vis[0] = 1;
	    in = new int[M][9];
	    for(int i=0;i<M;i++){
    		StringTokenizer st = new StringTokenizer(br.readLine());
	        for(int j=0;j<9;j++){
	            in[i][j] = Integer.parseInt(st.nextToken());
	        }        
	    }
	    dfs(0);
        System.out.println(ans);
	}
}