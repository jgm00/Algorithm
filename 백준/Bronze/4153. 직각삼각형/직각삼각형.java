import java.util.*;
import java.io.*;

public class Main
{
    static int a,b,c, mx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    if(a==0 && b==0 && c == 0) break;
		    mx = Math.max(a,b);
		    mx = Math.max(mx,c);
		    if(a==mx){
		        if(c*c + b*b == mx*mx){
    		        System.out.println("right");
    		    }else{
    		        System.out.println("wrong");
    		    }
		    }else if(b==mx){
		        if(a*a + c*c == mx*mx){
    		        System.out.println("right");
    		    }else{
    		        System.out.println("wrong");
    		    }
		    }else if(c==mx){
		        if(a*a + b*b == mx*mx){
    		        System.out.println("right");
    		    }else{
    		        System.out.println("wrong");
    		    }
		    }
		    
		}
	}
}