import java.util.*;
import java.io.*;


public class Main
{   
    static int N,M;
	static char[][] board;
    static int mx = Integer.MIN_VALUE;
	static int[][] vis;
	static class Pair{
	    int x,y;
	    Pair(int x, int y){
	        this.x = x;
	        this.y = y;
	    }
	}
	
	static Queue<Pair> q = new LinkedList<>();
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static void bfs(int x, int y){
	    vis[x][y] = 1;
	    q.add(new Pair(x,y));
	    while(!q.isEmpty()){
	        Pair cur = q.poll();
	        for(int dir = 0;dir<4;dir++){
	            int nx = dx[dir] + cur.x;
	            int ny = dy[dir] + cur.y;
	            if(nx<0 || ny < 0|| nx>=N || ny>=M) continue;
	            if(board[nx][ny] == 'W' || vis[nx][ny] != 0) continue;
	            vis[nx][ny] = 1+vis[cur.x][cur.y];
	            mx = Math.max(vis[nx][ny],mx);
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
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                char c = str.charAt(j);
                board[i][j] = c;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j] == 'L'){
                    vis = new int[N][M];
                    bfs(i,j);
                }
            }
        }
        System.out.println(mx-1);
	}
}