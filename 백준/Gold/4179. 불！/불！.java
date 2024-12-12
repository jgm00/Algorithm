import java.io.*;
import java.util.*;

public class Main {

	static char[][] board;
	static int[][] visF;
	static int[][] visJ;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Queue<Pair> qF = new LinkedList<>();
	static Queue<Pair> qJ = new LinkedList<>();
	static int N;
	static int M;

	static int bfs() {
		while (!qJ.isEmpty()) {
			Pair cur = qJ.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					return visJ[cur.x][cur.y] + 1;
				}
				if (board[nx][ny] != '.' || visJ[nx][ny] != -1 || (visF[nx][ny] != -1 && visF[nx][ny] <= visJ[cur.x][cur.y] + 1))
					continue;
				visJ[nx][ny] = visJ[cur.x][cur.y] + 1;
				qJ.add(new Pair(nx, ny));
			}
		}
		return -1;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		visJ = new int[N][M];
		visF = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(visJ[i], -1);
		}
		for (int i = 0; i < N; i++) {
			Arrays.fill(visF[i], -1);
		}
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j);
				if (board[i][j] == 'J') {
					visJ[i][j] = 0;
					qJ.add(new Pair(i, j));
				}
				if (board[i][j] == 'F') {
					visF[i][j] = 0;
					qF.add(new Pair(i, j));
				}
			}
		}
		while (!qF.isEmpty()) {
			Pair cur = qF.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (board[nx][ny] == '#' || visF[nx][ny] != -1)
					continue;
				visF[nx][ny] = visF[cur.x][cur.y] + 1;
				qF.add(new Pair(nx, ny));
			}
		}
		int ans = bfs();
		if (ans == -1) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(ans);
		}
	}
}
