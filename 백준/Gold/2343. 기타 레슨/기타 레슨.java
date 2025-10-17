import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static int[] arr;
    static int func(int l, int r, int tar){
        int ans = r;
        while(l <= r){
            int mid = (l+r) / 2;
            int kmid = func2(mid);
            if(kmid <= tar){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
    static int func2(int k){
        int sm = 0; int cnt = 0;
        for(int i=0;i<N;i++){
            sm += arr[i];
            if(sm > k){
                cnt += 1;
                sm = arr[i];
            }
        }
        return (cnt+1);
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int mx = 0; int mn = 0;
		for(int i=0;i<N;i++){
		    arr[i] = Integer.parseInt(st.nextToken());
		    mx += arr[i];
		    mn = Math.max(mn,arr[i]);
		}
		System.out.println(func(mn, mx, M));
	}
}