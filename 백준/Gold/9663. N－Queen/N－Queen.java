import java.util.*;
import java.io.*;

public class Main {

	static int cnt;
	static boolean[] vis1 = new boolean[100]; // y
	static boolean[] vis2 = new boolean[200]; // x+y : \ 대각선
	static boolean[] vis3 = new boolean[200];; // x-y+n-1 : / 대각선
	static int N;

	static void back(int x) {
		if (x == N) {
			cnt++;
			return;
		}

		for (int y = 0; y < N; y++) {
			if (vis1[y] || vis2[x + y] || vis3[x - y + N - 1]) continue;
				vis1[y] = true;
				vis2[x + y] = true;
				vis3[x - y + N - 1] = true;
				back(x + 1);
				vis1[y] = false;
				vis2[x + y] = false;
				vis3[x - y + N - 1] = false;
		}
	}
    
   
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		back(0);
        System.out.println(cnt);
	}
}