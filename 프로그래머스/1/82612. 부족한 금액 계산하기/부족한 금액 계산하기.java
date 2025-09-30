import java.util.*;
import java.io.*;

class Solution {
    
    public long solution(int price, int money, int count) {
        long answer = money;
        long tmp = 0;
        for(int i=1; i<=count;i++){
            tmp += (price * i);
        }
        answer -= tmp;
        if(answer < 0){
            answer *= -1;
        }else{
            answer = 0;
        }
        return answer;
    }
}