import java.util.*;
import java.io.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int sm = 0;
			int ans = 0;
			String s = br.readLine();
			for(int j=0;j<s.length();j++) {
				char c = s.charAt(j);
				if(c == 'O') {
					sm += 1;
				}else {
					for(int k = 1;k<=sm;k++) {
						ans += k;
					}
					sm = 0;
				}
			}
			for(int k = 1;k<=sm;k++) {
				ans += k;
			}
			System.out.println(ans);
		}
	}
}
