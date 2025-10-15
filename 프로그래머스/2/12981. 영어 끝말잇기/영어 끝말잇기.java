import java.util.*;
import java.io.*;

class Solution {
    static HashSet<String> hset = new HashSet<>();
    public int[] solution(int n, String[] words) {
        hset = new HashSet<>();
        int[] answer = new int[2];
        int who = 0;
        int cnt = n;
        char prev = words[0].charAt(words[0].length()-1);
        hset.add(words[0]);
        for(int i = 1; i<words.length;i++){
            char cur = words[i].charAt(0);
            cnt += 1;
            who = (who + 1) % n;
            if(prev != cur || hset.contains(words[i])){
                answer[0] = who + 1;
                answer[1] = cnt/n;
                return answer;
            }
            prev = words[i].charAt(words[i].length()-1);
            hset.add(words[i]);
        }
        return new int[]{0,0};
    }
}