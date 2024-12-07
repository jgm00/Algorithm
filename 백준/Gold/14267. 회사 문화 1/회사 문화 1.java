import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] adj;
	static int N, M;
	static int[] parent;
	static int[] good;
	static ArrayList<Integer>[] comp;
	static void dfs(int root, int compliment) {
		int cur = root;
		good[cur] += compliment;
		for (int nxt : adj[cur]) {
			int sum = 0;
			if (parent[cur - 1] == nxt)
				continue;
			for(int k:comp[nxt]) {
				sum += k;
			}
			dfs(nxt, sum+compliment);
		}
		}
	

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		parent = new int[N];
		good = new int[N + 1];
		comp = new ArrayList[N+1];
		for (int i = 0; i < N; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
		}
		adj = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
			comp[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			if (parent[i] != -1) {
				adj[i + 1].add(parent[i]);
				adj[parent[i]].add(i + 1);
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			comp[s1].add(s2);
		}
		dfs(1,0);
		for (int i = 1; i < N + 1; i++) {
			System.out.print(good[i] + " ");
		}
	}
}
