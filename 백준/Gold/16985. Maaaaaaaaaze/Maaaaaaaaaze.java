import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        int x, y, z;

        Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int ans = 0;
    static int[][][][] rotState;
    static int[][][] board;
    static int[][][] vis;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Pair> q = new LinkedList<>();

    static void turnL(int k) {
        int[][][] tmp = new int[5][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tmp[4 - j][i][k] = board[i][j][k];
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j][k] = tmp[i][j][k];
            }
        }
    }

    static void turnR(int k) {
        int[][][] tmp = new int[5][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tmp[j][4 - i][k] = board[i][j][k];
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j][k] = tmp[i][j][k];
            }
        }
    }

    static void rotPre() {
        for (int k = 0; k < 5; k++) {
            for (int idx = 0; idx < 4; idx++) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        rotState[k][idx][i][j] = board[i][j][k];
                    }
                }
                turnR(k);
            }
        }
    }

    static int[] arrF = new int[5];
    static int[] visF = new int[5];

    static void chosF(int k) {
        if (k == 5) {
            chosR(0);
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (visF[i] == 1) continue;
            arrF[k] = i;
            visF[i] = 1;
            chosF(k + 1);
            visF[i] = 0;
        }
    }

    static int mn = Integer.MAX_VALUE;
    static int[] arrR = new int[5];

    static void chosR(int k) {
        if (k == 5) {
            build();
            bfs();
            return;
        }
        for (int i = 0; i < 4; i++) {
            arrR[k] = i;
            chosR(k + 1);
        }
    }

    static void build() {
        for (int z = 0; z < 5; z++) {
            int layer = arrF[z];
            int rotIdx = arrR[z];
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    board[x][y][z] = rotState[layer][rotIdx][x][y];
                }
            }
        }
    }

    static void bfs() {
        vis = new int[5][5][5];
        q = new LinkedList<>();
        if (board[0][0][0] == 0) return;
        vis[0][0][0] = 1;
        q.add(new Pair(0, 0, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int curx = p.x;
            int cury = p.y;
            int curz = p.z;
            for (int dir = 0; dir < 6; dir++) {
                int nx = dx[dir] + curx;
                int ny = dy[dir] + cury;
                int nz = dz[dir] + curz;
                if (nx < 0 || ny < 0 || nz < 0 || nx >= 5 || ny >= 5 || nz >= 5) continue;
                if (board[nx][ny][nz] != 1 || vis[nx][ny][nz] != 0) continue;
                q.add(new Pair(nx, ny, nz));
                vis[nx][ny][nz] = 1 + vis[curx][cury][curz];
            }
        }
        if (vis[4][4][4] != 0) {
            mn = Math.min(mn, vis[4][4][4]);
        }
        //System.out.println(vis[4][4][4] + " ");
    }

    public static void main(String[] args) throws IOException {
        board = new int[5][5][5];
        vis = new int[5][5][5];
        rotState = new int[5][4][5][5];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < 5; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 5; j++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        rotPre();
        chosF(0);
        if(mn==Integer.MAX_VALUE){
            mn = 0;
        }
        System.out.println(mn - 1);
    }
}