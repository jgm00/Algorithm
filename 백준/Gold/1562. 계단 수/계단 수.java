import java.util.*;
import java.io.*;

public class Main
{
    static int N;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
	    long[][][] dp = new long[N+1][10][1<<10];
	    for(int i=1;i<=9;i++){
	        dp[1][i][1<<i] = 1;
	    }
		for(int i=2;i<=N;i++){
		    for(int j=0;j<=9;j++){
		        for(int k=1;k<(1<<10);k++){
		        if(j==0){
		            dp[i][j][k|(1<<j)] = (dp[i][j][k|(1<<j)] + dp[i-1][j+1][k]);
		        }else{
		            if(j == 9){
		                dp[i][j][k|(1<<j)] = (dp[i][j][k|(1<<j)] + dp[i-1][j-1][k]);}
		            else{
		                dp[i][j][k|(1<<j)] = (dp[i][j][k|(1<<j)] + dp[i-1][j-1][k]);
		                dp[i][j][k|(1<<j)] = (dp[i][j][k|(1<<j)] + dp[i-1][j+1][k]);}
		        }
		        dp[i][j][k] %= 1000000000;
		    }
		    }
		}
		long ans = 0;
		for(int j=0;j<=9;j++){
		    ans = ans + (dp[N][j][(1<<10) - 1]);
		 }
		 System.out.println(ans%1000000000);
	}
}