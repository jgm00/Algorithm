import java.util.*;
import java.io.*;

public class Main
{

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] num = new int[N+1][4];
        int[][] dp = new int[N+1][8];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=3;j++){
                int k = Integer.parseInt(st.nextToken());
                dp[i][j] = k;
                dp[i][j+3] = k;
            }
        }
        // dp[1][1] = num[1][1]; dp[1][2] = num[1][2]; dp[1][3] = num[1][3];
        for(int i=2;i<=N;i++){
            dp[i][1] += Math.max(dp[i-1][1],dp[i-1][2]);
            dp[i][2] += Math.max(dp[i-1][2],Math.max(dp[i-1][3],dp[i-1][1]));
            dp[i][3] += Math.max(dp[i-1][2],dp[i-1][3]);
            dp[i][4] += Math.min(dp[i-1][4],dp[i-1][5]);
            dp[i][5] += Math.min(dp[i-1][5],Math.min(dp[i-1][6],dp[i-1][4]));
            dp[i][6] += Math.min(dp[i-1][6],dp[i-1][5]);
        }
        int ans1 = Math.max(dp[N][1],Math.max(dp[N][2],dp[N][3]));
        int ans2 = Math.min(dp[N][4],Math.min(dp[N][5],dp[N][6]));
        System.out.println(ans1 + " " + ans2);
	}
}