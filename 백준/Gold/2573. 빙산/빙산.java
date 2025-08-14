import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static int[][] board;
    static int[][] vis;
    static int[][] tmp;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Pair> q = new LinkedList<>();
    static int chkcnt(int x, int y){
        int cnt =0;
        for(int dir=0;dir<4;dir++){
            int nx = dx[dir] + x;
            int ny = dy[dir] + y;
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(board[nx][ny] == 0) {
                cnt += 1;
            }
        }
        return cnt;
    }
    static void bfs(){
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int dir = 0; dir<4;dir++){
                int nx = dx[dir] + p.x;
                int ny = dy[dir] + p.y;
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(vis[nx][ny] != 0 || board[nx][ny] == 0) continue;
                q.add(new Pair(nx,ny));
                vis[nx][ny] = 1;
            }
            tmp[p.x][p.y] = chkcnt(p.x, p.y);
        }
    }
    static void turn(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                board[i][j] -= tmp[i][j];
                if(board[i][j] < 0) board[i][j] = 0;
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        vis = new int[N][M];
        tmp = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
		for(int i=0;i<N;i++){
		    for(int j=0;j<M;j++){
		        if(board[i][j] != 0 && vis[i][j] == 0){
		            q.add(new Pair(i,j));
		            vis[i][j] = 1;
		            bfs();
		            ans += 1;
		        } 
		    }
		}
		turn();
		int chk = 0;
		int flag = 0;
		while(true){
             chk = 0;
		    if(chk > 1) break;
		    vis = new int[N][M];
		    tmp = new int[N][M];
		    q = new LinkedList<>();
    		for(int i=0;i<N;i++){
    		    for(int j=0;j<M;j++){
    		        if(board[i][j] != 0 && vis[i][j] == 0){
    		            q.add(new Pair(i,j));
    		            vis[i][j] = 1;
    		            chk += 1;
    		            if(chk > 1) {flag = 1; break;};
    		            
    		            bfs();
    		        } 
    		    }
                if(flag == 1) break;
    		}
    		if(flag == 1) break;
            if(chk == 0){            
                System.out.println(0);
                return;
            }
    		turn();
    		
    		ans += 1;
    				
		}

		System.out.println(ans);
	}
}