import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] board;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int mx = Integer.MIN_VALUE;
    static Pair[][] tet = {
             {new Pair(0,0), new Pair(0,1), new Pair(0,2), new Pair(0,3)},   // 1
            {new Pair(0,0), new Pair(1,0), new Pair(2,0), new Pair(3,0)},   // 2

            {new Pair(0,0), new Pair(0,1), new Pair(1,0), new Pair(1,1)},   // 3

            {new Pair(0,0), new Pair(1,0), new Pair(2,0), new Pair(2,1)},   // 4
            {new Pair(0,0), new Pair(1,0), new Pair(2,0), new Pair(2,-1)},   // 5
            {new Pair(0,0), new Pair(0,1), new Pair(0,2), new Pair(-1,2)},   // 6
            {new Pair(0,0), new Pair(1,0), new Pair(1,1), new Pair(1,2)},   // 7
            {new Pair(0,0), new Pair(0,1), new Pair(1,1), new Pair(2,1)},   // 8
            {new Pair(0,0), new Pair(0,1), new Pair(1,0), new Pair(2,0)},   // 9
            {new Pair(0,0), new Pair(0,1), new Pair(0,2), new Pair(1,0)},   // 10
            {new Pair(0,0), new Pair(0,1), new Pair(0,2), new Pair(1,2)},   // 11

            {new Pair(0,0), new Pair(1,0), new Pair(1,1), new Pair(2,1)},   // 12
            {new Pair(0,0), new Pair(0,1), new Pair(-1,1), new Pair(-1,2)},   // 13
            {new Pair(0,0), new Pair(1,0), new Pair(1,-1), new Pair(2,-1)},   // 14
            {new Pair(0,0), new Pair(0,1), new Pair(1,1), new Pair(1,2)},   // 15

            {new Pair(0,0), new Pair(0,1), new Pair(0,2), new Pair(1,1)},   // 16
            {new Pair(0,0), new Pair(1,-1), new Pair(1, 0), new Pair(2,0)},   // 17
            {new Pair(0,0), new Pair(1,0), new Pair(1,-1), new Pair(1,1)},   // 18
            {new Pair(0,0), new Pair(1,0), new Pair(1,1), new Pair(2,0)},   // 19
    };
    static void func(int curx, int cury){
        for(int i=0;i<19;i++) {
            int sum = 0;
            int flag = 0;
            for (int dir = 0; dir < 4; dir++) {
                Pair p = tet[i][dir];
                int nx = p.x + curx;
                int ny = p.y + cury;
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    flag = 1;
                    break;
                }
                sum += board[nx][ny];
            }
            if (flag == 0) {
                mx = Math.max(mx,sum);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                func(i,j);
            }
        }
        System.out.println(mx);
    }
}
