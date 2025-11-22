import java.util.*;
import java.io.*;

public class Main {
	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int k1 = 0;
			int k2 = 0;
			if (N % H == 0) {
				k1 = H * 100;
				k2 = N / H;
			} else {
				k1 = (N % H) * 100;
				k2 = N / H + 1;
			}
			System.out.println(k1 + k2);
		}

	}
}
