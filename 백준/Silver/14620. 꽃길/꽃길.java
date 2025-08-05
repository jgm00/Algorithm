import java.util.*;
import java.io.*;

public class Main
{
    static int[][] vis;
    static int ret = Integer.MAX_VALUE;
    static int[][] board;
    static int N;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean check(int stx, int sty){
        if(vis[stx][sty] == 1) return false;
        for(int dir =0;dir<4;dir++){
            int nx = dx[dir] + stx;
            int ny = dy[dir] + sty;
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) return false;
            if(vis[nx][ny] == 1) return false;
        }
        return true;
    }
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Pair> lst = new ArrayList<>();
    static int cal(int x, int y){
        int sum = board[x][y];
        vis[x][y] = 1;
        for(int dir =0;dir<4;dir++){
            int nx = dx[dir] + x;
            int ny = dy[dir] + y;
            sum += board[nx][ny];
            vis[nx][ny] = 1;
        }
        return sum;
    }
    static void erase(int x, int y){
        vis[x][y] = 0;
        for(int dir =0;dir<4;dir++){
            int nx = dx[dir] + x;
            int ny = dy[dir] + y;
            vis[nx][ny] = 0;
        }
    }
    static void go(int k, int sum){
        if(k==3){
            ret = Math.min(ret,sum);
            return;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(check(i,j)){
                    go(k+1,sum+cal(i,j));
                    erase(i,j);
                }
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
		        lst.add(new Pair(i,j));
		    }
		}
		int chk = 0;
		int sz = lst.size();
        go(0,0);
		System.out.println(ret);
	}
}