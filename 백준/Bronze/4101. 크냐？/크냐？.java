import java.util.*;
import java.io.*;

public class Main
{
    static int N,S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		if(a == 0 && b == 0){
    		    break;
    		}
    		if(a <= b){
    		    System.out.println("No");
    		}else{
    		    System.out.println("Yes");
    		}
		}

	}
}