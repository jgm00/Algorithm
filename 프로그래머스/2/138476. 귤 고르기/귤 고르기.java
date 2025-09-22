import java.util.*;
import java.io.*;

class Solution {
    static int[] num;
    static int mx = Integer.MIN_VALUE;
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        num = new int[10000001];
        for(int i=0;i<tangerine.length;i++){
            num[tangerine[i]]+=1;
            mx = Math.max(tangerine[i],mx);
        }
        int[] ans = new int[mx+1];
        for(int i=0;i<=mx; i++){
            ans[i] = num[i];
        }
        Arrays.sort(ans);
        for(int i=ans.length -1;i>=0;i--){
            k-=ans[i];
            answer += 1;
            if(k<=0){
                break; 
            }
        }
        return answer;
    }
}