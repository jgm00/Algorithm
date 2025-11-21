import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static String s;
	static int[] count = new int[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		Arrays.fill(count, -1);
		for (int i = s.length()-1; i >= 0; i--) {
			char c = s.charAt(i);
			count[c - 'a'] = i;
		}
		for (int i = 0; i < 26; i++) {
			System.out.print(count[i] + " ");
		}
	}
}
