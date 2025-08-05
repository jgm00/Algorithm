import java.util.*;
import java.io.*;

public class Main
{
    static int R,C,K;
    static char[][] board;
    static int[][] vis;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int ans = 0;
    static void dfs(int x, int y, int cnt){
        if(x == 0 && y == (C-1)){
            if(cnt == K){
                ans +=1;
            }
            return;
        }
        vis[x][y] = 1;
        for(int dir =0;dir<4;dir++){
            int nx = dx[dir] + x;
            int ny = dy[dir] + y;
            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if(board[nx][ny] == 'T' || vis[nx][ny] == 1) continue;
            dfs(nx,ny,cnt+1);
            vis[nx][ny] = 0;
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        vis = new int[R][C];
        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                board[i][j] = s.charAt(j);
            }
        }
        dfs(R-1,0,1);
        System.out.println(ans);
	}
}