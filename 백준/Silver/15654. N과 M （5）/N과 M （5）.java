import java.io.*;
import java.util.*;

public class Main {
	static int[] isused;
	static int[] arr;
	static int[] num;
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	static void dfs(int k) {
		if (k == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(num[arr[i]] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isused[i] != 1) {
				arr[k] = i;
				isused[i] = 1;
				dfs(k+1);
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
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		dfs(0);
	}
}