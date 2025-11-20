import java.util.*;
import java.io.*;

public class Main {
	static class Pair {
		int x, y, z, t;

		Pair(int x, int y, int z, int t) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.t = t;
		}
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, G, R, all, ans;
	static int[][] board, tmpboard;
	static int[] GG, RR;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<Pair> alst = new ArrayList<>();
	static Queue<Pair> q = new LinkedList<>();
	static int[][] time = new int[N][M];
	static int[][] color;
	static int flower = 0;

	static void bfs() {
		flower = 0;
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int curx = cur.x;
			int cury = cur.y;
			int curcol = cur.z;
			int curt = cur.t;
			if (color[curx][cury] == 3)
				continue;
			for (int dir = 0; dir < 4; dir++) {
				int nx = dx[dir] + curx;
				int ny = dy[dir] + cury;
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (board[nx][ny] == 0)
					continue;
				if (time[nx][ny] == -1) {
					time[nx][ny] = curt + 1;
					color[nx][ny] = curcol;
					q.add(new Pair(nx, ny, curcol, curt + 1));
				} else {
					if (time[nx][ny] == (curt + 1) && color[nx][ny] != curcol && color[nx][ny] != 3) {
						color[nx][ny] = 3;
						flower += 1;
					}
				}
			}
		}
	}

	static void dfs(int k, int rR, int rG, int sts) {
		if (k == all) {
			if (rR != R || rG != G) return;
			time = new int[N][M];
			color = new int[N][M];
			q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				Arrays.fill(time[i], -1);
			}
			for (int i = 0; i < rR; i++) {
				Pair p = alst.get(RR[i]);
				color[p.x][p.y] = 2;
				time[p.x][p.y] = 0;
				q.add(new Pair(p.x, p.y, 2, 0));
			}
			for (int i = 0; i < rG; i++) {
				Pair p = alst.get(GG[i]);
				color[p.x][p.y] = 1;
				time[p.x][p.y] = 0;
				q.add(new Pair(p.x, p.y, 1, 0));
			}
			bfs();
			ans = Math.max(ans, flower);
			return;
		}
		for (int i = sts; i < alst.size(); i++) {
			if (rR < R) {
				RR[rR] = i;
				dfs(k + 1, rR + 1, rG, i + 1);
			}
			if (rG < G) {
				GG[rG] = i;
				dfs(k + 1, rR, rG + 1, i + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		all = G + R;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) {
					alst.add(new Pair(i, j));
				}
			}
		}
		RR = new int[R];
		GG = new int[G];
		dfs(0, 0, 0, 0);
		System.out.println(ans);
	}
}
