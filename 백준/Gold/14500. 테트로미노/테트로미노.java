import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int mx = Integer.MIN_VALUE;
    // 1
    static int[] dx1 = { 0, 0, 0, 0 };
    static int[] dy1 = { 0, 1, 2, 3 };
    static int[] dx2 = { 0, 1, 2, 3 };
    static int[] dy2 = { 0, 0, 0, 0 };
    // 2
    static int[] dx3 = { 0, 1, 0, 1 };
    static int[] dy3 = { 0, 0, 1, 1 };
    // 3
    static int[] dx4 = { 0, 1, 2, 2 };
    static int[] dy4 = { 0, 0, 0, 1 };
    static int[] dx5 = { 1, 1, 1, 0 };
    static int[] dy5 = { 0, 1, 2, 2 };
    static int[] dx6 = { 0, 0, 0, 1 };
    static int[] dy6 = { 0, 1, 2, 2 };
    static int[] dx7 = { 0, 0, 1, 2 };
    static int[] dy7 = { 0, 1, 1, 1 };
    static int[] dx8 = { 1, 0, 1, 1 };
    static int[] dy8 = { 0, 0, 1, 2 };
    static int[] dx9 = { 0, 1, 0, 0 };
    static int[] dy9 = { 0, 0, 1, 2 };
    static int[] dx10 = { 0, 1, 2, 2 };
    static int[] dy10 = { 1, 1, 1, 0 };
    static int[] dx11 = { 0, 1, 2, 0 };
    static int[] dy11 = { 0, 0, 0, 1 };
    // 4
    static int[] dx12 = { 0, 1, 1, 2 };
    static int[] dy12 = { 0, 0, 1, 1 };
    static int[] dx13 = { 0, 1, 1, 2 };
    static int[] dy13 = { 1, 1, 0, 0 };
    static int[] dx14 = { 1, 1, 0, 0 };
    static int[] dy14 = { 0, 1, 1, 2 };
    static int[] dx15 = { 0, 0, 1, 1 };
    static int[] dy15 = { 0, 1, 1, 2 };
    // 5
    static int[] dx16 = { 0, 0, 0, 1 };
    static int[] dy16 = { 0, 1, 2, 1 };
    static int[] dx17 = { 1, 1, 1, 0 };
    static int[] dy17 = { 0, 1, 2, 1 };
    static int[] dx18 = { 1, 0, 1, 2 };
    static int[] dy18 = { 1, 0, 0, 0 };
    static int[] dx19 = { 0, 1, 2, 1 };
    static int[] dy19 = { 1, 1, 1, 0 };

    static int[][] board;

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Pair> q = new LinkedList<>();

    static void func(int[] dx, int dy[]) {
        int curx, cury;
        int nx = 0;
        int ny = 0;
        int sum1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                curx = i;
                cury = j;
                sum1 = 0;
                q = new LinkedList<>();
                for (int dir = 0; dir < 4; dir++) {
                    nx = curx + dx[dir];
                    ny = cury + dy[dir];
                    if (nx < 0 || nx >= N || nx < 0 || ny >= M) {
                        continue;
                    }
                    q.add(new Pair(nx, ny));
                }
                if (q.size() == 4) {
                    for (int ii = 0; ii < 4; ii++) {
                        Pair temp = q.poll();
                        //System.out.print(board[temp.x][temp.y]);
                        sum1 += board[temp.x][temp.y];
                    }
                    //System.out.println();
                    mx = Math.max(mx, sum1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(dx1, dy1);
        func(dx2, dy2);
        func(dx3, dy3);
        func(dx4, dy4);
        func(dx5, dy5);
        func(dx6, dy6);
        func(dx7, dy7);
        func(dx8, dy8);
        func(dx9, dy9);
        func(dx10, dy10);
        func(dx11, dy11);
        func(dx12, dy12);
        func(dx13, dy13);
        func(dx14, dy14);
        func(dx15, dy15);
        func(dx16, dy16);
        func(dx17, dy17);
        func(dx18, dy18);
        func(dx19, dy19);

        System.out.println(mx);

    }
}