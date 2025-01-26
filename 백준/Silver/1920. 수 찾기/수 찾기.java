import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] A, B;

	static int binary_search(int L, int R, int target) {
		while (L <= R) {
			int mid = (R + L) / 2;
			if (A[mid] < target) {
				L = mid + 1;
			} else if (A[mid] > target) {
				R = mid - 1;
			} else {
				return 1;
			}
		}
		return 0;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		B = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		for (int i = 0; i < M; i++) {
			System.out.println(binary_search(0,N-1,B[i]));
		}
	}
}