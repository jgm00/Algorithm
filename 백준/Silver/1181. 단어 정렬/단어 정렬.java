import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static String[] arr;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			arr[i] = s;
		}
		Arrays.sort(arr, (o1, o2) -> {
			if (o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}
			return o1.length() - o2.length();
		});
		System.out.println(arr[0]);
		for (int i = 1; i < N; i++) {
			if (arr[i].equals(arr[i - 1]) == false) {
				System.out.println(arr[i]);
			}
		}
	}
}
