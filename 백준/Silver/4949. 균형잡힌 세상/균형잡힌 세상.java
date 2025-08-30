import java.util.*;
import java.io.*;

public class Main
{
    static Stack<Character> q = new Stack<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String ans = "no";
        while(true){
            ans = "no";
            q = new Stack<>();
            String s = br.readLine();
            if(s.equals(".")) break;
            boolean flag = true;
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(c == '(' || c == '['){
                    q.add(c);
                }else{
                    if(c == ')'){
                        if(q.isEmpty()){
                            flag = false;
                        }else if(q.peek() != '('){
                            flag = false;
                        }else{
                            q.pop();
                        }
                    } else if(c == ']'){
                        if(q.isEmpty()){
                            flag = false;
                        }else if(q.peek() != '['){
                            flag = false;
                        }else{
                            q.pop();
                        }
                    }
                }
            }
            if(flag == true && q.isEmpty()){
                ans = "yes";
            }
            System.out.println(ans);
        }
	}
}