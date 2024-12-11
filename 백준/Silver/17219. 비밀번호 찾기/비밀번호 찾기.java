import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, String> hmap = new HashMap<String, String>();
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String add = st.nextToken();
			String password = st.nextToken();
			hmap.put(add,password);	
		}
		StringWriter sw = new StringWriter();
		for(int j = 0; j<M; j++) {
			String s = br.readLine();
			sw.write(hmap.get(s)+"\n");
		}
		System.out.println(sw.toString());
	}
}
