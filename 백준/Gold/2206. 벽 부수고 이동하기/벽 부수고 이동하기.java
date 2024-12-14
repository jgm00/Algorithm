import java.util.*;
import java.io.*;

public class Main {

	static class Pair {
		int x, y, z;

		Pair(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int[][] board;
	static int[][][] dist;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<Pair> q;
	static int N;
	static int M;

	static int bfs() {
		dist[0][0][0] = 0;
		dist[0][0][1] = 0;
		q = new LinkedList<>();
		q.add(new Pair(0, 0, 0));
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int broken = cur.z;
			if (cur.x == N - 1 && cur.y == M - 1)
				return dist[cur.x][cur.y][broken] + 1;
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (dist[nx][ny][broken] == -1 && board[nx][ny] == 0) {

					dist[nx][ny][broken] = dist[cur.x][cur.y][broken] + 1;
					q.add(new Pair(nx, ny, broken));
				}
				if (broken == 0 && dist[nx][ny][1] == -1 && board[nx][ny] == 1) {
					dist[nx][ny][1] = dist[cur.x][cur.y][broken] + 1;
					q.add(new Pair(nx, ny, 1));
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		dist = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				dist[i][j][1] = -1;
				dist[i][j][0] = -1;
				board[i][j] = s.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
	}
}
