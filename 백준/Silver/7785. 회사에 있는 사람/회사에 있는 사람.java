import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> set1 = new HashSet<>();
		for(int i =0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String status = st.nextToken();
			if(status.equals("enter")) {
				set1.add(name);
			}else {
				set1.remove(name);
			}
		}
		List<String> lst = new ArrayList<>(set1);
		Collections.sort(lst, Collections.reverseOrder());
		for(int i = 0; i<lst.size(); i++) {
			System.out.println(lst.get(i));
		}
		
	}
}
