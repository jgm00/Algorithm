import java.io.*;
import java.util.*;

public class Main {

	static HashMap<Integer, String> hmap1 = new HashMap<>();
	static HashMap<String, Integer> hmap2 = new HashMap<>();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N+1; i++) {
			String name = br.readLine();
			hmap1.put(i, name);
			hmap2.put(name, i);
		}
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if(Character.isDigit(name.charAt(0))) {
				System.out.println(hmap1.get(Integer.parseInt(name)));
			} else {
				System.out.println(hmap2.get(name));
			}
		}
	}
}
