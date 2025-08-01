import java.util.*;
import java.io.*;

public class Main
{
    static int T;
    static long[] dp;
    static int mx = 1000000;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp = new long[mx+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4;i<mx+1;i++){
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%(1000000009);
        }
        for(int i=0;i<T;i++){
            int k = Integer.parseInt(br.readLine());
            System.out.println(dp[k]);
        }
        
	}
}