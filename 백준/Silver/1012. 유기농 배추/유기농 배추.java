import java.util.*;
import java.io.*;

public class Main {
	static int T;
	static int[][] board;
	static int[][] visited;
	static int M, N, K;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int ans;

	static void dfs(int di, int dj) {
		for (int dir = 0; dir < 4; dir++) {
			int nx = dx[dir] + di;
			int ny = dy[dir] + dj;
			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			if (board[nx][ny] == 0 || visited[nx][ny] == 1)
				continue;
			visited[nx][ny] = 1;
			dfs(nx, ny);
		}
        return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new int[N][M];
			visited = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				board[x][y] = 1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] == 1 && visited[i][j] == 0) {
						dfs(i, j);
						ans += 1;
					}
				}
			}
			System.out.println(ans);
		}
	}
}