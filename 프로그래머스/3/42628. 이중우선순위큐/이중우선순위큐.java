import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static PriorityQueue<Integer> mxpq = new PriorityQueue<>(Collections.reverseOrder());
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        for(String str : operations){
            String[] st = str.split(" ");
            String op = st[0];
            int num = Integer.parseInt(st[1]);
            if(op.equals("I")){
                pq.add(num);
                mxpq.add(num);
            }else if(op.equals("D")){
                if(mxpq.isEmpty() || pq.isEmpty()) continue;
                if(num == -1){
                    int k = pq.poll();
                    mxpq.remove(k);
                }else{
                    int k = mxpq.poll();
                    pq.remove(k);
                }
            }
        }
        if(mxpq.isEmpty()){
            answer[0] = 0;
        }else if(pq.isEmpty()){
            answer[1] = 0;
        }else{
            answer[0] = mxpq.poll();
            answer[1] = pq.poll();
        }
        return answer;
    }
}