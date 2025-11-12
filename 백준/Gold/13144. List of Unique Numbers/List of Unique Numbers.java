import java.util.*;
import java.io.*;

public class Main
{
    static int N,mx;
    static int[] nums;
    static int[] cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
		    nums[i] = Integer.parseInt(st.nextToken());
		    mx = Math.max(nums[i],mx);
		}
		cnt = new int[mx+1];
		long sm = 0; int r = 0;
		for(int l=0;l<N;l++){
		    while(r < N && cnt[nums[r]] == 0){
		        cnt[nums[r]] += 1;
		        r+=1;
		    }
		    sm += (r-l);
		    cnt[nums[l]] -= 1;
		}
		System.out.println(sm);
	}
}