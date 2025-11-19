import java.util.*;
import java.io.*;

public class Main {
    static int T, N, M;
    static int[] match;
    static int[] vis;
    static int ans;
    static ArrayList<ArrayList<Integer>> alst;

    static boolean dfs(int idx) {
        for (int k : alst.get(idx)) {
            if (vis[k] == 1) continue;
            vis[k] = 1;

            if (match[k] == 0 || dfs(match[k])) {
                match[k] = idx;      
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); 
            M = Integer.parseInt(st.nextToken()); 

            alst = new ArrayList<>();
            for (int i = 0; i <= M; i++) {
                alst.add(new ArrayList<>());
            }

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                for (int j = a; j <= b; j++) {
                    alst.get(i).add(j);
                }
            }

            match = new int[N + 1];
            vis = new int[N + 1];
            ans = 0;

            for (int i = 1; i <= M; i++) {
                Arrays.fill(vis, 0);
                if (dfs(i)) {
                    ans++;
                }
            }

            System.out.println(ans);
        }
    }
}
