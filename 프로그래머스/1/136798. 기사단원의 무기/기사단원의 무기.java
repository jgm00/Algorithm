import java.util.*;
import java.io.*;

class Solution {
    static int cal(int a){
        int cnt = 0;
        for(int i=1;i<=Math.sqrt(a);i++){
            if(a%i == 0){
                if(i*i == a){
                    cnt += 1;
                }else{
                    cnt += 2;
                }
                
            }
        }
        return cnt;
    }
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            int k = cal(i);
            if(k>limit){
                answer += power;
            }else{
                answer += k;
            }
        }
        return answer;
    }
}