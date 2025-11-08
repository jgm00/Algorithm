import java.util.*;
import java.io.*;

class Solution {
    static int[] nums;
    static ArrayList<Integer> alst = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        nums = new int[progresses.length];
        for(int i=0;i<progresses.length;i++){
            if((100-progresses[i]) % speeds[i] == 0){
                nums[i] = (100-progresses[i]) / speeds[i];
            }else{
                nums[i] = 1 + (100-progresses[i]) / speeds[i];
            }
        }
        for(int i=0;i<progresses.length;i++){
            q.add(nums[i]);
        }
        int now = q.poll(); int count = 1;
        while(!q.isEmpty()){
            if(now < q.peek()){
                alst.add(count);
                now = q.poll();
                count = 1;
            }else{
                q.poll();
                count += 1;
            }
        }
        alst.add(count);
        answer = new int[alst.size()];
        for(int i=0;i<alst.size();i++){
            answer[i] = alst.get(i);
        }
        return answer;
    }
}