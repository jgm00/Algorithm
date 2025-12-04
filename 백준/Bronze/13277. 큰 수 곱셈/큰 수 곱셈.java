import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main
{
    static BigInteger A,B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    	A = new BigInteger(st.nextToken());
        B = new BigInteger(st.nextToken());
        System.out.println(A.multiply(B));
	}
}