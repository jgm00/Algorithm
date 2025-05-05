import java.util.*;
import java.io.*;

class Solution {
    static HashSet<Integer> hset;
    public int solution(int[] nums) {
        int answer = 0;
        hset = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            //System.out.println(nums[i]);
            hset.add(nums[i]);
        }
        if(nums.length/2 < hset.size()){
            answer = nums.length/2;
        }else{
            answer = hset.size();
        }
        return answer;
    }
}