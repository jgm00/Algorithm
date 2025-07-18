import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int[] psum = new int[N+1];
		for(int i = 1; i<N+1; i++) {
			psum[i] = psum[i-1] + num[i-1];
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(psum[j]-psum[k-1]);
		}
	}
}