import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sm = brown+yellow;
        for(int i=yellow;i>0; i--){
            if(yellow%i==0){
                if(sm ==(i+2) * (yellow/i+2)){
                    System.out.println(i);
                    answer[1] = (yellow/i+2);
                    answer[0] = (i+2);
                    break;
                }
            }
            
        }
        return answer;
    }
}