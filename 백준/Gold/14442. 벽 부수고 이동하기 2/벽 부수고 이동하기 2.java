import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] board;
	static int[][][] vis;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Triple {
		int x, y, z;

		Triple(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static Queue<Triple> q = new LinkedList<>();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		vis = new int[N][M][K+1];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}
		int flag = 0;
		vis[0][0][0] = 1;
		q.add(new Triple(0, 0, 0));
		while (!q.isEmpty()) {
			Triple cur = q.poll();
			if(cur.x == N-1 && cur.y == M-1) {
				System.out.println(vis[cur.x][cur.y][cur.z]);
				flag = 1;
				break;
			}
			for (int dir = 0; dir < 4; dir++) {
				int nx = dx[dir] + cur.x;
				int ny = dy[dir] + cur.y;
				if(nx<0 || ny<0||nx>=N|| ny>=M) continue;
				if(board[nx][ny] == 0 && vis[nx][ny][cur.z] == 0) {
					vis[nx][ny][cur.z] = vis[cur.x][cur.y][cur.z] + 1;
					q.add(new Triple(nx,ny,cur.z));
				}
				if(board[nx][ny] == 1 &&cur.z <K && vis[nx][ny][cur.z+1] == 0) {
					vis[nx][ny][cur.z+1] = vis[cur.x][cur.y][cur.z] + 1;
					q.add(new Triple(nx,ny,cur.z+1));
				}
			}
		}
		if(flag != 1) {
			System.out.println(-1);
		}
	}
}