import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] selected;
	static int[] isused;
	static StringBuilder sb = new StringBuilder();

	static void dfs(int k) {
		if (k == M) {
			for(int i=0;i<M;i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int start = 0;
		if (k != 0) {
			start = selected[k-1];
		}
		for (int i = start+1; i <= N; i++) {
			if(isused[i] == 1) continue;
			selected[k] = i;
			isused[i] = 1;
			dfs(k + 1);
			isused[i] = 0;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		isused = new int[N + 1];
		dfs(0);
		System.out.println(sb.toString());
	}
}