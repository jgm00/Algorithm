import java.util.*;
import java.io.*;

public class Main
{
    static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String tar = br.readLine();
		int sz = tar.length();
		for(int i = 0; i<s.length();i++){
		    char c = s.charAt(i);
		    stack.add(c);
		    if(stack.size() >= tar.length() && c == tar.charAt(tar.length()-1)){
		        StringBuilder sb = new StringBuilder();
		        for(int j=0; j<sz;j++){
		            sb.append(stack.pop());
		        }
    	        if(!sb.reverse().toString().equals(tar)){
	               for(char cc : sb.toString().toCharArray()){
	                   stack.add(cc);
	               }
	            }
		    }
		}
		String answer = "";
		if(stack.size() == 0){
		    answer = "FRULA";
		}else{
    		StringBuilder ans = new StringBuilder();
    		while(stack.size() != 0){
    		    ans.append(stack.pop());
    		}
    		System.out.println(ans.reverse());
		}
        System.out.println(answer);
		
	}
}