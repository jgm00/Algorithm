import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] A;
	static int mn = Integer.MAX_VALUE;

	static int bin_search(int L, int R, int tar) {
		int res = L - 1;
		while (L <= R) {
			int mid = (L + R) / 2;
			if (A[mid] < tar) {
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
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		int ans1 = 0;
		int ans2 = 0;
		for (int i = 0; i < N; i++) {
			int k = bin_search(0, N - 1, -A[i]);
			if (0 <= k && k < N && A[k] != A[i]) {
				int abs1 = Math.abs(A[k] + A[i]);
				if (mn > abs1) {
					mn = abs1;
					ans1 = A[k];
					ans2 = A[i];
				}
			}
			if (-1 <= k && k < N-1 && A[k+1] != A[i]) {
				int abs1 = Math.abs(A[k+1] + A[i]);
				if (mn > abs1) {
					mn = abs1;
					ans1 = A[k+1];
					ans2 = A[i];
				}
			}
		}
		if (ans1 < ans2) {
			System.out.println(ans1 + " " + ans2);
		} else {
			System.out.println(ans2 + " " + ans1);
		}
	}
}