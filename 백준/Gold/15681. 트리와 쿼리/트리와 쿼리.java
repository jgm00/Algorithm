import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int R;
	static int Q;

	static ArrayList<Integer>[] adj;
	static ArrayList<Integer>[] tree;
	static int[] size;

	static void dfs(int root, int parent) {
		for (int nxt : adj[root]) {
			if (nxt == parent)
				continue;
			tree[root].add(nxt);
			dfs(nxt, root);
		}
	}

	static void count(int root) {
		size[root] = 1;
		for (int nxt : tree[root]) {
			count(nxt);
			size[root] += size[nxt];
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		tree = new ArrayList[N + 1];

		size = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		dfs(R, -1);
		count(R);
		for (int i = 0; i < Q; i++) {
			int k = Integer.parseInt(br.readLine());
			System.out.println(size[k]);
		}
	}
}
