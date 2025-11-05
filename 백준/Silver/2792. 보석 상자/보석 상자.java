import java.util.*;
import java.io.*;

public class Main
{
    static int N,M,ret,ans,gg;
    static int mx = 0;
    static int[] num;
    static boolean cal(int k){
        int ret = 0;
        for(int i=0;i<M;i++){
            ret += num[i] / k;
            if(num[i]  % k != 0){
                ret += 1;
            }
        }
        if(ret <= N){
            return true;
        }
        return false;
    }
    static void bin(int l, int r){
        ans = 0;
        while(l <= r){
            int mid = (l+r)/2;
            if(cal(mid) == true){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 	StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[M];
        for(int i=0;i<M;i++){
            num[i] = Integer.parseInt(br.readLine());
            gg = Math.max(num[i],gg);
        }
        bin(1,gg);
        int mx = 0;
        for(int i=0;i<M;i++){
            mx = Math.max(num[i] % ans, ans);
        }
        System.out.println(mx);
	}
}