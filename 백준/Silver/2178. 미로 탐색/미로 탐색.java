import java.util.*;
import java.io.*;

public class Main {

	static int[][] board;
	static int[][] dist;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Queue<Pair> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], -1);
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				int k = s.charAt(j) - '0';
				board[i][j] = k;
			}
		}
		dist[0][0] = 0;
		q.add(new Pair(0, 0));

		while (!q.isEmpty()) {
			Pair cur = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (dist[nx][ny] != -1 || board[nx][ny] != 1)
					continue;

				dist[nx][ny] = dist[cur.x][cur.y] + 1;
				q.add(new Pair(nx, ny));
			}

		}
		System.out.println(dist[N-1][M-1] + 1);
	}
}
