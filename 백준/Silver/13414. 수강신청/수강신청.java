import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> hmap1 = new HashMap<>();
		Map<Integer, String> hmap2 = new HashMap<>();
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (hmap1.containsKey(s) == false) {
				hmap1.put(s, i);
				hmap2.put(i, s);
			} else {
				hmap1.remove(s);
				hmap1.put(s, i);
				hmap2.put(i, s);
			}
		}
		ArrayList<Integer> temp = new ArrayList<>();
		for (Entry<String, Integer> entry : hmap1.entrySet()) {
			temp.add(entry.getValue());
		}
		Collections.sort(temp);
		int idx = 0;
		while (true) {
			if (idx >= N || idx >= temp.size()) {
				break;
			} 
				System.out.println(hmap2.get(temp.get(idx)));
				idx++;
		}
	}
}
