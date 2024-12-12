import java.io.*;
import java.util.*;

public class Main {
	static int F,S,G,U,D;
	static int[] elavor;
	static Queue<Integer> q = new LinkedList<>();
	static void bfs() {
		int[] dx = {U,-D};
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur==G) {
				System.out.println(elavor[cur]);
				return;
			}
			for(int dir =0; dir<2; dir++) {
				int nx = dx[dir] + cur;
				if(nx<1 || nx>=F+1) continue;
				if(elavor[nx] != -1) continue;
				elavor[nx] = 1 + elavor[cur];
				q.add(nx);
			}
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		elavor = new int[1000001];
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		Arrays.fill(elavor, -1);
		elavor[S] = 0;
		q.add(S);
		bfs();
		if(elavor[G] == -1) {
			System.out.println("use the stairs");
		}

	}
}
