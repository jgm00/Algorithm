import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        for(int i=chs.length-1;i>=0;i--){
            answer += chs[i];
        }
        return answer;
    }
}