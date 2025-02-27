import java.util.*;
import java.io.*;

public class Main {
	static int T, N;
	static ArrayList<Integer>[] trees;
	static ArrayList<Integer> vis1;
	static ArrayList<Integer> vis2;
	static int[] par;

	static void dfs(int cur, ArrayList<Integer> vis) {
		for (int nxt : trees[cur]) {
			if (par[cur] != nxt)
				continue;
			if (par[cur] == 0)
				return;
			vis.add(nxt);
			dfs(nxt, vis);
		}
	}

	static void fid() {
		for (int i = 0; i < vis1.size(); i++) {
			if (vis2.contains(vis1.get(i)) == true) {
				System.out.println(vis1.get(i));
				return;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			trees = new ArrayList[N + 1];
			vis1 = new ArrayList<>();
			par = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				trees[i] = new ArrayList<>();
			}
			for (int i = 0; i < N - 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				trees[a].add(b);
				trees[b].add(a);
				par[b] = a;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			vis1.add(n1);
			dfs(n1, vis1);
			vis2 = new ArrayList<>();
			vis2.add(n2);
			dfs(n2, vis2);
			fid();
		}
	}
}
