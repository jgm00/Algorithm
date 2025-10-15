import java.util.*;
import java.io.*;

public class Main
{
    static int N,M,K;
    static int[][] board;
    static class Pair{
        int x, y, z, t;
        Pair(int x, int y, int z, int t){
            this.x = x;
            this.y = y;
            this.z = z;
            this.t = t;
        }
    }
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][][][] vis;
    static int ans = -1;
    static Queue<Pair> q = new LinkedList<>();
    static void bfs(){
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.x == (N-1) && p.y == (M-1)){
                ans = vis[p.x][p.y][p.z][p.t];
                break;
            }
            for(int dir =0; dir<4; dir++){
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(board[nx][ny] == 0){
                    if(vis[nx][ny][1-p.z][p.t] == 0){
                        vis[nx][ny][1-p.z][p.t] = vis[p.x][p.y][p.z][p.t] + 1;
                        q.add(new Pair(nx,ny,1-p.z,p.t));
                    }
                }else{
                    if(p.z == 0 && p.t < K && vis[nx][ny][1-p.z][p.t+1] == 0){
                        vis[nx][ny][1-p.z][p.t+1] = vis[p.x][p.y][p.z][p.t] + 1;
                        q.add(new Pair(nx,ny,1-p.z,p.t+1));
                    }
                }
            }
            if(vis[p.x][p.y][1-p.z][p.t] == 0){
                vis[p.x][p.y][1-p.z][p.t] = vis[p.x][p.y][p.z][p.t] + 1;
                q.add(new Pair(p.x,p.y,1-p.z,p.t));
            }
        }
    }
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		vis = new int[N][M][2][K+1];
		board = new int[N][M];
		for(int i=0;i<N;i++){
		    String s = br.readLine();
		    for(int j=0;j<M;j++){
		        board[i][j] = s.charAt(j) - '0';
		    }
		}
		vis[0][0][0][0] = 1;
		q.add(new Pair(0,0,0,0));
		bfs();
		System.out.println(ans);
	}
}