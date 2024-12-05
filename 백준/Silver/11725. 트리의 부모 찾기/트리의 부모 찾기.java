import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	static int[] parent;
	static Queue<Integer> q = new LinkedList<>();

	static void bfs(int root) {
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int nxt : adj.get(cur)) {
				if (nxt == parent[cur])
					continue;
				q.add(nxt);
				parent[nxt] = cur;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N + 1; i++) {
			adj.add(new ArrayList<Integer>());
		}

		parent = new int[N + 1];

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj.get(s).add(v);
			adj.get(v).add(s);
		}
		q.add(1);
		bfs(1);
		for (int i = 2; i < N + 1; i++) {
			System.out.println(parent[i]);
		}
	}
}
