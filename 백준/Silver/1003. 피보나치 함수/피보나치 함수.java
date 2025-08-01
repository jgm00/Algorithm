import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] Fibo;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Fibo = new int[41][2];
		int T = Integer.parseInt(br.readLine());
		Fibo[0][0] = 1;
		Fibo[0][1] = 0;
		Fibo[1][0] = 0;
		Fibo[1][1] = 1;
		for (int j = 2; j <= 40; j++) {
				Fibo[j][0] = Fibo[j - 1][0] + Fibo[j - 2][0];
				Fibo[j][1] = Fibo[j - 1][1] + Fibo[j - 2][1];
		}
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			System.out.println(Fibo[k][0] + " " + Fibo[k][1]);
		}
	}
}
