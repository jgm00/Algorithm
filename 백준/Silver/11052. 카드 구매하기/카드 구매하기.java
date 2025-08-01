import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int[] num;
    static int[] dp = new int[10001];
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++){
            num[i] = Integer.parseInt(st.nextToken());
            dp[i] = num[i];
        }
        for(int i=2;i<10001;i++){
            int mx = 0;
            if(i<=N){
                mx = Math.max(mx,dp[i]);
            }
            for(int j=1;j<=N;j++){
                if(i-j>=0){ 
                mx = Math.max(mx, dp[i-j]+dp[j]);
            }}
            dp[i] = mx;
        }
        System.out.println(dp[N]);
	}
}