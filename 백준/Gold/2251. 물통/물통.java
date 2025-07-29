import java.util.*;
import java.io.*;

public class Main {
    static int[] Limit = new int[3];
    static boolean[][][] vis = new boolean[201][201][201];
    static boolean[] ans = new boolean[201];

    static int[] move(int from, int to, int[] water) {
        int[] news = Arrays.copyOf(water, 3);
        int amount = Math.min(water[from], Limit[to] - water[to]);
        news[from] -= amount;
        news[to] += amount;
        return news;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            Limit[i] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, Limit[2]});
        vis[0][0][Limit[2]] = true;

        while (!q.isEmpty()) {
            int[] water = q.poll();
            if (water[0] == 0) {
                ans[water[2]] = true;
            }

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;

                    int[] next = move(from, to, water);
                    if (!vis[next[0]][next[1]][next[2]]) {
                        vis[next[0]][next[1]][next[2]] = true;
                        q.add(next);
                    }
                }
            }
        }

        for (int i = 0; i <= 200; i++) {
            if (ans[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
