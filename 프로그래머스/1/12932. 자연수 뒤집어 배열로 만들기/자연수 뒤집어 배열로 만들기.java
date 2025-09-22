import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n%10);
            n /= 10;
        }
        int sz = sb.length();
        String s = sb.toString();
        answer = new int[sz];
        for(int i=0; i<sz; i++){
            answer[i] = s.charAt(i) - '0';
        }
        return answer;
    }
}