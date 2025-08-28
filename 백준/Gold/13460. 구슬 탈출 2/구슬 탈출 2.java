import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static char[][] board;
    static int[][][][] vis;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static class Pair{
        int bx, by, rx, ry, cnt;
        Pair(int bx, int by, int rx, int ry, int cnt){
            this.bx = bx;
            this.by = by;
            this.rx = rx;
            this.ry = ry;
            this.cnt = cnt;
        }
        Pair(int bx, int by, int cnt){
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }
    static Pair go(int curx, int cury, int dir){
        int cnt = 0;
        while(true){
            int nx = dx[dir] + curx;
            int ny = dy[dir] + cury;
            if(board[nx][ny] == 'O') return new Pair(-1,-1,-1);
            if(board[nx][ny] == '#') return new Pair(curx,cury,cnt);
            cnt += 1;
            curx = nx;
            cury = ny;
        }
 
    }
    static Queue<Pair> q = new LinkedList<>();
    static int Rcnt = 0;
    static int bfs(){
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.cnt >= 10){
                continue;
            }
            for(int dir = 0; dir<4; dir++){
                Pair bp = go(p.bx, p.by, dir);
                Pair rp = go(p.rx, p.ry, dir);
                if(bp.bx == -1 && bp.by == -1 && bp.cnt == -1) continue;
                if(rp.bx == -1 && rp.by == -1 && rp.cnt == -1) return p.cnt+1;                
                if(bp.bx == rp.bx && bp.by == rp.by){
                    if(bp.cnt > rp.cnt){
                        bp.bx -= dx[dir];
                        bp.by -= dy[dir];
                    }else{
                        rp.bx -= dx[dir];
                        rp.by -= dy[dir];
                    }
                }
                if(vis[bp.bx][bp.by][rp.bx][rp.by] == 0){
                    vis[bp.bx][bp.by][rp.bx][rp.by] = 1;
                    q.add(new Pair(bp.bx,bp.by,rp.bx,rp.by,p.cnt+1));
                }
            }
        }
        return -1;
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        vis = new int[N][M][N][M];
        int bcx = 0; int bcy = 0; int rcx = 0; int rcy = 0;
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                board[i][j] = s.charAt(j);
                if(board[i][j] == 'B'){
                    bcx = i; bcy = j;
                    board[i][j] = '.';
                }
                if(board[i][j] == 'R'){
                    rcx = i; rcy = j;
                    board[i][j] = '.';
                }
            }
        }
        vis[bcx][bcy][rcx][rcy] = 1;
        q.add(new Pair(bcx,bcy,rcx,rcy,0));
	    int k = bfs();
	    System.out.println(k);
	}
}