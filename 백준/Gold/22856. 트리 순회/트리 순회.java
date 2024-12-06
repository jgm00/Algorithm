import java.io.*;
import java.util.*;

public class Main {

	static int[] lc;
	static int[] rc;
	static int[] p;
	static int fin;
	static int[] vis;
	static int cnt;

	static void semiinorder(int root) {
		cnt += 1;
		if (lc[root] != -1 && vis[lc[root]] == 0) {
			vis[lc[root]] = 1;
			semiinorder(lc[root]);
		} else if (rc[root] != -1 && vis[rc[root]] == 0) {
			vis[rc[root]] = 1;
			semiinorder(rc[root]);
		} else if (fin == root) {
			return;
		} else if (p[root] != 0) {
			semiinorder(p[root]);
		}
	}

	static void inorder(int root) {
		if (lc[root] != -1) {
			inorder(lc[root]);
		}
		fin = root;
		if (rc[root] != -1) {
			inorder(rc[root]);
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		p = new int[N + 1];
		lc = new int[N + 1];
		rc = new int[N + 1];
		vis = new int[N + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			lc[k] = l;
			rc[k] = r;
			if (l != -1) {
				p[l] = k;
			}
			if (r != -1) {
				p[r] = k;
			}
		}
		inorder(1);
		semiinorder(1);
		System.out.println(cnt - 1);
	}
}
