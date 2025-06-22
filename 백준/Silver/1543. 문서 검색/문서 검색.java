import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		Boolean flag = false;
		int cnt = 0;
		for (int i = 0; i < str1.length() - str2.length()+1; i++) {
			flag = false;
			for (int j = 0; j < str2.length(); j++) {
				if (str2.charAt(j) != str1.charAt(j + i)) {
					flag = true;
				}
			}
			if(flag == false) {
				i+=str2.length()-1;
				cnt += 1;
			}
		}
		System.out.println(cnt);
	}
}