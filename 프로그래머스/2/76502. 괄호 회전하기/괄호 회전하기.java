import java.util.*;
import java.io.*;

class Solution {
    static Stack<Character> sk = new Stack<>();
    static boolean chk(String s){
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                sk.add(c);
            }
            if(c == ']'){
                if(sk.isEmpty()){
                    return false;
                }
                if(sk.peek() == '['){
                    sk.pop();
                }
            }else if(c == ')'){
                if(sk.isEmpty()){
                    return false;
                }
                if(sk.peek() == '('){
                    sk.pop();
                }
            }else if(c == '}'){
                if(sk.isEmpty()){
                    return false;
                }
                if(sk.peek() == '{'){
                    sk.pop();
                }
            }
        }
        if(!sk.isEmpty()){
            return false;
        }
        return true;
    }
    static String md(String s){
        String answer = "";
        answer += s.substring(1,s.length());
        answer += s.charAt(0);
        return answer;
    }
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++){
            s = md(s);
            if(chk(s) == true){
                answer += 1;
            }
        }
        return answer;
    }
}