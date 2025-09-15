import java.util.*;
import java.io.*;

public class Main {
    static int N = 5;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int Ans = 0;
    static char[][] board;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int fin;
    static int[][] vis;
    static int[] arr;
    static void dfs(int k, int Ycnt){
        if( (7 - k + Ycnt) < 4){
            return;
        }
        if(k==7){
            if(bfs(fin) == 7){
                Ans +=1;
            };
            return;
        }
        int stt = 0;
        if(k == 0){
            stt = 0;
        }else{
            stt = fin;
        }
        for(int i=stt; i<=24;i++){
            int x = i / 5;
            int y = i % 5;
            if(vis[x][y] == 1) continue;
            fin = i;
            arr[k] = i;
            vis[x][y] = 1;
            if(board[x][y] == 'S'){
                dfs(k+1,Ycnt+1);
            }else{
                dfs(k+1, Ycnt);
            }
            vis[x][y] = 0;
        }
    }
    static int bfs(int k){
        int curx = k / 5;
        int cury = k % 5;
        Queue<Pair> q = new LinkedList<>();
        int[][] qvis = new int[N][N];
        q.add(new Pair(curx,cury));
        qvis[curx][cury] = 1;
        int cnt = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            cnt += 1;
            for(int dir = 0; dir < 4 ; dir++){
                int nx = dx[dir] + p.x;
                int ny = dy[dir] + p.y;
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if(vis[nx][ny] != 1 || qvis[nx][ny] == 1) continue;
                qvis[nx][ny] = 1;
                q.add(new Pair(nx,ny));
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[5][5];
        for(int i=0;i<5;i++){
            String s= br.readLine();
            for(int j=0;j<5;j++){
                board[i][j] = s.charAt(j);
            }
        }
        arr = new int[7];
        vis = new int[N][N];
        dfs(0,0);
        System.out.println(Ans);
    }
}
