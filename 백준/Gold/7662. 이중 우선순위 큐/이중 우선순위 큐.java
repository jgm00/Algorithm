import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
			int K = Integer.parseInt(br.readLine());
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				int k = Integer.parseInt(st.nextToken());
				if (op.equals("I")) {
					tmap.put(k, tmap.getOrDefault(k, 0) + 1);
				} else {
					int num = 0;
					if (tmap.size() == 0)
						continue;
					if (k == 1) {
						num = tmap.lastKey();
					} else {
						num = tmap.firstKey();
					}
					int count = tmap.get(num);
					if (count != 1) {
						tmap.put(num, count - 1);
					} else {
						tmap.remove(num);
					}
				}
			}
			if (tmap.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(tmap.lastKey() + " " + tmap.firstKey());
			}
		}
	}
}