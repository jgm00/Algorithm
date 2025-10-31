import java.util.*;
import java.io.*;

public class Main
{
    static int N, sm1, sm2;
    static int answer = Integer.MAX_VALUE;
    static int[] arr,vis;
    static int[][] board;
    static void dfs(int k, int start){
        if(k == N/2){sm1 = 0; sm2 = 0;
            for(int i=0;i<N;i++){
                
                for(int j=i+1;j<N;j++){
                    if(vis[i]==vis[j]){
                        if(vis[i]==0){
                            sm1 += board[i][j];
                            sm1 += board[j][i];
                        }else{
                            sm2 += board[i][j];
                            sm2 += board[j][i];
                        }
                    }
                }
            }
            answer = Math.min(Math.abs(sm1 - sm2),answer);
            return;
        }
        for(int i=start;i<N;i++){
            if(vis[i] == 0){
                vis[i] = 1;
                dfs(k+1,i+1);
                vis[i] = 0;
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		vis = new int[N];
		for(int i=0;i<N;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int j=0;j<N;j++){
		        board[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		dfs(0,0);
		System.out.println(answer);
	}
}