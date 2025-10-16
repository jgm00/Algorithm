import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int[][] board;
    static int[][] vis, dist;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static void dfs(int curx, int cury, int k){
        board[curx][cury] = k;
        for(int dir = 0; dir < 4; dir++){
            int nx = curx + dx[dir];
            int ny = cury + dy[dir];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(vis[nx][ny] != 0 || board[nx][ny] == 0) continue;
                vis[nx][ny] = 1;
                board[nx][ny] = k;
                dfs(nx,ny,k);
        }
    }
    
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int ans = Integer.MAX_VALUE;
    static Queue<Pair> q = new LinkedList<>();
    static void bfs(int curc){
        while(!q.isEmpty()){
            Pair cur = q.poll();
            if(board[cur.x][cur.y] != 0 && board[cur.x][cur.y] != curc){
                ans = Math.min(ans,(dist[cur.x][cur.y]));
                return;
            }
            for(int dir = 0; dir < 4; dir++){
                int nx = dx[dir] + cur.x;
                int ny = dy[dir] + cur.y;
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(dist[nx][ny] >= 2) continue;
                if(board[nx][ny] == curc) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.add(new Pair(nx,ny));
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		vis = new int[N][N];
		for(int i=0;i<N;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int j=0;j<N;j++){
		        board[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		int ks = 2;
		for(int i=0;i<N;i++){
		    for(int j=0;j<N;j++){
		        if(board[i][j] == 0 || vis[i][j] == 1) continue;
		        dfs(i,j,ks);
		        ks+=1;
		    }
		}
		dist = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int tmpc = board[i][j];
                if(tmpc != 0){
                    q = new LinkedList<>();
                    dist = new int[N][N];
                    dist[i][j] = 1;
                    q.add(new Pair(i,j));
                    bfs(tmpc);
                }
            }
        }
  
        System.out.println(ans-2);
	}
}