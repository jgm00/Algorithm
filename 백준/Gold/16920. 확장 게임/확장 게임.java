import java.util.*;
import java.io.*;

public class Main {
    static int N, M, P;
    static int[] S;             
    static char[][] board;     
    static int[][] board1;      
    static ArrayDeque<int[]>[] q;
    static int[] owned;         
    static final int[] dx = {1,0,-1,0};
    static final int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        S = new int[P + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }
        board = new char[N][M];
        board1 = new int[N][M];
        owned = new int[P + 1];
        q = new ArrayDeque[P + 1];
        for (int i = 1; i <= P; i++){ 
            q[i] = new ArrayDeque<>();
        }
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                board[i][j] = c;
                if ('1' <= c && c <= '9') {
                    int p = c - '0';
                    q[p].offer(new int[]{i, j});
                    owned[p]++;
                    board1[i][j] = p;
                }
            }
        }

        while (true) {
            boolean movedThisRound = false;

            for (int p = 1; p <= P; p++) {
                int speed = S[p];
                for (int step = 0; step < speed; step++) {
                    int curLevelSize = q[p].size();
                    if (curLevelSize == 0) break;
                    for (int cnt = 0; cnt < curLevelSize; cnt++) {
                        int[] cur = q[p].poll();
                        int x = cur[0], y = cur[1];

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if (board[nx][ny] == '.') { 
                                board[nx][ny] = (char)('0' + p);
                                board1[nx][ny] = p;
                                owned[p]++;
                                q[p].offer(new int[]{nx, ny});
                                movedThisRound = true;
                            }
                        }
                    }
                }
            }

            if (!movedThisRound) break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= P; i++) {
            if (i > 1) sb.append(' ');
            sb.append(owned[i]);
        }
        System.out.println(sb);
    }
}
