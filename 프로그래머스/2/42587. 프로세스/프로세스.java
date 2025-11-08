import java.util.*;
import java.io.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    static Queue<Integer> q = new LinkedList<>();
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] ans = new int[priorities.length+1];
        for(int k : priorities){
            pq.add(k);
        }
        for(int i = 0; i<priorities.length;i++){
            q.add(i);
        }
        int idx = 0;
    while(!q.isEmpty()){
        int k = q.poll();
        if(priorities[k] != pq.peek()){
            q.add(k);
        }else{
            idx += 1;
            ans[k] = idx;
            pq.poll();
        }
    }
        answer = ans[location];
        return answer;
    }
}