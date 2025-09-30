import java.util.*;
import java.io.*;

public class Solution {
    static Stack<Integer> stack = new Stack<>();
    public int[] solution(int []arr) {
        int[] answer = {};
        for(int k: arr){
            if(stack.isEmpty()){
                stack.add(k);
            }else{
                if(stack.peek() != k){
                    stack.add(k);
                }
            }
        }
        int N = stack.size();
        int[] temp = new int[N];
        answer = new int[stack.size()];
        for(int i=0;i<N;i++){
            temp[i] = stack.pop();
        }
        for(int i=0;i<N;i++){
            answer[i] = temp[N-i-1];
        }
        return answer;
    }
}