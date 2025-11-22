import java.util.*;
import java.io.*;

public class Main {
	static class Pair implements Comparable<Pair> {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o2) {
			if (this.y == o2.y) {
				return this.x - o2.x;
			}
			return this.y - o2.y;
		}

	}

	static int r, c, k, rcnt, ccnt;
	static int[][] board = new int[100][100];
	static int[] count = new int[101];

	static int chk, mxchk;
	static ArrayList<Pair> alst;

	static void Rcal() {
		for (int i = 0; i < rcnt; i++) {
			alst = new ArrayList<>();
			count = new int[101];
			for (int j = 0; j < ccnt; j++) {
				int k = board[i][j];
				count[k] += 1;
			}
			for (int j = 1; j < 101; j++) {
				if (count[j] > 0) {
					alst.add(new Pair(j, count[j]));
				}
			}
			Collections.sort(alst);
			int idx = 0;
			for (int j = 0; j < alst.size(); j++) {
				Pair p = alst.get(j);
				if (idx >= 99)
					break;
				board[i][idx++] = p.x;
				board[i][idx++] = p.y;

			}
			ccnt = Math.max(ccnt, idx);
			for (; idx < 100; idx++) {
				board[i][idx] = 0;
			}
		}
	}

	static void Ccal() {
		for (int j = 0; j < ccnt; j++) {
			alst = new ArrayList<>();
			count = new int[101];
			for (int i = 0; i < rcnt; i++) {
				int k = board[i][j];
				count[k] += 1;
			}
			for (int i = 1; i < 101; i++) {
				if (count[i] > 0) {
					alst.add(new Pair(i, count[i]));
				}
			}
			Collections.sort(alst);
			int idx = 0;
			for (int i = 0; i < alst.size(); i++) {
				Pair p = alst.get(i);
				if (idx >= 99)
					break;
				board[idx++][j] = p.x;
				board[idx++][j] = p.y;
			}

			rcnt = Math.max(rcnt, idx);
			for (; idx < 100; idx++) {
				board[idx][j] = 0;
			}
		}
	}

	static int time = 0;

	static int go() {
		while (true) {
			if (board[r][c] == k) {
				return time;
			}
			time += 1;
			if (time >= 101) {
				return -1;
			}
			if (rcnt >= ccnt) {
				Rcal();
			} else {
				Ccal();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		rcnt = 3;
		ccnt = 3;
		System.out.println(go());
	}
}
