import java.io.*;
import java.util.*;

public class Main {
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int N;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			pq.offer(x);
		}
		int sum = 0;
		while (pq.size() != 1) {
			int st = pq.poll();
			int st1 = pq.poll();
			sum += st + st1;
			pq.offer(st + st1);
		}
		System.out.println(sum);
	}
}