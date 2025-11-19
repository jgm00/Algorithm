import java.util.*;
import java.io.*;

public class Main {
	static int R, C, T;

	static class Pair {
		int x, y, z;

		Pair(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int[][] board;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx1 = { -1, 0, 1, 0 };
	static int[] dy1 = { 0, 1, 0, -1 };
	static int[] dx2 = { 1, 0, -1, 0 };
	static int[] dy2 = { 0, 1, 0, -1 };
	static int x1, y1, x2, y2;
	static Queue<Pair> q;

	static void pushq() {
		q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] > 0) {
					q.add(new Pair(i, j, board[i][j]));
					board[i][j] = 0;
				}
			}
		}
	}

	static void diffusion() {
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int tmp = cur.z/5; int cnt = 0;
			for(int dir = 0; dir<4; dir++) {
				int nx = dx[dir] + cur.x;
				int ny = dy[dir] + cur.y;
				if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
				if(board[nx][ny] == -1) continue;
				board[nx][ny] += tmp;
				cnt += 1;
			}
			board[cur.x][cur.y] += cur.z - (tmp*cnt);
		}
	}

	static void rotat() {
		int dir = 0;
		int curx = x1;
		int cury = y1;
		while (true) {
			int nx = dx1[dir] + curx;
			int ny = dy1[dir] + cury;
			if (nx < 0 || ny < 0 || nx > x1 || ny >= C) {
				dir += 1;
				if (dir == 4) {
					break;
				}
				continue;
			}
			int prevx = curx;
			int prevy = cury;
			curx = nx;
			cury = ny;
			if((prevx == x1 && prevy == y1) || (curx == x1 && cury == y1))  continue;
			board[prevx][prevy] = board[curx][cury];
		}
		board[x1][y1+1] = 0;
	}

	static void rotat2() {
		int dir = 0;
		int curx = x2;
		int cury = y2;
		while (true) {
			int nx = dx2[dir] + curx;
			int ny = dy2[dir] + cury;
			if (nx < x2 || ny < 0 || nx >= R || ny >= C) {
				dir += 1;
				if (dir == 4) {
					break;
				}
				continue;
			}
			int prevx = curx;
			int prevy = cury;
			curx = nx;
			cury = ny;
			if((prevx == x2 && prevy == y2) || (curx == x2 && cury == y2) )  continue;
			board[prevx][prevy] = board[curx][cury];
		}
		board[x2][y2+1] = 0;
	}
	static int ans = 0;
	static void cal() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if((i==x1 && j == y1) || (i==x2 && j == y2) ) continue;
					ans += board[i][j];
			}
		}
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		int chk = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == -1) {
					if (chk != 1) {
						x1 = i;
						y1 = j;
						chk = 1;
					} else {
						x2 = i;
						y2 = j;
					}
				}
			}
		}
		while(T --> 0) {
			pushq();
			diffusion();
			rotat();
			rotat2();	
		}
		cal();
		System.out.println(ans);
	}
}
