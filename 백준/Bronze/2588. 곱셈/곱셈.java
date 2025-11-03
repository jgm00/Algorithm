import java.util.*;
import java.io.*;

public class Main
{   static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        String B = br.readLine();
        int a = B.charAt(0) - '0';
        int b = B.charAt(1) - '0';
        int c = B.charAt(2) - '0';
        int aa = A * c;
        int bb = A * b;
        int cc = A * a;
        System.out.println(aa);
        System.out.println(bb);
        System.out.println(cc);
        System.out.println(cc*100 + bb*10 + aa);

	}
}