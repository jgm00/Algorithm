import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int tcnt = 0;
        Arrays.sort(citations);
        for(int i=citations[citations.length-1];i>=0;i--){
            int h = i;
            tcnt = 0;
            for(int j=citations.length-1;j>=0;j--){
                if(citations[j] >= h){
                    tcnt += 1;
                }
            }
            if(tcnt >= h && h >= citations.length-tcnt){
                answer = h;
                break;
            };
        }
        return answer;
    }
}