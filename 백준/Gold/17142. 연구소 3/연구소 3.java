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

	static int N, M;
	static int[][] board;
	static int[] arr, vis;
	static int[][] dist;
	static ArrayList<Pair> alst = new ArrayList<>();
	static Queue<Pair> q;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void bfs() {
		dist = new int[N][N];
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], -1);
		}
		for (int i = 0; i < arr.length; i++) {
			Pair pp = alst.get(arr[i]);
			q.add(new Pair(pp.x, pp.y));
			dist[pp.x][pp.y] = 0;
		}
		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = dx[dir] + p.x;
				int ny = dy[dir] + p.y;
				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if (board[nx][ny] == 1 || dist[nx][ny] != -1)
					continue;
				q.add(new Pair(nx, ny));
				dist[nx][ny] = dist[p.x][p.y] + 1;
			}
		}
	}

	static int answer = Integer.MAX_VALUE;

	static void test() {
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {
					if (dist[i][j] == -1) {
						return;
					}
					ans = Math.max(ans, dist[i][j]);
				}
			}
		}
		answer = Math.min(answer, ans);
	}

	static void dfs(int k, int st) {
		if (k == M) {
			bfs();
			test();
			return;
		}
		for (int i = st; i < alst.size(); i++) {
			if (vis[i] == 1)
				continue;
			arr[k] = i;
			vis[i] = 1;
			dfs(k + 1, i + 1);
			vis[i] = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) {
					alst.add(new Pair(i, j));
				}
			}
		}
		vis = new int[alst.size()];
		arr = new int[M];
		dfs(0, 0);
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}
}
