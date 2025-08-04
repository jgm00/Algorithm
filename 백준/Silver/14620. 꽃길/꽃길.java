import java.util.*;
import java.io.*;

public class Main
{
    static int[][] vis;
    static int[][] board;
    static int N;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean check(int stx, int sty){
        vis[stx][sty] = 1;
        for(int dir =0;dir<4;dir++){
            int nx = dx[dir] + stx;
            int ny = dy[dir] + sty;
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) return false;
            if(vis[nx][ny] == 1) return false;
            vis[nx][ny] = 1;
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
        for(int dir =0;dir<4;dir++){
            int nx = dx[dir] + x;
            int ny = dy[dir] + y;
            sum += board[nx][ny];
        }
        return sum;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for(int i=0;i<N;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int j=0;j<N;j++){
		        board[i][j] = Integer.parseInt(st.nextToken());
		        lst.add(new Pair(i,j));
		    }
		}
		int chk = 0;
		int sz = lst.size();
		int mn = Integer.MAX_VALUE;
		for(int i=0;i<sz;i++){
		    for(int j=i+1;j<sz;j++){
		        for(int k=j+1;k<sz;k++){
		            chk = 0;
		            Pair i1 = lst.get(i);
		            Pair i2 = lst.get(j);
		            Pair i3 = lst.get(k);
		            vis = new int[N][N];
		            if(check(i1.x, i1.y) == false){
		                chk = 1;
		            }
		            if(check(i2.x, i2.y) == false){
		                chk = 1;
		            }
		            if(check(i3.x, i3.y) == false){
		                chk = 1;
		            }
		            if(chk == 0){
		                int ss = cal(i1.x,i1.y)+cal(i2.x,i2.y)+cal(i3.x,i3.y);
		                mn = Math.min(ss,mn);
		            }
		        }
		    }}
		System.out.println(mn);
	}
}