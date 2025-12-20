import java.util.*;
import java.io.*;

public class Main
{
    static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    long a = Long.parseLong(st.nextToken());
		    long b = Long.parseLong(st.nextToken());
		    System.out.println(a+b);
		}
	}
}