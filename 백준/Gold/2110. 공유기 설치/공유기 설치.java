import java.io.*;
import java.util.*;

public class Main
{
    static int N, C;
    static int[] arr;
    // 1 2 4 8 9
    static int fun(int k){
        int st = arr[0];
        int cnt = 1;
        for(int i = 0; i<N-1;i++){
		 if(arr[i+1] - st >= k){
		        st = arr[i+1];
		        cnt += 1;
		    }
		}
		return cnt;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i=0;i<N;i++){
		    arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int ans =0;
		int l = 0; int r = arr[N-1];
		while(l<=r){
		    int mid = (l+r) / 2;
		    if(fun(mid) >= C){
		        ans = mid;
		        l = mid + 1;
		    }else{
		        r = mid - 1;
		    }
		}
		System.out.println(ans);
	}
}