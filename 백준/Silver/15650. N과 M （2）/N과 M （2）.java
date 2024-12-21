import java.io.*;
import java.util.*;

public class Main {
	static int[] isused;
	static int[] arr;
	static int N, M;

	static void dfs(int k) {
		if (k == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		int st = 0;
		if (k != 0) {
			st = arr[k - 1];
		}
		for (int i = st + 1; i < N+1; i++) {
			if (isused[i] != 1) {
				arr[k] = i;
				isused[i] = 1;
				dfs(k + 1);
				isused[i] = 0;
			}
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isused = new int[N + 1];
		arr = new int[M];
		dfs(0);
	}
}