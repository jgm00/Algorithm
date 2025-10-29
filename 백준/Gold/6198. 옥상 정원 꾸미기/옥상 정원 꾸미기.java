import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static long answer;
    static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++){
		    int k = Integer.parseInt(br.readLine());
		    if(stack.isEmpty()){
		        stack.add(k);
		    }else{
		        while(true){
		            if(stack.isEmpty()){
		                break;
		            }
		            if(stack.peek()<=k){
		                stack.pop();
		            }else{
		                break;
		            }
		        }
		        
	            stack.add(k);
	            answer += (stack.size()-1);
	           
		    }
		}
		 System.out.println(answer);
	}
}