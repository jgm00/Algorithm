import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[][] dist, nxt;
	static int INF = Integer.MAX_VALUE;
	static ArrayList<Integer> path;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		dist = new int[n + 1][n + 1];
		nxt = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					dist[i][j] = 0;
				} else {
					dist[i][j] = INF;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dist[a][b] = Math.min(dist[a][b], c);
			nxt[a][b] = b;
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (dist[i][k] != INF && dist[k][j] != INF) {
						if (dist[i][j] > dist[i][k] + dist[k][j]) {
							dist[i][j] = dist[i][k] + dist[k][j];
							nxt[i][j] = nxt[i][k];
						}
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dist[i][j] == INF) {
					System.out.print("0 ");
				} else {
					System.out.print(dist[i][j] + " ");
				}
			}
			System.out.println();
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dist[i][j] == INF || i == j) {
					System.out.println("0");
					continue;
				}
				path = new ArrayList<>();
				int k = i;
				path.add(k);
				while (k != j) {
					k = nxt[k][j];
					path.add(k);
				}
				System.out.print(path.size() + " ");
				for (int v : path) {
					System.out.print(v + " ");
				}
				System.out.println();
			}
		}
	}
}
