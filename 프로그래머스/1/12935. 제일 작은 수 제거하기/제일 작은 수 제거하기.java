import java.util.*;
import java.io.*;

class Solution {
    static int mn = Integer.MAX_VALUE;
    public int[] solution(int[] arr) {
        int[] answer = {};
        if(arr.length == 1){
            return new int[]{-1};
        }
        for(int k : arr){
            mn = Math.min(mn,k);
        }
        int idx = 0;
        answer = new int[arr.length-1];
        for(int k: arr){
            if(mn == k){
                continue;
            }
            answer[idx++] = k;
        }
        return answer;
    }
}