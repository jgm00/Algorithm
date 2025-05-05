import java.util.*;
import java.io.*;

public class Main {
	static int N, L, R;
	static int[][] board;
	static int[][] vis;
	static ArrayList<Pair> inlist;

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<ArrayList<Pair>> alist;

	static void dfs(int x1, int y1) {
		for (int dir = 0; dir < 4; dir++) {
			int nx = dx[dir] + x1;
			int ny = dy[dir] + y1;
			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			if (vis[nx][ny] != 0)
				continue;
			int diff = Math.abs(board[nx][ny] - board[x1][y1]);
			if (L <= diff && diff <= R) {
				vis[nx][ny] = 1;
				dfs(nx, ny);
				inlist.add(new Pair(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		vis = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		alist = new ArrayList<>();
		int ans = 0;
		while (true) {
			if (alist.size() == N * N)
				break;
			alist = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				Arrays.fill(vis[i], 0);
			}
			ans += 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (vis[i][j] != 0)
						continue;
					inlist = new ArrayList<>();
					vis[i][j] = 1;
					inlist.add(new Pair(i, j));
					dfs(i, j);
					alist.add(inlist);
				}
			}
			for (int i = 0; i < alist.size(); i++) {
				ArrayList<Pair> tlist = alist.get(i);
				int sum1 = 0;
				for (int j = 0; j < tlist.size(); j++) {
					sum1 += board[tlist.get(j).x][tlist.get(j).y];
				}
				int kt = sum1 / tlist.size();
				for (int j = 0; j < tlist.size(); j++) {
					board[tlist.get(j).x][tlist.get(j).y] = kt;
				}
			}
		}
		System.out.println(ans - 1);
	}
}