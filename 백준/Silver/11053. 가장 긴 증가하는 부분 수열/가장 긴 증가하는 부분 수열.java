import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] lsi;
	static int[] nums;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int ans = Integer.MIN_VALUE;
		lsi = new int[N];
		for (int i = 0; i < N; i++) {
			int prev = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && prev < lsi[j]) {
					prev = lsi[j];
				}
			}
			lsi[i] = prev + 1;
			ans = Math.max(ans, lsi[i]);
		}
		System.out.println(ans);
	}
}
