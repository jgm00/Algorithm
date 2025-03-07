

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static long[] tree;
    static long[] nums;

    static long init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = nums[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
    }

    static void update(int node, int start, int end, int idx, long diff) {
        if (end < idx || idx < start) {
            return;
        }

        tree[node] += diff;

        if (start != end) {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, idx, diff);
            update(node * 2 + 1, mid + 1, end, idx, diff);
        }
    }

    static long sum(int node, int start, int end, int left, int right) {
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
        
        for (int i = 1; i <= N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }
        
        init(1, 1, N);
        
        for (int i = 0; i < K + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                update(1, 1, N, b, c - nums[b]);
                nums[b] = c;
            } else if (a == 2) {
                int c = Integer.parseInt(st.nextToken());
                System.out.println(sum(1, 1, N, b, c));
            }
        }
    }
}