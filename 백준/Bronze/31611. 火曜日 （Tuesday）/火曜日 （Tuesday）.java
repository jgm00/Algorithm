import java.util.*;
import java.io.*;

public class Main
{
    static int N,S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	if(N%7 == 2){
    	    System.out.println(1);
    	}else{
    	    System.out.println(0);
    	}
        
	}
}