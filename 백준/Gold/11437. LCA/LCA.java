

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static ArrayList<Integer>[] graph;
	static int M;
	static int[] d;
	static int[][] par;

	static int LCA(int a, int b) {
		if (d[a] > d[b]) {
			int temp = a;
			a = b;
			b = temp;
		}

		for (int i = 19; i >= 0; i--) {
			if (d[b] - d[a] >= (1 << i)) {
				b = par[b][i];
			}
		}

		if (a == b)
			return a;

		for (int i = 19; i >= 0; i--) {
			if (par[a][i] != par[b][i]) {
				a = par[a][i];
				b = par[b][i];
			}
		}
		return par[a][0];
	}

	static StringTokenizer st;

	static void dfs(int cur) {
		for (int nxt : graph[cur]) {
			if (nxt == par[cur][0])
				continue;
			par[nxt][0] = cur;
			d[nxt] = d[cur] + 1;
			dfs(nxt);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		par = new int[N + 1][20];
		d = new int[N + 1];
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		par[1][0] = 0;
		d[1] = 0;
		dfs(1);
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j <= N; j++) {
				par[j][i] = par[par[j][i - 1]][i - 1];
			}
		}
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			System.out.println(LCA(v1, v2));
		}
	}
}