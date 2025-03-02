import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] a = new int[100001];
		int mx = Integer.MAX_VALUE - 2;
		Arrays.fill(a, mx);
		a[0] = 0;
		for (int i = 0; i < n; i++) {
			int coin = Integer.parseInt(br.readLine());
			for (int j = coin; j <= k; j++) {
				a[j] = Math.min(a[j], a[j - coin] + 1);
			}
		}
		if (a[k] == mx) {
			System.out.println(-1);
		} else {
			System.out.println(a[k]);
		}
	}
}
