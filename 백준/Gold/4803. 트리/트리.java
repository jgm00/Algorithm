import java.io.*;
import java.util.*;

public class Main {

	static int[] parent;
	static ArrayList<ArrayList<Integer>> adj;
	static int[] vis;
	static int cnt;
	
	static boolean bfs(int root) {
		Queue<Integer> q = new LinkedList<>();
		q.add(root);
		vis[root] = 1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int nxt : adj.get(cur)) {
				if (parent[cur] == nxt)
					continue;
				if (vis[nxt] == 1) {
					return false;
				}
				q.add(nxt);
				parent[nxt] = cur;
				vis[nxt] = 1;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = -1;
		int M = -1;
		int tc = 0;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0) {
				return;
			}
			tc+=1;
			cnt = 0;
			adj = new ArrayList<>();
			vis = new int[N+1];
			for (int i = 0; i < N + 1; i++) {
				adj.add(new ArrayList<Integer>());
			}
			parent = new int[N + 1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				adj.get(u).add(v);
				adj.get(v).add(u);
			}
			for (int i =1; i<N+1; i++) {
				if(vis[i] == 1) continue;
				if(bfs(i) == true) {
					cnt += 1;
				} 
			}
			if(cnt==1) {
				System.out.println("Case "+tc+": There is one tree.");
			}else if (cnt == 0) {
				System.out.println("Case "+tc+": No trees.");
			} else {
				System.out.println("Case "+tc+": A forest of "+cnt+" trees.");
			}
		}
	}
}
