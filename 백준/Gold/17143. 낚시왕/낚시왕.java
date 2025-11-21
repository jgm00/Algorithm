import java.util.*;
import java.io.*;

public class Main {
	static int R, C, M;
	static int ans = 0;

	static class Pair {
		int x, y, z, r, c;

		Pair(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		Pair(int r, int c, int x, int y, int z) {
			this.r = r;
			this.c = c;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static Pair[][] board, tmpboard;
	static int[][] vis;
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };
	static Queue<Pair> q = new LinkedList<>();

	static void copy() {
		q = new LinkedList<>();
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (tmpboard[i][j] != null) {
					Pair p = tmpboard[i][j];
					q.add(new Pair(i, j, p.x, p.y, p.z));
				}
			}
		}
	}

	static void catchs(int k) {
		for (int i = 1; i <= R; i++) {
			if (tmpboard[i][k] != null) {
				ans += tmpboard[i][k].z;
				tmpboard[i][k] = null;
				break;
			}
		}
	}

	static void move() {
		tmpboard = new Pair[R + 1][C + 1];
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int cycle = 0;
			int s = p.x;
			if (p.y == 1 || p.y == 2) {
				cycle = 2 * (R - 1);
				if (cycle != 0) {
					s %= cycle;
				}
			} else {
				cycle = 2 * (C - 1);
				if (cycle != 0) {
					s %= cycle;
				}
			}
			while (s-- > 0) {
				int nx = p.r + dx[p.y];
				int ny = p.c + dy[p.y];
				if (nx < 1 || nx > R || ny < 1 || ny > C) {
					if (p.y == 1 || p.y == 2) {
						p.y = 3 - p.y;
					}
					if (p.y == 3 || p.y == 4) {
						p.y = 7 - p.y;
					}
					nx = p.r + dx[p.y];
					ny = p.c + dy[p.y];
				}
				p.r = nx;
				p.c = ny;

			}
			if (tmpboard[p.r][p.c] != null) {
				int now = tmpboard[p.r][p.c].z;
				if (now < p.z) {
					tmpboard[p.r][p.c] = new Pair(p.x, p.y, p.z);
				}
			} else {
				tmpboard[p.r][p.c] = new Pair(p.x, p.y, p.z);
			}
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		board = new Pair[R + 1][C + 1];
		vis = new int[R + 1][C + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			board[r][c] = new Pair(s, d, z);
		}
		tmpboard = new Pair[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (board[i][j] != null) {
					tmpboard[i][j] = board[i][j];
				}
			}
		}
		for (int k = 1; k <= C; k++) {
			catchs(k);
			copy();
			move();
		}
		System.out.println(ans);
	}
}
