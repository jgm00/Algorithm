import java.util.*;
import java.io.*;

public class Main
{
    static int N,S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++){
            System.out.print("Hello World, Judge ");
            System.out.println(i+"!");
        }
	}
}