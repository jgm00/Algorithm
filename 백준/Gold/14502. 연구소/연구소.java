import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static int mx = Integer.MIN_VALUE;
    static int[][] board,vis;
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
    static void bfs(){
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int dir = 0; dir<4; dir++){
                int nx = dx[dir] + p.x;
                int ny = dy[dir] + p.y;
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(board[nx][ny] != 0 || vis[nx][ny] == 1) continue;
                vis[nx][ny] = 1;
                q.add(new Pair(nx,ny));
            }
        }
    }
    static int chk(){
        int ret = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j] == 0 && vis[i][j] == 0){
                    ret += 1;
                }
            }
        }
        return ret;
    }
    static void dfs(int st, int k){
        if(k == 3){
            q = new LinkedList<>();
            vis = new int[N][M];
            for(Pair p : alist){
                vis[p.x][p.y] = 1;
                q.add(new Pair(p.x,p.y));
            }
            bfs();
            mx = Math.max(chk() , mx);
            return;
        }
        for(int i=st;i<N*M;i++){
                int nx = i/M; int ny = i%M;
                if(board[nx][ny] != 0) continue;
                board[nx][ny] = 1;
                dfs(i+1, k+1);
                board[nx][ny] = 0;
        }
    }
    static ArrayList<Pair> alist = new ArrayList<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        vis = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2){
                    alist.add(new Pair(i,j));
                }
            }
        }
        dfs(0,0);
        System.out.println(mx);
	}
}