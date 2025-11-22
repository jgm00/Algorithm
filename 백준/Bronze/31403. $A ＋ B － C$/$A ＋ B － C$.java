import java.util.*;
import java.io.*;

public class Main {
	static int C;
	static String A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine();
		B = br.readLine();
		C = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append(A).append(B);
		int kk = Integer.parseInt(sb.toString());
		long ans2 = kk - C;
		long ans1 = Integer.parseInt(A) + Integer.parseInt(B) - C;
		System.out.println(ans1);
		System.out.println(ans2);
	}
}
