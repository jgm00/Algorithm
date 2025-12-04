import java.util.*;
import java.io.*;
import java.math.*;

public class Main
{
    static BigInteger  A,B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = new BigInteger(br.readLine());
	    B = new BigInteger(br.readLine());
        System.out.print(A.add(B));
	}
}