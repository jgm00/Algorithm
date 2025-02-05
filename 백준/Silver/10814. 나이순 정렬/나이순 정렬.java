
import java.io.*;
import java.util.*;

public class Main {
	static int N;

	static class Pair {
		int k;
		String s;
		int idx;

		Pair(int k, String s, int idx) {
			this.k = k;
			this.s = s;
			this.idx = idx;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Pair[] pairs = new Pair[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			String b = st.nextToken();
			pairs[i] = new Pair(a, b, i);
		}
		Arrays.sort(pairs, (o1, o2) -> {
			if(o1.k == o2.k) {
				return o1.idx - o2.idx;
			} 
			return o1.k - o2.k;
		});
		for(int i=0;i<N;i++) {
			System.out.println(pairs[i].k + " " + pairs[i].s);
		}
	}
}
