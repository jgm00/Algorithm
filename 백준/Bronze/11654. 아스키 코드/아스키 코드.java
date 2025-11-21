import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static String s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		char c = s.charAt(0);
		System.out.println((int) (c-'A'+'A'));
	}
}
