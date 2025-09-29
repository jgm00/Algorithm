import java.util.*;
import java.io.*;

class Solution {
    static int[] num = new int[10];
    public int solution(int[] numbers) {
        int answer = 0;
        for(int k : numbers){
            num[k] = 1;
        }
        for(int i = 0; i<10;i++){
            if(num[i] == 0){
                answer += i;
            }
        }
        return answer;
    }
}