import java.io.*;
import java.util.*;

public class Main
{ 
    static int N,M;
    static int[] arr;
    static class Pair{
        int x; int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int check(int k){
        int t = 1;
        int tmp = k;
        for(int i=0;i<N;i++){
            if(k-arr[i] >= 0){
                k = k - arr[i];
            }else{
                k = tmp - arr[i];
                t+=1;
            }
        }
        return t;
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int mn = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
          mn = Math.max(mn, arr[i]);
        }
        int ans = 0;
        int l = mn; int r = 10000*N;
        while(l <= r){
            int mid = (l + r) / 2;
            if(check(mid) <= M){
                ans = mid;
                r = mid - 1;
            }else{
                l= mid + 1;
            }
        }
        System.out.println(ans);
    }
}