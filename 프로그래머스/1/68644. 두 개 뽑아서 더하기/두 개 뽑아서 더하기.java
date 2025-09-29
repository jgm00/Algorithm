import java.util.*;
import java.io.*;

class Solution {
    static HashSet<Integer> hset = new HashSet<>();
    public int[] solution(int[] numbers) {
        int[] answer = {};
        for(int i=0;i<numbers.length;i++){
            for(int j=(i+1);j<numbers.length;j++){
                hset.add((numbers[j] + numbers[i]));
            }
        }
        answer = new int[hset.size()];
        int idx = 0;
        Iterator iter = hset.iterator();
        while(iter.hasNext()){
            answer[idx++] = (int) iter.next();
        }
        Arrays.sort(answer);
        return answer;
    }
}