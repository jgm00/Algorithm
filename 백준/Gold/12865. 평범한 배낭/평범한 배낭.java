import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] info = new int[N + 1][2];
		int[][] dp = new int[N + 1][K + 1];
		int mn = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				dp[j][i] = dp[j - 1][i];
				if (i >= info[j][0]) {
					dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - info[j][0]] + info[j][1]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
