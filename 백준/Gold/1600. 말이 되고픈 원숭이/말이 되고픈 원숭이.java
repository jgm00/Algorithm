import java.io.*;
import java.util.*;

public class Main {
	static int K, W, H;
	static int[][] board;
	static int[][][] vis;

	static class Triple {
		int x, y, z;

		Triple(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int[] dx1 = { 1, 0, -1, 0 };
	static int[] dy1 = { 0, 1, 0, -1 };
	static int[] dx2 = { 1, 1, -1, -1, -2, -2, 2, 2 };
	static int[] dy2 = { 2, -2, 2, -2, 1, -1, 1, -1 };
	static Queue<Triple> q = new LinkedList<>();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		board = new int[W][H];
		vis = new int[W][H][K + 1];
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < H; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				Arrays.fill(vis[i][j], -1);
			}
		}
		vis[0][0][0] = 0;
		q.add(new Triple(0, 0, 0));
		while (!q.isEmpty()) {
			Triple cur = q.poll();
			if (cur.x == W - 1 && cur.y == H - 1) {
				System.out.println(vis[cur.x][cur.y][cur.z]);
				return;
			}
			for (int dir = 0; dir < 4; dir++) {
				int nx = dx1[dir] + cur.x;
				int ny = dy1[dir] + cur.y;
				if (nx < 0 || ny < 0 || nx >= W || ny >= H)
					continue;
				if (board[nx][ny] == 0 && vis[nx][ny][cur.z] == -1) {
					vis[nx][ny][cur.z] = 1+ vis[cur.x][cur.y][cur.z];
					q.add(new Triple(nx, ny, cur.z));
				}
			}
			if (cur.z < K) {
				for (int dir = 0; dir < 8; dir++) {
					int nx = dx2[dir] + cur.x;
					int ny = dy2[dir] + cur.y;
					if (nx < 0 || ny < 0 || nx >= W || ny >= H)
						continue;
					if (board[nx][ny] == 0 && vis[nx][ny][cur.z + 1] == -1) {
						vis[nx][ny][cur.z + 1] = 1 + vis[cur.x][cur.y][cur.z];
						q.add(new Triple(nx, ny, cur.z + 1));
					}
				}
			}
		}
			System.out.println(-1);
	}
}