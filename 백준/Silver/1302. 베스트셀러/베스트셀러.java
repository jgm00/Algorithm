import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static HashMap<String, Integer> hmap;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		hmap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (hmap.containsKey(str)) {
				hmap.put(str, hmap.get(str) + 1);
			} else {
				hmap.put(str, 1);
			}
		}
		List<Map.Entry<String, Integer>> hlist = new LinkedList<>(hmap.entrySet());
		Collections.sort(hlist, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o1.getValue() == o2.getValue()) {
					return o1.getKey().compareTo(o2.getKey());
				}
				return o2.getValue() - o1.getValue();
			}
		});
		System.out.println(hlist.get(0).getKey());
	}
}