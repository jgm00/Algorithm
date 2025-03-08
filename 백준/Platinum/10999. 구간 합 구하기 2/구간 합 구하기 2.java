

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int K;
	static long[] tree;
	static long[] nums;
	static long[] lazy;

	static long init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = nums[start];
		}
		int mid = (start + end) / 2;
		return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
	}

	static void lazy_update(int node, int start, int end) {
		if (lazy[node] == 0) {
			return;
		}
		tree[node] += (end - start + 1) * lazy[node];
		if (start != end) {
			lazy[node * 2] += lazy[node];
			lazy[node * 2 + 1] += lazy[node];
		}
		lazy[node] = 0;
	}

	static void update(int node, int start, int end, int left, int right, long diff) {
		lazy_update(node, start, end);
		if (end < left || right < start) {
			return;
		}
		if (left <= start && end <= right) {
			tree[node] += (end - start + 1) * diff;
			if (start != end) {
				lazy[node * 2] += diff;
				lazy[node * 2 + 1] += diff;
			}
			return;
		}

		int mid = (start + end) / 2;
		update(node * 2, start, mid, left, right, diff);
		update(node * 2 + 1, mid + 1, end, left, right, diff);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	static long sum(int node, int start, int end, int left, int right) {
		lazy_update(node, start, end);
		if (end < left || right < start) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		tree = new long[N * 4];
		nums = new long[N + 1];
		lazy = new long[N * 4];

		for (int i = 1; i <= N; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}

		init(1, 1, N);

		for (int i = 0; i < K + M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == 1) {
				int c = Integer.parseInt(st.nextToken());
				long d = Long.parseLong(st.nextToken());
				update(1, 1, N, b, c, d);
			} else if (a == 2) {
				int c = Integer.parseInt(st.nextToken());
				System.out.println(sum(1, 1, N, b, c));
			}
		}
	}
}