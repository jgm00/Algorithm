import java.util.*;
import java.io.*;

public class Main
{
    static int T;
    static long[] dp;
	public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp = new long[100001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
        dp[6] = 6;
        for(int i=7;i<100001;i++){
            dp[i] = (dp[i-2]+ dp[i-4]+ dp[i-6] )% (1000000009);
        }
        for(int i=0;i<T;i++){
            int k = Integer.parseInt(br.readLine());
            System.out.println(dp[k]);
        }
        
	}
}