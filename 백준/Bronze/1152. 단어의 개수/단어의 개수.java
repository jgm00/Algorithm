import java.util.*;
import java.io.*;

public class Main {
	static String s;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		String[] str = s.split(" ");
		for (String ss : str) {
			if (!ss.equals("")) {
				cnt += 1;
			}
		}
		System.out.println(cnt);
	}
}
