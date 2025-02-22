import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				pq.offer(a);
			}
		}
		for(int i=0;i<N-1;i++) {
			pq.poll();
		}
		System.out.println(pq.poll());
	}
}
