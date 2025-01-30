import java.io.*;
import java.util.*;

public class Main {

	static int N, K;

	static int chk(int S) {
		int sum = 0;
		for (int i = 1; i < N + 1; i++) {
			sum += Math.min(N, S / i);
		}
		return sum;
	}

	static int binary_search(int L, int R, int target) {
		int res = R + 1;
		while (L <= R) {
			int mid = (L + R) / 2;
			if (chk(mid) < target) {
				L = mid + 1;
			} else {
				res = mid;
				R = mid - 1;
			}
		}
		return res;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		System.out.println(binary_search(0,K,K));
	}
}