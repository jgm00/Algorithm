import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static PriorityQueue<Integer> Mxpq = new PriorityQueue<Integer>(Collections.reverseOrder());;
	static PriorityQueue<Integer> Mnpq = new PriorityQueue<Integer>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int k = sc.nextInt();
			if (Mnpq.size() == Mxpq.size()) {
				Mnpq.offer(k);
			} else {
				Mxpq.offer(k);
			}
			if (Mxpq.isEmpty() == false && Mnpq.isEmpty() == false) {
				if (Mxpq.peek() > Mnpq.peek()) {
					int temp = Mxpq.poll();
					int tmp = Mnpq.poll();
					Mxpq.offer(tmp);
					Mnpq.offer(temp);
				}
			}

			if (Mnpq.size() == Mxpq.size()) {
				sb.append(Mxpq.peek()).append("\n");
			} else {
				sb.append(Mnpq.peek()).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
