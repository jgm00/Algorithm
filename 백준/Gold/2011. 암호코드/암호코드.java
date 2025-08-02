import java.util.*;
import java.io.*;

public class Main
{
    static String N;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        int sz = N.length();
        int[] dp = new int[sz+1];
        dp[0] = 1; 
        if(N.charAt(0) == '0'){
            System.out.println("0");
        return;
      }
        dp[1] = 1;
        for(int i = 1;i<sz; i++){
            int tmp = N.charAt(i-1) - '0';
            int tmp2 = N.charAt(i)-'0';
            int kk = tmp*10;
            kk+=(N.charAt(i)-'0');
            if(0<tmp2 && tmp2 < 10){
                dp[i+1] += dp[i]; 
            }
            if(10<=kk && kk<=26){
                dp[i+1] += dp[i-1];
              dp[i+1] %= (1000000);
            }
        }
        System.out.println(dp[sz] % (1000000));
        
	}
}