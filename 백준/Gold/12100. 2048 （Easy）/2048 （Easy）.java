import java.util.*;
import java.io.*;

public class Main
{
    static class Pair{
        int x, y, z;
        Pair(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static class Triple{
        int[][] board;
        int cnt;
        Triple(int[][] board, int cnt ){
            this.board = board;
            this.cnt = cnt;
        }
    }
    static int answer = 0;
    
    static int getMax(int[][] b){
        int mx = 0;
        for(int i=0;i<N;i++) for(int j=0;j<N;j++) mx = Math.max(mx, b[i][j]);
        return mx;
    }
    static int N;
    static int[][] board, vis;
    static Queue<Triple> q = new LinkedList<>();
    static HashSet<String> visited = new HashSet<>();
    // 하 우, 상, 좌;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Pair go(int curx, int cury, int dir){
        while(true){
            int nx = curx + dx[dir];
            int ny = cury + dy[dir];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N){
                return new Pair(curx, cury, 0);
            }
            if(board[nx][ny] != 0){
                return new Pair(nx, ny, -1);
            }
            curx = nx;
            cury = ny;
        }
    }
    static int[][] cloneBoard(int[][] src){
        int[][] dst = new int[N][N];
        for(int i=0;i<N;i++) System.arraycopy(src[i], 0, dst[i], 0, N);
        return dst;
    }
    static boolean sameBoard(int[][] a, int[][] b){
        for(int i=0;i<N;i++) for(int j=0;j<N;j++) if(a[i][j]!=b[i][j]) return false;
        return true;
    }
    static String encode(int[][] b){
        StringBuilder sb = new StringBuilder(N*N*3);
        for(int i=0;i<N;i++) for(int j=0;j<N;j++) sb.append(b[i][j]).append(',');
        return sb.toString();
    }
    static void up(int[][] board){
        vis = new int[N][N];
        for(int i=1; i<N; i++){
            for(int j=0;j<N;j++){
                int curn = board[i][j];
                if(curn == 0) continue;
                Pair curp = go(i,j,2);
                if(curp.z == -1){
                    int prevn = board[curp.x][curp.y];
                    if(curn == prevn && vis[curp.x][curp.y] != 1){
                        board[curp.x][curp.y] = prevn + prevn;
                        vis[curp.x][curp.y] = 1;
                        board[i][j] = 0;
                    }else{
                        if((i != (curp.x+1)) || (curp.y != j)){
                            board[curp.x+1][curp.y] = curn;
                            board[i][j] = 0;
                        }
                    }
                }else{
                    if((i != curp.x) || (curp.y != j)){
                        board[curp.x][curp.y] = curn;
                        board[i][j] = 0;
                    }
                }
            }
        }
    }
    static void down(int[][] board){
        vis = new int[N][N];
        for(int i=N-2; i>=0; i--){
            for(int j=0;j<N;j++){
                int curn = board[i][j];
                if(curn == 0) continue;
                Pair curp = go(i,j,0);
                if(curp.z == -1){
                    int prevn = board[curp.x][curp.y];
                    if(curn == prevn && vis[curp.x][curp.y] != 1){
                        board[curp.x][curp.y] = prevn + prevn;
                        vis[curp.x][curp.y] = 1;
                        board[i][j] = 0;
                    }else{
                        if((i != (curp.x-1)) || ((curp.y) != j)){
                            board[curp.x-1][curp.y] = curn;
                            board[i][j] = 0;
                        }
                    }
                }else{
                    if((i != curp.x) || (curp.y != j)){
                        board[curp.x][curp.y] = curn;
                        board[i][j] = 0;
                    }
                }
            }
        }
    }
    static void right(int[][] board){
        vis = new int[N][N];
        for(int j=N-2; j>=0; j--){
            for(int i=0;i<N;i++){
                int curn = board[i][j];
                if(curn == 0) continue;
                Pair curp = go(i,j,1);
                if(curp.z == -1){
                    int prevn = board[curp.x][curp.y];
                    if(curn == prevn && vis[curp.x][curp.y] != 1){
                        board[curp.x][curp.y] = prevn + prevn;
                        vis[curp.x][curp.y] = 1;
                        board[i][j] = 0;
                    }else{
                        if((i != (curp.x)) || ((curp.y-1) != j)){
                            board[curp.x][curp.y-1] = curn;
                            board[i][j] = 0;
                        }
                    }
                }else{
                    if((i != curp.x) || (curp.y != j)){
                        board[curp.x][curp.y] = curn;
                        board[i][j] = 0;
                    }
                }
            }
        }
    }
    static void left(int[][] board){
        vis = new int[N][N];
        for(int j=1; j<N; j++){
            for(int i=0;i<N;i++){
                int curn = board[i][j];
                if(curn == 0) continue;
                Pair curp = go(i,j,3);
                if(curp.z == -1){
                    int prevn = board[curp.x][curp.y];
                    if(curn == prevn && vis[curp.x][curp.y] != 1){
                        board[curp.x][curp.y] = prevn + prevn;
                        vis[curp.x][curp.y] = 1;
                        board[i][j] = 0;
                    }else{
                        if((i != (curp.x)) || ((curp.y+1) != j)){
                            board[curp.x][curp.y+1] = curn;
                            board[i][j] = 0;
                        }
                    }
                }else{
                    if((i != curp.x) || (curp.y != j)){
                        board[curp.x][curp.y] = curn;
                        board[i][j] = 0;
                    }
                }
            }
        }
    }
    
    static void bfs(){
        while(!q.isEmpty()){
            Triple t = q.poll();
            
            answer = Math.max(answer, getMax(t.board));
            
            if(t.cnt >= 5){
                continue;
            }
            for(int dir=0;dir<4;dir++){
                int[][] tmptmp = cloneBoard(t.board); 
                board = tmptmp;
                switch(dir){
                    case 0 : down(tmptmp); break;
                    case 1 : right(tmptmp); break;
                    case 2 : up(tmptmp); break;
                    case 3 : left(tmptmp); break;
                }
                if(sameBoard(tmptmp, t.board)) continue;
                String key = encode(tmptmp);
                if (visited.add(key)) {
                    q.add(new Triple(tmptmp, t.cnt + 1));
                    answer = Math.max(answer, getMax(tmptmp));
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
		    }
		}
        int[][] start = cloneBoard(board);
        visited.clear(); q.clear();
        visited.add(encode(start));
        q.add(new Triple(start, 0));
        bfs();
		System.out.println(answer);
	}
}