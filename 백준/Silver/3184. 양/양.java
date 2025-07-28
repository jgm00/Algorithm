import java.io.*;
import java.util.*;

public class Main
{
    static int R,C;
    static char[][] board;
    static int[][] vis;
    static int snum = 0;
    static int wnum = 0;
    static int sans = 0;
    static int wans = 0;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static void dfs(int x, int y){
        vis[x][y] = 1;
        for(int dir =0;dir<4;dir++){
            int nx = dx[dir] + x;
            int ny = dy[dir] + y;
            if(nx < 0 || ny < 0 || nx >=R || ny >= C) continue;
            if(board[nx][ny] == '#' || vis[nx][ny] == 1) continue;
            if(board[nx][ny] == 'v'){
                wnum += 1;
            }else if(board[nx][ny] == 'o'){
                snum += 1;
            }
            dfs(nx,ny);
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        vis = new int[R][C];
        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                board[i][j] = s.charAt(j);
            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if((board[i][j] == 'v' || board[i][j] == 'o') && vis[i][j] == 0) {
                            if(board[i][j] == 'v'){
            wnum += 1;
        }else{
            snum +=1;
        }
                    dfs(i,j);
                    if(snum <= wnum){
                        wans += wnum;
                    }else{
                        sans += snum;
                    }
                    snum =0; wnum = 0;
                }
            }
        }
        System.out.println(sans + " " + wans);
	}
}