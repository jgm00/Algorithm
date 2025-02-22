import java.io.*;
import java.util.*;

public class Main {
	static int x, N;
	static int[] heap;
	static int sz;

	static void swap(int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}

	static void push(int k) {
		heap[++sz] = k;
		int cur = sz;
		while (cur != 1) {
			int par = cur / 2;
			if (heap[par] < heap[cur]) {
				swap(par, cur);
			}
			cur = par;
		}
	}

	static int pop() {
		if (sz == 0) {
			return 0;
		}
		int temp = heap[1];
		int cur = 1;
		heap[1] = heap[sz--];
		while (cur*2<= sz) {
			int l = 2 * cur;
			int r = 2 * cur + 1;
			int mn_idx = l;
			if (r <= sz && heap[l] < heap[r]) {
				mn_idx = r;
			}
			if (heap[cur] < heap[mn_idx]) {
				swap(cur, mn_idx);
			}
			cur = mn_idx;
		}
		return temp;
	}

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		heap = new int[100000];
		for (int i = 0; i < N; i++) {
			x = sc.nextInt();
			if (x == 0) {
				System.out.println(pop());
			} else {
				push(x);
			}
		}
	}
}
