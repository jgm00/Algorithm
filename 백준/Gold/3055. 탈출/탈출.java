import java.util.*;
import java.io.*;

public class Main {
    static int R,C;
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static char[][] board;
    static int[][] visW;
    static int[][] visS;
    static int[] dx = {1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static Queue<Pair> qW = new LinkedList<>();
    static Queue<Pair> qS = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visW = new int[R][C];
        visS = new int[R][C];
        int ansx = 0; int ansy = 0;
        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                board[i][j] = s.charAt(j);
                if(board[i][j] == '*'){
                    qW.add(new Pair(i,j));
                    visW[i][j] = 1;
                }
                if(board[i][j] == 'S'){
                    qS.add(new Pair(i,j));
                    visS[i][j] = 1;
                }
                if(board[i][j] == 'D'){
                    ansx = i;
                    ansy = j;
                }
            }
        }
        while(!qW.isEmpty()){
            Pair p = qW.poll();
            for(int dir=0;dir<4;dir++){
                int nx = dx[dir] + p.x;
                int ny = dy[dir] + p.y;
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(board[nx][ny] == 'X' || board[nx][ny] == 'D' || visW[nx][ny] != 0) continue;
                qW.add(new Pair(nx,ny));
                visW[nx][ny] = visW[p.x][p.y] + 1;
            }
        }
        while(!qS.isEmpty()){
            Pair p = qS.poll();
            for(int dir=0;dir<4;dir++){
                int nx = dx[dir] + p.x;
                int ny = dy[dir] + p.y;
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(board[nx][ny] == 'X' || board[nx][ny] == '*' || visW[nx][ny] != 0 && (visW[nx][ny] <= visS[p.x][p.y] + 1) || visS[nx][ny] != 0) continue;
                qS.add(new Pair(nx,ny));
                visS[nx][ny] = visS[p.x][p.y] + 1;
            }
        }
        int ans = visS[ansx][ansy] - 1;
        if(ans == -1) {System.out.println("KAKTUS");}else{
        System.out.println(visS[ansx][ansy] - 1);}
    }
}
