import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static String s;
	static int[] count = new int[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			s = st.nextToken();
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < s.length(); j++) {
				char t = s.charAt(j);
				for (int k = 0; k < a; k++) {
					sb.append(t);
				}
			}
			System.out.println(sb.toString());
		}
	}
}
