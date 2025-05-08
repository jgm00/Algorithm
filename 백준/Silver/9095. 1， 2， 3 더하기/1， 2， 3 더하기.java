import java.util.*;
import java.io.*;
public class Main
{
    static int T = 0;
    static int[] dp = new int[100000];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4; 
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int k = Integer.parseInt(br.readLine());

            for(int j=4;j<=k;j++){
                dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
            }
            System.out.println(dp[k]);
        }
	}
}