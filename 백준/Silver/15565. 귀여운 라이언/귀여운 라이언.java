import java.util.*;
import java.io.*;

public class Main
{
    static int N,K;
    static int[] nums;
    static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
		    nums[i] = Integer.parseInt(st.nextToken());
		}
		int r = 0;int cnt = 0;
		for(int l = 0; l < N; l++){
		    while(r < N && cnt < K){
		        if(nums[r] == 1){
		            cnt+=1;
		        }
		        r+=1;
		    }
	    	if(cnt == K){
	            ans = Math.min(ans,(r-l));
	        }
	        if(nums[l] == 1){
	            cnt -= 1;
	        }
		}
		if(ans == Integer.MAX_VALUE){
		    ans = -1;
		}
		System.out.println(ans);
	}
}