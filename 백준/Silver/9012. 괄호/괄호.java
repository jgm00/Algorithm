import java.util.*;
import java.io.*;

public class Main
{
    static int T;
    static Stack<Character> stk;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    T = Integer.parseInt(br.readLine());
	    for(int i =0;i<T; i++){
	       stk = new Stack<>();
	       String s = br.readLine();
	       for(int j  = 0; j< s.length(); j++){
	           char c = s.charAt(j);
	           if(stk.isEmpty()) {
	           stk.push(c);}else{
	               if( stk.peek() == '(' && c ==')'){
	                   stk.pop();
	               }else{
	                   stk.push(c);
	               }
	           }
	       }
	       if(stk.isEmpty()){
	           System.out.println("YES");
	       }else{
	           System.out.println("NO");
	       }
	    }
	}
}