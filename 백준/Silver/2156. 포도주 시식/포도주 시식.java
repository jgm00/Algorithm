import java.util.*;
import java.io.*;

public class Main
{
    static int[] dp;
    static int[] board;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(board[1]);
            return;
        }
        if (N == 2) {
            System.out.println(board[1] + board[2]);
            return;
        }

        dp[1] = board[1];
        dp[2] = board[1] + board[2];
        dp[3] = Math.max(board[1]+board[2] ,Math.max(board[1] + board[3], board[2] + board[3]));

        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(
                        dp[i - 1],
                        Math.max(dp[i - 2] + board[i], dp[i - 3] + board[i - 1] + board[i])
                    );
        }

        System.out.println(dp[N]);
    }
}
