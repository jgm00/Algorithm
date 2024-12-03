import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int mx = 10000 * 500;
	static int[][] nxt = new int[mx][26];
	static int[] chk = new int[mx];
	static int ROOT = 1;
	static int unused = 2;

	static int cToi(char c) {
		return c - 'a';
	}

	static void insert(String s) {
		int cur = ROOT;
		for (char c : s.toCharArray()) {
			if (nxt[cur][cToi(c)] == -1) {
				nxt[cur][cToi(c)] = unused++;
			}
			cur = nxt[cur][cToi(c)];
		}
		chk[cur] = 1;
	}

	static boolean find(String s) {
		int cur = ROOT;
		for (char c : s.toCharArray()) {
			if (nxt[cur][cToi(c)] == -1) {
				return false;
			}
			cur = nxt[cur][cToi(c)];
		}
		return chk[cur] == 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int cnt = 0;

		for (int i = 0; i < mx; i++) {
			Arrays.fill(nxt[i], -1);
		}

		for (int i = 0; i < N; i++) {
			insert(br.readLine());
		}

		for (int i = 0; i < M; i++) {
			if (find(br.readLine()) == true) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
