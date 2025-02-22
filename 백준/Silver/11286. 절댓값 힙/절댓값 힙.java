import java.io.*;
import java.util.*;

public class Main {

	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> {
		if (Math.abs(o1) == Math.abs(o2)) {
			return o1 < o2 ? -1 : 1;
		}
		return Math.abs(o1) < Math.abs(o2) ? -1 : 1;
	});

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int k = sc.nextInt();
			if (k != 0) {
				pq.offer(k);
			} else {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll());
				}
			}
		}
	}
}
