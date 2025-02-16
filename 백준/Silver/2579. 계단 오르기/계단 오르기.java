import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] stairs;
	static int[][] dp;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		stairs = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stairs[i] = sc.nextInt();
		}
		dp = new int[N + 1][N + 1];
		dp[1][0] = 0;
		dp[1][1] = stairs[1];
		if (N >= 2) {
			dp[2][0] = stairs[2];
			dp[2][1] = stairs[1] + stairs[2];
		}
		for (int i = 3; i <= N; i++) {
			dp[i][1] = dp[i - 1][0] + stairs[i];
			dp[i][0] = Math.max(dp[i - 2][0] + stairs[i], dp[i - 2][1] + stairs[i]);
		}
		System.out.println(Math.max(dp[N][0], dp[N][1]));
	}
}
