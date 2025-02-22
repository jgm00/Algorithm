import java.io.*;
import java.util.*;

public class Main {
	static int x, N;
	static int[] temp;
	static PriorityQueue<Integer> pq;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		pq = new PriorityQueue<Integer>();
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if (x == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				pq.offer(x);
			}
		}
	}
}
