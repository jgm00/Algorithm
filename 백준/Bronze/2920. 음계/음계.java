import java.util.*;
import java.io.*;

public class Main {
	static String s;
	static int ans = 0;
	static int[] asc = new int[8];
	static int[] des = new int[8];
	static int[] num = new int[8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 8; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		asc[0] = 1;
		asc[1] = 2;
		asc[2] = 3;
		asc[3] = 4;
		asc[4] = 5;
		asc[5] = 6;
		asc[6] = 7;
		asc[7] = 8;
		des[0] = 8;
		des[1] = 7;
		des[2] = 6;
		des[3] = 5;
		des[4] = 4;
		des[5] = 3;
		des[6] = 2;
		des[7] = 1;
		int flag1 = 0;
		for (int i = 0; i < 8; i++) {
			if (num[i] != asc[i]) {
				flag1 = 1;
			}
		}
		int flag2 = 0;
		for (int i = 0; i < 8; i++) {
			if (num[i] != des[i]) {
				flag2 = 1;
			}
		}
		if (flag1 == 0) {
			System.out.println("ascending");
		} else if (flag2 == 0) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}

	}
}
