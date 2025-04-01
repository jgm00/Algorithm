import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] board;
	static int[] vis;

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static ArrayList<Pair> chicken = new ArrayList<>();
	static ArrayList<Pair> house = new ArrayList<>();
	static int[] arr;
	static int MN = Integer.MAX_VALUE;

	static void dfs(int k) {
		if (k == M) {
			int sum = 0;
			for (int d = 0; d < house.size(); d++) {
				int mn = Integer.MAX_VALUE;
				for (int i = 0; i < M; i++) {
					Pair h = house.get(d);
					Pair c = chicken.get(arr[i]);
					mn = Math.min(mn, (Math.abs(h.x - c.x) + Math.abs(h.y - c.y)));
				}
				sum += mn;
				if(sum > MN) {
					return;
				}
			}
			MN = Math.min(MN, sum);
			sum = 0;
			return;
		}
		int st = 0;
		if (k != 0) {
			st = arr[k - 1];
		}
		for (int i = st; i < chicken.size(); i++) {
			if (vis[i] == 1)
				continue;
			arr[k] = i;
			vis[i] = 1;
			dfs(k + 1);
			vis[i] = 0;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int k = Integer.parseInt(st.nextToken());
				if (k == 2) {
					chicken.add(new Pair(i, j));
				} else if (k == 1) {
					house.add(new Pair(i, j));
				}
			}
		}
		int sz = chicken.size();
		arr = new int[M];
		vis = new int[sz];
		dfs(0);
		System.out.println(MN);
	}
}