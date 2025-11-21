import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static String s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
		while(N-- > 0){
            s = br.readLine();
            System.out.println(s.charAt(0)+""+s.charAt(s.length()-1));
        }
	}
}

