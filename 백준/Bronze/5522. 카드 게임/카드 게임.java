import java.util.*;
import java.io.*;

public class Main
{
    static int N,S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int sm = 0;
    	for(int i=1;i<=5;i++){
    	    int k = Integer.parseInt(br.readLine());
    	    sm += k;
    	}
    	System.out.println(sm);
	}
}