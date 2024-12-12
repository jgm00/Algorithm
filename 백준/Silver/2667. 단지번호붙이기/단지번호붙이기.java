import java.io.*;
import java.util.*;

public class Main {

	static int N;

	static int[][] board;
	static int[][] vis;

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

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		vis = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}
		int size = 0;
		int num = 0;
		List<Integer> temp = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1 && vis[i][j] == 0) {
					vis[i][j] = 1;
					Queue<Pair> q = new LinkedList<>();
					q.add(new Pair(i, j));
					num += 1;
					size = 0;
					while (!q.isEmpty()) {
						Pair cur = q.poll();
						size += 1;
						for (int dir = 0; dir < 4; dir++) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];
							if (nx < 0 || ny < 0 || nx >= N || ny >= N)
								continue;
							if (board[nx][ny] != 1 || vis[nx][ny] != 0)
								continue;
							
							vis[nx][ny] = 1;
							q.add(new Pair(nx, ny));
						}
					}
					temp.add(size);
				}
			}
		}
		System.out.println(num);
		Collections.sort(temp);
		for (int i = 0; i < temp.size(); i++) {
			System.out.println(temp.get(i));
		}

	}
}
