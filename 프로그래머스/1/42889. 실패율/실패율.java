import java.util.*;
import java.io.*;

class Solution {
    static class Pair{
        int x;
        double y;
        Pair(int x, double y){
            this.x = x;
            this.y = y;
        }
    }
    static Pair[] ps;
    static HashMap<Integer, Integer> hmap = new HashMap<>();
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int sm = stages.length;
        ps = new Pair[N];
        for(int k : stages){
            hmap.put(k, hmap.getOrDefault(k,0)+1);
        }
        for(int i=1;i<N+1;i++){
            int t = 0;
            if(hmap.get(i) == null){
                t = 0;
            }else{
                t = hmap.get(i);
            }
            if(sm == 0){
                ps[i-1] = new Pair(i,(double)0);
            }else{
                ps[i-1] = new Pair(i,(double) t/sm);
            }
            sm -= t;
        }
        Arrays.sort(ps,(o1,o2)->{
            if(o1.y==o2.y){
                return o1.x-o2.x;
            }
            return Double.compare(o2.y, o1.y);
        });
        for(int i=0;i<N;i++){
            answer[i] = ps[i].x;
        }
        return answer;
    }
}