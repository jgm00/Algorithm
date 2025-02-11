import java.io.*;
import java.util.*;

public class Main {

	static long[] nums;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		nums = new long[1000001];
		nums[0] = 0;
		nums[1] = 1;
		nums[2] = 2;
		nums[3] = 4;
		for (int j = 4; j <= 1000000; j++) {
			nums[j] = (nums[j - 1] + nums[j - 2] + nums[j - 3]) % 1000000009;
		}
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int k = sc.nextInt();
			System.out.println(nums[k]);
		}
	}
}
