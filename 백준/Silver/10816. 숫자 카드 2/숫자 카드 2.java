import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] A;

	static int lower_bound(int L, int R, int tar) {
		int res = R + 1;
		while (L <= R) {
			int mid = (L + R) / 2;
			if (A[mid] < tar) {
				L = mid + 1;
			} else {
				res = mid;
				R = mid - 1;
			}
		}
		return res;
	}
	
	static int upper_bound(int L, int R, int tar) {
		int res = R + 1;
		while(L <= R) {
			int mid = (R+L) / 2;
			if(A[mid] <= tar) {
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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Arrays.sort(A);
		for (int i = 0; i < M; i++) {
			int k = Integer.parseInt(st.nextToken());
			sb.append(upper_bound(0, N - 1, k) - lower_bound(0, N - 1, k)).append(" ");
		}
		System.out.println(sb.toString());
	}
}