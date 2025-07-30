import java.io.*;
import java.util.*;

public class Main
{
    static int N,M;
    static int[][] board;
    static int[][] vis;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        vis = new int[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                board[i][j] = s.charAt(j) - '0';
            }
        }
        vis[0][0] = 1;
        q.add(0); q.add(0);
        while(!q.isEmpty()){
            int curx = q.poll();
            int cury = q.poll();
            for(int dir =0;dir<4;dir++){
                int nx = curx + dx[dir];
                int ny = cury + dy[dir];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(board[nx][ny] == 0 || vis[nx][ny] != 0) continue;
                q.add(nx); q.add(ny);
                vis[nx][ny] = vis[curx][cury] + 1;
            }
        }
        System.out.println(vis[N-1][M-1]);
        
	}
}