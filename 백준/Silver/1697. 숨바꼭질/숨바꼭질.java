import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int cur, nx;
    static int[] board = new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> Q = new LinkedList<>();

        for (int i = 0; i < 100001; i++) {
            board[i] = -1;
        }

        board[N] = 0;
        Q.add(N);

        while (!Q.isEmpty()) {
            cur = Q.poll();

            if (cur == K) {
                System.out.println(board[K]);
                return;
            }

            for (int i = 0; i < 3; i++) {
                switch (i) {
                    case 0:
                        nx = cur - 1;
                        break;
                    case 1:
                        nx = cur + 1;
                        break;
                    case 2:
                        nx = cur * 2;
                        break;
                }

                if (nx < 0 || nx > 100000) continue;
                if (board[nx] != -1) continue;
                
                    board[nx] = board[cur] + 1;
                    Q.add(nx);
                
            }
        }
        
    }
}
