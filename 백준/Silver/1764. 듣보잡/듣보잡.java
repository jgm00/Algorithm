import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static HashSet<String> hset1, hset2;
	static ArrayList<String> alist;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		hset1 = new HashSet<>();
		for (int i = 0; i < N; i++) {
			hset1.add(br.readLine());
		}
		alist = new ArrayList<>();
		hset2 = new HashSet<>();
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (hset1.contains(s) == true) {
				alist.add(s);
			}
		}
		Collections.sort(alist);
		System.out.println(alist.size());
		for (int i = 0; i < alist.size(); i++) {
			System.out.println(alist.get(i));
		}
	}
}