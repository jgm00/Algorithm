import java.util.*;
import java.io.*;

public class Main {
	static int[] tree;
	static int N, M;

	static boolean check(int k) {
		long sum = 0;
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] >= k) {
				sum += (tree[i] - k);
			}
		}
		if (sum >= M) {
			return true;
		}
		return false;
	}

	static int binary_lower(int l, int r) {
		int ret = 0;
		while (l <= r) {
			int mid = (int) ((l + r) / 2);
			if (check(mid) == true) {
				ret = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return ret;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		tree = new int[N];
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(binary_lower(0, 2000000000));
	}
}