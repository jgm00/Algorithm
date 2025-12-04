import java.util.*;
import java.io.*;

public class Main
{
    static int A,B;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
	    B = sc.nextInt();
        System.out.print((B-A) + " " + B);
	}
}