import java.io.*;
import java.util.*;

public class Main
{
    static int N,M,sx,sy;
    static int[][] board;
    static int[][] vis;
    static int[] dx = {-2,-2,-1,-1,1,1,2,2};
    static int[] dy = {-1,1,-2,2,-2,2,-1,1};
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Pair> q = new LinkedList<>();
    static void bfs(int x, int y){
        q = new LinkedList<>();
        vis = new int[N][N];
        q.add(new Pair(x,y));
        vis[x][y] = 1;
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int dir =0;dir<8;dir++){
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(vis[nx][ny] != 0) continue;
                q.add(new Pair(nx,ny));
                vis[nx][ny] = vis[p.x][p.y] + 1;
            }
            
        }
    }
    
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    vis = new int[N][N];
	    board = new int[N][N];
	    st = new StringTokenizer(br.readLine());
	    sx = Integer.parseInt(st.nextToken());
	    sy = Integer.parseInt(st.nextToken());
	    bfs(sx-1,sy-1);
	    for(int i=0;i<M;i++){
	        st = new StringTokenizer(br.readLine());
	        int kx = Integer.parseInt(st.nextToken());
	        int ky = Integer.parseInt(st.nextToken());
            
	        System.out.print(vis[kx-1][ky-1] - 1 + " ");
	    }
	}
}