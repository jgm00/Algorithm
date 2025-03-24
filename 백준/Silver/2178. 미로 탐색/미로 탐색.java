import java.util.*;
import java.io.*;

public class Main {
	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int board[][];
	static int visited[][];
	static int N, M;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static Queue<Pair> q = new LinkedList<>();

	static void bfs() {
		int curx = 0;
		int cury = 0;
		visited[curx][cury] = 1;
		q.add(new Pair(curx, cury));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			curx = p.x;
			cury = p.y;
			for (int dir = 0; dir < 4; dir++) {
				int nx = dx[dir] + curx;
				int ny = dy[dir] + cury;
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (board[nx][ny] == 0 || visited[nx][ny] != 0)
					continue;
				visited[nx][ny] = visited[curx][cury] + 1;
				q.add(new Pair(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}
		bfs();
		System.out.println(visited[N - 1][M - 1]);
	}
}