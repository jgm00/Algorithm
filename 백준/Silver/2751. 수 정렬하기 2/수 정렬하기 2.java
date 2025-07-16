import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr, temp;
	static StringBuilder sb = new StringBuilder();

	static void merge(int st, int en) {
		int mid = (st + en) / 2;
		int lidx = st;
		int ridx = mid;
		for (int i = st; i < en; i++) {
			if (ridx == en) {
				temp[i] = arr[lidx++];
			} else if (mid == lidx) {
				temp[i] = arr[ridx++];
			} else if (arr[lidx] <= arr[ridx]) {
				temp[i] = arr[lidx++];
			} else {
				temp[i] = arr[ridx++];
			}
		}
		for (int j = st; j < en; j++) {
			arr[j] = temp[j];
		}
	}

	static void merge_sort(int st, int en) {
		int mid = (st + en) / 2;
		if (st + 1 == en) {
			return;
		}
		merge_sort(st, mid);
		merge_sort(mid, en);
		merge(st, en);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		temp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		merge_sort(0, N);
		for (int num : arr) {
			sb.append(num+"\n");
		}
		System.out.println(sb.toString());
	}
}