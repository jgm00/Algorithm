import java.util.*;
import java.io.*;

class Solution {
    static boolean[] prime;
    static void cal(int N){
        prime[0] = false;
        prime[1] = false;
        for(int i=2; i<=Math.sqrt(N);i++){
            if(prime[i] == false) continue;
            for(int j=i*i;j<=N; j+=i){
                prime[j] = false;
            }
        } 
    }
    public int solution(int[] nums) {
        int answer = 0;
        int M  = nums.length;
        prime = new boolean[3001];
        Arrays.fill(prime,true);
        cal(3001);
        int sm = 0;
        for(int i=0;i<M;i++){
            for(int j=(i+1); j<M;j++){
                for(int k=(j+1);k<M;k++){
                    sm += nums[i];
                    sm += nums[j];
                    sm += nums[k];
                    if(prime[sm]){
                        answer += 1;
                    }
                    sm = 0;
                }
            }
        }

        return answer;
    }
}