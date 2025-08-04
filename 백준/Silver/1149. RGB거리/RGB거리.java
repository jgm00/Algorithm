import java.util.*;
import java.io.*;

public class Main
{   
    static int[][] board, dp;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        board = new int[k][3];
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[k+1][3];
        for(int i=0;i<3;i++){
            dp[1][i] = board[0][i];
        }
        int mx = Integer.MAX_VALUE;
        for(int i=2;i<=k;i++){
            for(int t = 0; t<3;t++){
                mx = Integer.MAX_VALUE;
                for(int j=0;j<3;j++){
                    if(t==j) continue;
                    mx = Math.min(dp[i-1][j]+board[i-1][t],mx);
                    dp[i][t] = mx;
                }
            }
        }
            int ans = Integer.MAX_VALUE;
            for(int j=0;j<3;j++){
                ans = Math.min(dp[k][j],ans);
            }
            System.out.println(ans);
        
	}
}