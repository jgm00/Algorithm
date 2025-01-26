import java.util.*;
import java.io.*;

public class Main {
	static int[] num = new int[10000000];
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int k = Integer.parseInt(st.nextToken());
			if (x - k >= 0) {
				if (num[x - k] != 0) {
					cnt++;
				}
			}
			num[k]++;
		}
		System.out.println(cnt);
	}
}
