import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int range = 2; int idx = 1;
		if(N == 1){
		    System.out.println(idx);
            return;
		}
		while(range <= N){
		    range += (6*idx);
		    idx++;
		}
		System.out.println(idx);
	}
}