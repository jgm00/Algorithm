import java.io.*;
import java.util.*;

public class Main
{
    static int w = -1;
    static int h = -1;
    static int[][] board;
    static int[][] vis;
    static int[] dx = {1,0,-1,0,-1,-1,1,1};
    static int[] dy = {0,1,0,-1,-1,1,-1,1};
    static void dfs(int x, int y){
        vis[x][y] = 1;
        for(int dir =0;dir<8;dir++){
            int nx = dx[dir] + x;
            int ny = dy[dir] + y;
            if(nx < 0 || ny < 0 || nx >=w || ny >= h) continue;
            if(board[nx][ny] == 0 || vis[nx][ny] == 1) continue;
            dfs(nx,ny);
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            if(h == 0 && w == 0) break;
            board = new int[w][h];
            vis = new int[w][h];
            for(int i=0;i<w;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<h;j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for(int i=0;i<w;i++){
                for(int j=0;j<h;j++){
                    if(board[i][j] == 1 && vis[i][j] == 0){
                    dfs(i,j);
                    cnt += 1;}
                }
            }
            System.out.println(cnt);
        }
	}
}