import java.util.*;
import java.io.*;

class Solution {
    static HashMap<Character, Integer> hmap = new HashMap<>();
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(hmap.get(c) == null){
                answer[i] = -1;
                hmap.put(c,i);
            }else{
                int k = hmap.get(c);
                answer[i] = i-k;
                hmap.put(c,i);
            }
        }
        return answer;
    }
}