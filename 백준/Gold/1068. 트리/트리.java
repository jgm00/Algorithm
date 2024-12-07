import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] adj;
	static int N;
	static int[] parent;
	static int p;

	static void findAndRemove(int target, int tar) {
		int idx = 0;
		for (int nxt : adj[target]) {
			if (tar == nxt) {
				adj[target].remove(idx);
				return;
			}
			idx++;
		}
	}

	static int[] child;

	static void dfs(int root) {
		int cur = root;
		child[cur] = 0;
		for (int nxt : adj[cur]) {
			if (parent[cur] == nxt)
				continue;
			child[cur] += 1;
			dfs(nxt);
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		parent = new int[N];
		child = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
		}

		int target = Integer.parseInt(br.readLine());

		adj = new ArrayList[N];
		child = new int[N];
		Arrays.fill(child, -1);
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < parent.length; i++) {
			if (parent[i] != -1) {
				adj[i].add(parent[i]);
				adj[parent[i]].add(i);
			} else {
				p = i;
			}
		}
		if (parent[target] != -1) {
			findAndRemove(target, parent[target]);
			findAndRemove(parent[target], target);
			dfs(p);
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (child[i] == 0) {
				ans += 1;
			}
		}
		System.out.println(ans);
	}
}
