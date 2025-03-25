import java.util.*;
import java.io.*;

public class Main {
	static String[] arr = { "a", "e", "i", "o", "u" };
	static String arr1 = "aeiou";
	static boolean isflag = true;

	static boolean check(String str) {
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (str.contains(arr[i])) {
				cnt += 1;
			}
		}
		if (cnt == 0) {
			return false;
		}
		return true;
	}

	static boolean check2(String str) {
		int mcnt = 0;
		int jcnt = 0;
		for (int i = 1; i < str.length(); i++) {
			char c = str.charAt(i);
			char prevc = str.charAt(i - 1);
			boolean ism = false;
			boolean ispm = false;
			for (int j = 0; j < 5; j++) {
				if (arr1.charAt(j) == c) {
					ism = true;
				}
				if (arr1.charAt(j) == prevc) {
					ispm = true;
				}
			}
			if (ism == true && ispm == true) {
				mcnt += 1;
				jcnt = 0;
			} else if (ism == true && ispm == false) {
				mcnt = 0;
				jcnt = 0;
			} else if (ism == false && ispm == true) {
				mcnt = 0;
				jcnt = 0;
			} else {
				mcnt = 0;
				jcnt += 1;
			}
			if (mcnt == 2) {
				return false;
			} else if (jcnt == 2) {
				return false;
			}
		}
		return true;
	}

	static boolean check3(String str) {
		for (int i = 1; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == str.charAt(i - 1) && c != 'e' && c != 'o') {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = " ";
		while (true) {
			str = br.readLine();
			if (str.equals("end") == true)
				break;
			if (check(str) == false || check2(str) == false || check3(str) == false) {
				System.out.println("<" + str + "> is not acceptable.");
			} else {
				System.out.println("<" + str + "> is acceptable.");
			}
		}
	}
}