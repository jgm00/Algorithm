import java.util.*;
import java.io.*;

public class Main
{
    static long N,S;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		if(N*N <= 100000000){
		    System.out.println("Accepted");
		}else{
		    System.out.println("Time limit exceeded");
		}
	}
}