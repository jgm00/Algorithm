import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Arrays.sort(strings,(o1,o2)->{
            if(o1.charAt(n)==o2.charAt(n)){
                return o1.compareTo(o2);
            }
            return o1.charAt(n) - o2.charAt(n);
        });
        for(int i=0;i<answer.length;i++){
            answer[i] = strings[i];
        }
        return answer;
    }
}