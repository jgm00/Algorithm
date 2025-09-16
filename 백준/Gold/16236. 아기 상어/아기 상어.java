import java.io.*;
import java.util.*;

public class Main
{
    static int N;
    static int[][] board, vis;
    static class Pair{
        int x,y,z;
        Pair(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static Queue<Pair> q = new LinkedList<>();
    static PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2)->{
        if(o1.z == o2.z){
            if(o1.x == o2.x){
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        }
        return o1.z - o2.z;
    });
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int Ssize = 2;
    static int Scnt = 0;
    static void bfs(){
        pq = new PriorityQueue<>((o1,o2)->{
        if(o1.z == o2.z){
            if(o1.x == o2.x){
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        }
        return o1.z - o2.z;
    });
    int eat = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            
            Pair p = q.poll();
            int curx = p.x;
            int cury = p.y;
            if(vis[curx][cury] > eat){
                break;
            }
            for(int dir = 0; dir < 4; dir++){
                int nx = curx + dx[dir];
                int ny = cury + dy[dir];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(vis[nx][ny] != -1 || board[nx][ny] > Ssize) continue;
                q.add(new Pair(nx,ny));
                vis[nx][ny] = vis[curx][cury] + 1;
                if(board[nx][ny] != 0 && board[nx][ny] < Ssize){
                    pq.add(new Pair(nx,ny,vis[nx][ny]));
                    eat = vis[nx][ny];
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
            Arrays.fill(vis[i],-1);
        }
        int sx = 0; int sy = 0;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 9){
                    board[i][j] = 0;
                    sx = i; sy = j;
                }
            }
        }
        int ans = 0;
        while(true){
            for(int i=0;i<N;i++){
                Arrays.fill(vis[i],-1);
            }
            vis[sx][sy] = 0;
            q = new LinkedList<>();
            q.add(new Pair(sx,sy));
            bfs();
            if(pq.isEmpty()){
                System.out.println(ans);
                break;
            }
            Pair tg = pq.poll();
            ans += tg.z;
            Scnt++;
            if(Scnt == Ssize){
                Ssize += 1;
                Scnt = 0;
            }
            board[tg.x][tg.y] = 0;
            sx = tg.x;
            sy = tg.y;
        }
	}
}