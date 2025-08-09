import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int[] num;
	static long[][] dp;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N+1];
        for(int i=1; i<=N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        dp = new long[N+1][21];
        dp[1][num[1]] = 1;
        for(int i=2;i<=N;i++){
            for(int j=0;j<=20;j++){
                if(dp[i-1][j] != 0){
                    int k = j + num[i];
                    if(0<=k && k <= 20){
                        dp[i][k] += dp[i-1][j];
                    }
                    int k2 = j - num[i];
                    if(0<=k2 && k2 <= 20){
                        dp[i][k2] += dp[i-1][j];
                    }
                }
            }        
            
        }
        System.out.println(dp[N-1][num[N]]);
	}
}