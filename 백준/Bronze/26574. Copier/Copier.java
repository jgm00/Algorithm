import java.io.*;
import java.util.*;

public class Main
{
    static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++){
		    int k = Integer.parseInt(br.readLine());
		    System.out.println(k + " " + k);
		}
	}
}