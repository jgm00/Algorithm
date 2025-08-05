import java.util.*;
import java.io.*;

public class Main
{   
    static int T;
    static int N = 2;
    static int M;
    static int[][] board,dp;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            M = Integer.parseInt(br.readLine());
            board = new int[N][M];
            dp = new int[M+1][N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }}
                dp[1][0] = board[0][0];
                dp[1][1] = board[1][0];
            if(M>=2){
                            dp[2][0] = board[1][0] + board[0][1];
                dp[2][1] = board[0][0] + board[1][1];
            }for(int i=3;i<=M;i++){
                    dp[i][0] = Math.max(dp[i-1][1], Math.max(dp[i-2][0],dp[i-2][1])) + board[0][i-1];
                    dp[i][1] = Math.max(dp[i-2][1], Math.max(dp[i-1][0],dp[i-2][0])) + board[1][i-1];
    
                }
                System.out.println(Math.max(dp[M][1],dp[M][0]));
            
        }
	}
}