import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] board;
	static int[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int mx = Integer.MIN_VALUE;
	static int mn = Integer.MAX_VALUE;
	static int ans = Integer.MIN_VALUE;

	static void dfs(int di, int dj, int K) {
		for (int dir = 0; dir < 4; dir++) {
			int nx = dx[dir] + di;
			int ny = dy[dir] + dj;
			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			if (board[nx][ny] <= K || visited[nx][ny] == 1)
				continue;
			visited[nx][ny] = 1;
			dfs(nx, ny, K);
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		visited = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				mx = Math.max(mx, board[i][j]);
				mn = Math.min(mn, board[i][j]);
			}
		}
		for (int k = mn-1; k <= mx+1; k++) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] != 1 && board[i][j] > k) {
						visited[i][j] = 1;
						dfs(i, j, k);
						cnt += 1;
					}
				}
			}
			ans = Math.max(cnt, ans);
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], 0);
			}
		}
		System.out.println(ans);
	}
}