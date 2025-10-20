import java.util.*;
import java.io.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int idx = 0;
        for(int num : score){
            if(pq.size()>=k){
                if(pq.peek()<num){
                    pq.poll();
                    pq.add(num);
                }
            }else{
                pq.add(num);
            }
            answer[idx++] = pq.peek();
        }
        return answer;
    }
}