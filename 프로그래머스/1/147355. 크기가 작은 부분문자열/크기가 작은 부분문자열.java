import java.util.*;
import java.io.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for(int i=0;i<t.length()-p.length()+1;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(t.substring(i,i+p.length()));
            String s = sb.toString();
            if(s.compareTo(p) <= 0){
                answer += 1;
            }
        }
        
        return answer;
    }
}