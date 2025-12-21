import java.util.*;
import java.io.*;

public class Main
{
    static long N;
    static int[] numx,numy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		System.out.println(N*4);
	}
}