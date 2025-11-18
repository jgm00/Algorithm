import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static char[][] board;
	static int[][] vis;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int mn = Integer.MIN_VALUE;
	static Queue<Pair> q = new LinkedList<>();
	static void bfs() {
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int dir=0;dir<4;dir++) {
				int nx = dx[dir] + p.x;
				int ny = dy[dir] + p.y;
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(board[nx][ny] == 'W' || vis[nx][ny] != 0) continue;
				vis[nx][ny] = vis[p.x][p.y] + 1;
				mn = Math.max(vis[nx][ny], mn);
				q.add(new Pair(nx,ny));
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		vis = new int[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j] = str.charAt(j);
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				vis = new int[N][M];
				q = new LinkedList<>();
				if(board[i][j] == 'L') {
					if(vis[i][j] != 0) continue;
					vis[i][j] = 1; 
					q.add(new Pair(i,j));
					bfs();	
				}
			}
		}
		System.out.println(mn-1);
	}
}
