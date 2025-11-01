import java.util.*;
import java.io.*;

public class Main
{
    static int N,Q;
    static int[] nums,acc;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		nums = new int[N+1];
		for(int i=1;i<=N;i++){
		    nums[i] = Integer.parseInt(st.nextToken());
		}
		acc = new int[N+1];
		acc[1] = nums[1];
		for(int i=1;i<=N;i++){
		    acc[i] = acc[i-1] ^ nums[i];
		}
		int answer = 0;
		for(int i=0;i<Q;i++){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    answer ^= (acc[b]^acc[a-1]);
		}
		System.out.println(answer);
	}
}