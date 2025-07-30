import java.io.*;
import java.util.*;

public class Main
{
    static int M,N,H;
    static int[][][] board;
    static int[][][] vis;
    static int[] dx = {1,0,-1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dh = {0,0,0,0,1,-1};

    static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new int[H][N][M];
        vis = new int[H][N][M];
        for(int k = 0;k<H;k++){
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    board[k][i][j] = Integer.parseInt(st.nextToken());
                    if(board[k][i][j] == 1){
                        q.add(k); q.add(i); q.add(j);
                        vis[k][i][j] = 1;
                    }
                }
            }
        }
        while(!q.isEmpty()){
            int curh = q.poll();
            int curx = q.poll();
            int cury = q.poll();
            for(int dir =0; dir<6;dir++){
                int nx = dx[dir] + curx;
                int ny = dy[dir] + cury;
                int nh = dh[dir] + curh;
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || nh < 0 || nh >= H) continue;
                if(board[nh][nx][ny] != 0 || vis[nh][nx][ny] != 0) continue;
                q.add(nh); q.add(nx); q.add(ny);
                vis[nh][nx][ny] = vis[curh][curx][cury] + 1;
            }
        }
        int ans =0;
        int check = 0;
        for(int k = 0;k<H;k++){
        for(int i=0;i<N;i++){
            for(int j=0;j<M; j++){
                if(vis[k][i][j] == 0 && board[k][i][j] != -1) {check = 1;}
                ans = Math.max(vis[k][i][j],ans);
            }
        }
        if(check == 1){
        ans = 0;}
            
        }
        System.out.println(ans-1);
	}
}