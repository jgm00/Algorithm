import java.io.*;
import java.util.*;

public class Main
{
    static int K,N;
    static int[] arr;
    static boolean bin(long k){
        long sum = 0;
        for(int i=0;i<K;i++){
            sum += arr[i] / k;
        }
        if(sum >= N){
            return true;
        }
        return false;
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for(int i=0;i<K;i++){
            int t = Integer.parseInt(br.readLine());
            arr[i] = t;
        }
        long ans =0;
        long l = 1; long r = (1<<31) - 1;
        while(l<=r){
            long mid = l + (-l+r) / 2;
            if(bin(mid)){
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }
}