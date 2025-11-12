import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int ans = n;
        Arrays.sort(lost); Arrays.sort(reserve);
        for(int i=0;i<reserve.length;i++){
            for(int j=0;j<lost.length;j++){
                if(reserve[i] == lost[j]){
                    lost[j]=-1;
                    reserve[i] = -1;
                    break;
                }
            }
        }      
        for(int i=0;i<reserve.length;i++){
            if(reserve[i] == -1) continue;
            for(int j=0;j<lost.length;j++){
                if(lost[j] == -1) continue;
                if(reserve[i] - 1 == lost[j] || reserve[i] + 1 == lost[j]){
                    lost[j] = -1;
                    break;
                }
            }
        }
        for(int k : lost){
            if(k!=-1){
                answer += 1;
            }
        }
        return n - answer;
    }
}