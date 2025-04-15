import java.util.*;
import java.io.*;

public class Main {

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int ans;
	static int R, C;
	static char[] str = new char[26];
	static char[][] board;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] vis;
	static Queue<Pair> q = new LinkedList<>();
	static int mx = 0;

	static int dfs(int x, int y, int ans) {
		for (int dir = 0; dir < 4; dir++) {
			int nx = dx[dir] + x;
			int ny = dy[dir] + y;
			if (nx < 0 || ny < 0 || nx >= R || ny >= C)
				continue;
			if (vis[nx][ny] != 0 || str[board[nx][ny] - 'A'] != 0)
				continue;
			vis[nx][ny] = 1;
			str[board[nx][ny] - 'A'] = 1;
			dfs(nx, ny, ans + 1);
			vis[nx][ny] = 0;
			str[board[nx][ny] - 'A'] = 0;
		}
		mx = Math.max(mx, ans);
		return mx;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		vis = new int[R][C];
		for (int i = 0; i < R; i++) {
			String str1 = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str1.charAt(j);
			}
		}
		ans = 0;
		vis[0][0] = 1;
		str[board[0][0] - 'A'] = 1;
		ans = dfs(0, 0, 1);
		System.out.println(ans);
	}
}