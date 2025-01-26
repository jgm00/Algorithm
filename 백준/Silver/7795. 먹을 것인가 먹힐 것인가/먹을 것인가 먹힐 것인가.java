import java.io.*;
import java.util.*;

public class Main {
	static int T;
	static int N, M;
	static int[] A;
	static int[] B;
	static int ans;

	static int binary_search(int L, int R, int target) {
		int res = L - 1;
		while (L <= R) {
			int mid = (R + L) / 2;
			if (B[mid] < target) {
				res = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		return res;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			A = new int[N];
			B = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				B[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(B);
			for (int i = 0; i < N; i++) {
				ans += (binary_search(0, B.length - 1, A[i]) + 1);
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}