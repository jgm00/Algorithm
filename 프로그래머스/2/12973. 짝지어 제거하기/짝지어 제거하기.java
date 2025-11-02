import java.util.*;
import java.io.*;

class Solution
{
    static Stack<Character> stack = new Stack<>();
    public int solution(String s)
    {
        int answer = -1;
        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.add(c);
            }else{
                if(stack.peek() != c){
                    stack.add(c);
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            answer = 1;
        }else{
            answer = 0;
        }
        return answer;
    }
}