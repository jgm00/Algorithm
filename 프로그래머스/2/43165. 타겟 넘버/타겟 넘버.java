import java.util.*;
import java.io.*;

class Solution {
    static int N,cnt,Mytar;
    static void dfs(int k, int sum, int[] numbers){
        if(k == N){
            if(sum == Mytar){
                cnt += 1;
            }
            return;
        }
        dfs(k+1, sum+numbers[k],numbers);
        dfs(k+1, sum-numbers[k],numbers);
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Mytar = target;
        N = numbers.length;
        dfs(0,0,numbers);
        return cnt;
    }
}