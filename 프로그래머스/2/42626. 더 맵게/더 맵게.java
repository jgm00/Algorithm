import java.util.*;
import java.io.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    public int solution(int[] scoville, int K) {
        int answer = 0;
        for(int k : scoville){
            pq.add(k);
        }
        while(!pq.isEmpty()){
            int a = pq.poll();
            if(a >= K){
                break;
            }
            if(pq.size() == 0){
                answer = -1;
                break;
            }
            int b = pq.poll();
            int c = a + (b*2);
            pq.add(c);
            answer += 1;
        }
        return answer;
    }
}