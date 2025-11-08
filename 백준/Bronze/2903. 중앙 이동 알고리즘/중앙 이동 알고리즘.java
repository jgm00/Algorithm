import java.util.*;
import java.io.*;

public class Main
{
    static int N;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int tmp = (int) Math.pow(2,N) + 1;
        System.out.println(tmp*tmp);
	}
}