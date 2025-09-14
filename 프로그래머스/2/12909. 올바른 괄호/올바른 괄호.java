import java.util.*;
import java.io.*;

class Solution {
    static Stack<Character> stk = new Stack<>();
    boolean solution(String s)  {
        boolean answer = true;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                stk.add(c);
            }else{
                if(!stk.isEmpty()){
                    if(stk.peek() == '('){
                        stk.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if(stk.isEmpty()){
            answer = true;
        }else{
            answer = false;
        }
        return answer;
    }
}