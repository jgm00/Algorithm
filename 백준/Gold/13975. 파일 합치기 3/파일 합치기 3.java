import java.io.*;
import java.util.*;

public class Main {
	static PriorityQueue<Long> pq = new PriorityQueue<>();
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<T; tc++) {
			Long sum = 0L;
			int k = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<k;i++) {
				Long a = Long.parseLong(st.nextToken());
				pq.offer(a);
			}
			while(pq.size() != 1) {
				Long s1 = pq.poll();
				Long s2 = pq.poll();
				sum += (s1+s2);
				pq.offer(s1 + s2);
			}
			System.out.println(sum);
			pq.poll();
		}
	}
}
