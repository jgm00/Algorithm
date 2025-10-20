import java.io.*;
import java.util.*;

class Solution {
    static boolean[] prime;
    static void cal(int n){
        prime = new boolean[n+1];
        Arrays.fill(prime,true);
        prime[0] = false;
        prime[1] = false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(prime[i]==false) continue;
            for(int j=i*i; j<=n;j+=i){
                prime[j] = false;
            }
        }
    }
    public int solution(int n) {
        int answer = 0;
        cal(n);
        for(int i=1;i<=n;i++){
            if(prime[i]){
                answer += 1;
            }
        }
        return answer;
    }
}