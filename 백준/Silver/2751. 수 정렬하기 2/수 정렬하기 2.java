import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);
		for (int i = 0; i < N; i++) {
			sb.append(nums[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}