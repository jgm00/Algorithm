import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] board;
    static int[][] vis;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int mn = Integer.MIN_VALUE;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Pair> q;
    static void bfs(){
        while(!q.isEmpty()){
            Pair p = q.poll();
            
            for(int dir =0;dir<4;dir++){
                int nx = dx[dir] + p.x;
                int ny = dy[dir] + p.y;
                if(nx < 0 || ny < 0 || nx >=N || ny >= M) continue;
                if(board[nx][ny] != 0 || vis[nx][ny] == 1) continue;
                q.add(new Pair(nx,ny));
                vis[nx][ny] = 1;
            }
        }
    }
    static int check(){
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j =0;j<M; j++){
                if(vis[i][j] == 0 && board[i][j] != 1) {
                cnt+=1;
                    
                }
            }
        }
        return cnt;
    }
    
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
            }
        }
        ArrayList<Pair> q1 = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j] == 0){
                q1.add(new Pair(i,j));}
            }
        }
        boolean flag = false;
        for(int i=0;i<q1.size();i++){
            for(int j=i+1; j<q1.size(); j++){
                for(int k=j+1; k<q1.size(); k++){
        board[q1.get(i).x][q1.get(i).y] = 1;
        board[q1.get(j).x][q1.get(j).y] = 1;
        board[q1.get(k).x][q1.get(k).y] = 1;
        q = new LinkedList<>();
        vis = new int[N][M];
        
        for(int i1=0;i1<N;i1++){
            for(int j1=0;j1<M;j1++){
                if(board[i1][j1] == 2){
                    q.add(new Pair(i1,j1));
                    vis[i1][j1] = 1;
                    
                }
            }
        }
        bfs();
        int k1 = check();
        mn = Math.max(k1,mn);

        board[q1.get(i).x][q1.get(i).y] = 0;
        board[q1.get(j).x][q1.get(j).y] = 0;
        board[q1.get(k).x][q1.get(k).y] = 0;
                    }}}   
                    
                    System.out.println(mn);
        
    }
}
