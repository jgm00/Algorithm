import java.io.*;
import java.util.*;

public class Main {
	static int N, M, cnt;
	static int max, area;
	static int[][] board;
	static boolean[][] vis;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Queue<Pair> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		vis = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (vis[i][j] == true || board[i][j] == 0)
					continue;
				vis[i][j] = true;
				q.add(new Pair(i, j));

				while (!q.isEmpty()) {
					area++;
					Pair cur = q.poll();
					for (int dir = 0; dir < 4; dir++) {
						int nx = cur.x + dx[dir];
						int ny = cur.y + dy[dir];
						if (nx < 0 || nx >= N || ny < 0 || ny >= M)
							continue;
						if (vis[nx][ny] != false || board[nx][ny] != 1)
							continue;
						vis[nx][ny] = true;
						q.add(new Pair(nx, ny));
					}
				}
				cnt++;
				max = Math.max(max, area);
				area = 0;
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}
}
