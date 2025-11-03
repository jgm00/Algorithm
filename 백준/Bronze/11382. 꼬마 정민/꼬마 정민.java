import java.util.*;
import java.io.*;

public class Main
{   static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long  A = Long.parseLong(st.nextToken());
        long  B = Long.parseLong(st.nextToken());
        long  C = Long.parseLong(st.nextToken());
        System.out.println(A+B+C);

	}
}