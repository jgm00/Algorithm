import java.io.*;
import java.util.*;

public class Main {
	static String[] lst;
	static int N;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		lst = new String[N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			lst[i] = str;
		}
		Arrays.sort(lst, (o1, o2) -> {
			if (o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}
			return o1.length() - o2.length();
		});
		for (int i = 0; i < N - 1; i++) {
			String tstr = lst[i];
			String tstr2 = lst[i + 1];
			if (tstr.equals(tstr2) == false) {
				System.out.println(tstr);
			}
		}
		System.out.println(lst[N - 1]);
	}
}