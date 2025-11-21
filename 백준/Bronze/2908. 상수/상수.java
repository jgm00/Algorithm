import java.util.*;
import java.io.*;

public class Main {
	static String s;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s1 = st.nextToken();
		StringBuilder sb = new StringBuilder();
		for(int i=s1.length()-1;i>=0;i--) {
			sb.append(s1.charAt(i));
		}
		int k1 = Integer.parseInt(sb.toString());
		sb = new StringBuilder();
		String s2 = st.nextToken();
		for(int i=s2.length()-1;i>=0;i--) {
			sb.append(s2.charAt(i));
		}
		int k2 = Integer.parseInt(sb.toString());
		ans = Math.max(k1, k2);
		System.out.println(ans);
	}
}
