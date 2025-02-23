import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static String[] str1;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str1 = new String[N];
		for (int i = 0; i < N; i++) {
			str1[i] = br.readLine();
		}
		Arrays.sort(str1, (o1, o2) -> {
			if (o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}
			return o1.length() - o2.length();
		});
		System.out.println(str1[0]);
		for (int i = 1; i < str1.length; i++) {
			if (str1[i].equals(str1[i - 1]) == false) {
				System.out.println(str1[i]);
			}
		}
	}
}
