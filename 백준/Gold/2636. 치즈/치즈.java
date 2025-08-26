import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static int[][] vis,board,chk;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Pair> alist = new ArrayList<>();
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Pair> q = new LinkedList<>();
    static void chkf(){
        q.add(new Pair(0,0));
        chk[0][0] = 1;
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int dir = 0; dir<4; dir++){
                int nx = dx[dir] + p.x;
                int ny = dy[dir] + p.y;
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(board[nx][ny] != 0 || chk[nx][ny] == 1) continue;
                chk[nx][ny] = 1;
                q.add(new Pair(nx,ny));
            }
        }
    }
    static boolean fin(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j] != 0) return false;
            }
        }
        return true;
    }
    static void bfs(){
        while(!q.isEmpty()){
            int ist = 0;
            Pair p = q.poll();
            for(int k=0;k<4;k++){
                int nnx = dx[k] + p.x;
                int nny = dy[k] + p.y;
                if(nnx < 0 || nny < 0 || nnx >= N || nny >= M) continue;
                if(chk[nnx][nny] == 1){
                    ist = 1;
                }
            }
            if(ist == 1){
                alist.add(new Pair(p.x,p.y));
            }
            for(int dir = 0; dir<4;dir++){
                int nx = dx[dir] + p.x;
                int ny = dy[dir] + p.y;
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(board[nx][ny] != 1 || vis[nx][ny] == 1) continue;
                vis[nx][ny] = 1;
                q.add(new Pair(nx,ny));
            }
        }
    }
    static void go(){
        for(int i = 0; i<alist.size(); i++){
            Pair p = alist.get(i);
            board[p.x][p.y] = 0;
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		vis = new int[N][M];
		chk = new int[N][M];
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<M;j++){
		        board[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		int ans1 = 0;
		int ans2 = 0;
		while(fin() == false){
		   ans1 += 1;
		   q = new LinkedList<>();
		   vis = new int[N][M];
		   chk = new int[N][M];
		   alist = new ArrayList<>();
		   chkf(); 
		   for(int i=0;i<N;i++){
		       for(int j=0;j<M;j++){
		           if(board[i][j] == 1 && vis[i][j] == 0){
		               q.add(new Pair(i,j));
		               vis[i][j] = 1;
		               bfs();
		           }
		       }
		   }
		   ans2 = 0;
		   		for(int i=0;i<N;i++){
		    for(int j=0;j<M;j++){
		        if(board[i][j] == 1){
		            ans2 += 1;
		        }
		    }
		}
		go();}
		System.out.println(ans1);
		System.out.println(ans2);
		
	}
}