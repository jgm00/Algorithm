import java.util.*;
import java.io.*;

public class Main
{
    static int S,C,mx;
    static int ans = 0;
    static int[] num;
    static boolean check(int k){
        long sm = 0;
        for(int i=0;i<S;i++){
            sm += num[i] / k;
        }
        if(sm >= C){
            return true;
        }
        return false;
    }
    static void bin(int l, int r){
        ans = 0;
        while(l <= r){
            int mid = (l + r) / 2;
            if(check(mid)){
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        num = new int[S];
        long summ = 0;
        for(int i=0;i<S;i++){
            num[i] = Integer.parseInt(br.readLine());
            mx = Math.max(mx, num[i]);
            summ += num[i];
        }
        bin(1,mx);
        long answer = 0;
        answer = summ - (long) ans*C;
        System.out.println(answer);
	}
}