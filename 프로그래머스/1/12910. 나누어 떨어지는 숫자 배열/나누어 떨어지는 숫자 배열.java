import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int cnt = 0;
        for(int k : arr){
            if(k % divisor == 0){
                cnt += 1;
            }
        }
        if(cnt == 0){
            return new int[]{-1};
        }
        answer = new int[cnt];
        int idx = 0;
        for(int k : arr){
            if(k % divisor == 0){
                answer[idx++] = k;
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}