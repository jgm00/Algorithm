import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static long sm;
	static String s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = br.readLine();
		for(char c : s.toCharArray()) {
			sm += (c-'0');
		}
		System.out.println(sm);
	}
}
