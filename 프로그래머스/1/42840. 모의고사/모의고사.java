import java.util.*;
import java.io.*;

class Solution {
    static int[] num1 = {1,2,3,4,5};
    static int[] num2 = {2,1,2,3,2,4,2,5};
    static int[] num3 = {3,3,1,1,2,2,4,4,5,5};
    static int mx = -1;
    static int[] tmp = new int[4];
    static int ans = 0;
    static ArrayList<Integer> temp = new ArrayList<>();
    static void cal(int[] num, int k, int[] answers, int m){
        int cnt = 0;
        for(int i=0;i<answers.length;i++){
            if(num[i%k]==answers[i]){
                cnt += 1;
            }
        }
        tmp[m] = cnt;
        if(mx <= cnt){
            mx = cnt;
        }
    }
    public int[] solution(int[] answers) {
        int[] answer = {};
        int idx = 0; int cntt = 0;
        cal(num1,num1.length,answers,1);
        cal(num2,num2.length,answers,2);
        cal(num3,num3.length,answers,3);
        for(int i=1;i<=3;i++){
            if(tmp[i]==mx){
                cntt += 1;
            }
        }
        answer = new int[cntt];
        for(int i=1;i<=3;i++){
            if(tmp[i]==mx){
                answer[idx++]=i;
            }
        }
        return answer;
    }
}