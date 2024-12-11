

import java.io.*;
import java.util.*;

public class Main {
	static Map<String, ArrayList<String>> team = new HashMap<>();
	static Map<String, String> member = new HashMap<String, String>();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String idol = br.readLine();
			int memnum = Integer.parseInt(br.readLine());
			ArrayList<String> arr = new ArrayList<>();
			for (int j = 0; j < memnum; j++) {
				String name = br.readLine();
				arr.add(name);
				member.put(name, idol);
			}
			team.put(idol, arr);
		}
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			int k = Integer.parseInt(br.readLine());
		
			if (k == 1) {
				System.out.println(member.get(s));
			} else {
				ArrayList<String> temp = team.get(s);
				Collections.sort(temp);
				for(String names :temp) {
					System.out.println(names);
				}
			}
		}
	}
}
