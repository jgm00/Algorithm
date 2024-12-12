import java.io.*;
import java.util.*;

public class Main {
	static int L, R, C;
	static char[][][] board;
	static int[][][] vis;
	static int[] dx = {1,0,-1,0,0,0};
	static int[] dy = {0,1,0,-1,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	static int x,y,z;
	static int tarx, tary, tarz;
	static class Triple{
		int x,y,z;
		Triple(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static void bfs() {
		Queue<Triple> q = new LinkedList<>();
		vis[z][x][y] = 1;
		q.add(new Triple(z,x,y));
		while(!q.isEmpty()){
			Triple cur = q.poll();
			if(cur.x==tarz && cur.y == tarx && cur.z == tary) {
				System.out.println("Escaped in "+(vis[cur.x][cur.y][cur.z] - 1)+" minute(s).");
				return;
			}
			for(int dir=0;dir<6;dir++) {
				int nz = cur.x + dz[dir];
				int nx = cur.y + dx[dir];
				int ny = cur.z + dy[dir];
				if(nx<0 || ny<0|| nz<0 || nz>=L|| nx>=R||ny>=C) continue;
				if(board[nz][nx][ny] == '#' || vis[nz][nx][ny] != 0) continue;
				vis[nz][nx][ny] = 1 + vis[cur.x][cur.y][cur.z];
				q.add(new Triple(nz,nx,ny));
			}
		}
		System.out.println("Trapped!");
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = -1;
		R = -1;
		C = -1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (L == 0 && R == 0 && C == 0)
				break;
			board = new char[L][R][C];
			vis = new int[L][R][C];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String s = br.readLine();
					for (int k = 0; k < C; k++) {
						board[i][j][k] = s.charAt(k);
						if(board[i][j][k]=='S') {
							z = i;
							x = j;
							y = k;
						}
						if(board[i][j][k] == 'E') {
							tarz = i;
							tarx = j;
							tary = k;
							
						}
					}
				}
				String empty = br.readLine();
			}
            bfs();
		}
	}
}
