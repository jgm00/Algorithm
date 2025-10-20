import java.util.*;
import java.io.*;

class Solution {
    static HashMap<String, String> hmap = new HashMap<>();
    public int solution(String s) {
        int answer = 0;
        hmap.put("zero","0"); hmap.put("one","1"); hmap.put("two","2");
        hmap.put("three","3"); hmap.put("four","4"); hmap.put("five","5");
        hmap.put("six","6"); hmap.put("seven","7"); hmap.put("eight","8");
        hmap.put("nine","9");
        for(String k : hmap.keySet()){
            s = s.replaceAll(k,hmap.get(k));
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}