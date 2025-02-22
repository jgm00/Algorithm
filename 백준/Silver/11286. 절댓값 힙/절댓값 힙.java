import java.io.*;
import java.util.*;

public class Main {
	static int x;
	static int N;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> {
			if(Math.abs(o1) == Math.abs(o2)) {
				return o1 < o2 ? -1 : 1;
			}
			return Math.abs(o1) < Math.abs(o2) ? -1 : 1;
		});
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int k = sc.nextInt();
			if (k == 0) {
				if (pq.isEmpty() == false) {
					System.out.println(pq.poll());
				} else {
					System.out.println(0);
				}
			} else {
				pq.offer(k);
			}
		}
	}
}
