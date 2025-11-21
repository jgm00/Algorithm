import java.util.*;
import java.io.*;

public class Main {
	static String s;
	static int sm = 0;
	static int[] dial = new int[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		dial[0] = 3;
		dial[1] = 3;
		dial[2] = 3;
		dial[3] = 4;
		dial[4] = 4;
		dial[5] = 4;
		dial[6] = 5;
		dial[7] = 5;
		dial[8] = 5;
		dial[9] = 6;
		dial[10] = 6;
		dial[11] = 6;
		dial[12] = 7;
		dial[13] = 7;
		dial[14] = 7;
		dial[15] = 8;
		dial[16] = 8;
		dial[17] = 8;
		dial[18] = 8;
		dial[19] = 9;
		dial[20] = 9;
		dial[21] = 9;
		dial[22] = 10;
		dial[23] = 10;
		dial[24] = 10;
		dial[25] = 10;
		for (char c : s.toCharArray()) {
			sm += dial[c - 'A'];
		}
		System.out.println(sm);
	}
}
