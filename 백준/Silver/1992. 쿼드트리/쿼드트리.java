import java.util.*;
import java.io.*;

public class Main {
	static int N, n;
	static int[][] board;
	static int[] ans = new int[100];
	static StringBuilder sb = new StringBuilder();

	static boolean func(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (board[i][j] != board[x][y]) {
					return false;
				}
			}
		}
		return true;
	}

	static void solve(int x, int y, int size) {
		int half = size / 2;
		if (func(x, y, size)) {
			sb.append(board[x][y]);
			return;
		}
		sb.append('(');
		solve(x, y, half);
		solve(x, y + half, half);
		solve(x + half, y, half);
		solve(x + half, y + half, half);
		sb.append(')');
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}
		solve(0, 0, N);
		System.out.println(sb.toString());
	}
}
