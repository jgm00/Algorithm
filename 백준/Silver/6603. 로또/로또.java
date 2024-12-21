import java.io.*;
import java.util.*;

public class Main {
	static int[] num;
	static int K;
	static int[] isused;
	static int[] arr;

	static void dfs(int k) {
		if (k == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(num[arr[i]] + " ");
			}
			System.out.println();
		}
		int st = 0;
		if(k!=0) {
			st = arr[k-1] + 1;
		}
		for (int i = st; i < K; i++) {
			if (isused[i] == 0) {
				arr[k] = i;
				isused[i] = 1;
				dfs(k + 1);
				isused[i] = 0;
			}
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		while (s.charAt(0) != '0') {
			StringTokenizer st = new StringTokenizer(s);
			K = Integer.parseInt(st.nextToken());
			num = new int[K];
			isused = new int[K];
			arr = new int[K];
			for (int i = 0; i < K; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(num);
			dfs(0);
			System.out.println();
			s = br.readLine();
		}
	}
}