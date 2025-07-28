import java.io.*;
import java.util.*;

public class Main
{
    static int T,M,N,K;
    static int[][] board;
    static int[][] vis;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static void dfs(int x, int y){
        vis[x][y] = 1;
        for(int dir = 0; dir<4; dir++){
            int nx = dx[dir] + x;
            int ny = dy[dir] + y;
            if(nx < 0 || ny < 0 || nx >=N || ny >= M) continue;
            if(board[nx][ny] == 0 || vis[nx][ny] == 1) continue;
            dfs(nx,ny);
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        vis = new int[N][M];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            board[x][y] = 1;
        }
        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j =0;j<M; j++){
                if(board[i][j] == 1 && vis[i][j] == 0){
                    dfs(i,j);
                    ans+=1;
                }
            }
        }
        System.out.println(ans);
        }
	}
}