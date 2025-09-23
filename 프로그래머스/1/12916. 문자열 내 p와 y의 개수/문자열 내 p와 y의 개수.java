import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pcnt = 0;
        int ycnt = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == 'P' || c == 'p'){
                pcnt += 1;
            }
            if(c == 'Y' || c == 'y'){
                ycnt += 1;
            }
        }
        if(pcnt == ycnt){
            answer = true;
        }else{
            answer = false;
        }
        return answer;
    }
}