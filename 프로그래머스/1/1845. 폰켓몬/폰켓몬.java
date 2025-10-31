import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static HashSet<Integer> hset = new HashSet<>();
    public int solution(int[] nums) {
        int answer = 0;
        for(int k: nums){
            hset.add(k);
        }
        int N = nums.length;
        if(hset.size() <= N/2){
            answer = hset.size();
        }else{
            answer = N/2;
        }
        return answer;
    }
}