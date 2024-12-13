import java.io.*;
import java.util.*;

public class Main {

	static int mx = 100000 * 2 +1;

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Pair[] dist;
	static List<Integer> lst = new ArrayList<>();
	static void find(int root) {
		int cur = root;
		if(cur == -1) {
			Collections.reverse(lst);
			for(int i=0;i<lst.size(); i++) {
				System.out.print(lst.get(i) + " ");
			}
			return;
		}
		lst.add(cur);
		find(dist[cur].x);
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		dist = new Pair[mx];
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<mx; i++) {
			dist[i] = new Pair(-2,-1);
		}
		dist[N] = new Pair(-1, 1);
		q.add(N);
		while (!q.isEmpty()) {
			int cur = q.poll();
			if(cur == M) {
				System.out.println(dist[cur].y-1);
				find(cur);
				return;
			}
			for (int dir = 0; dir < 3; dir++) {
				int nx  = 0;
				if (dir == 0) {
					nx = cur + 1;
				} else if (dir == 1) {
					nx = cur - 1;
				} else {
					nx = cur * 2;
				}
				if(nx<0||nx>=200001) continue;
				if(dist[nx].y != -1) continue;
				dist[nx] = new Pair(cur,dist[cur].y +1);
				q.add(nx);
			}
		}
	}
}