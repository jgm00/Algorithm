import java.util.*;
import java.io.*;

class Solution {
    static HashMap<String, Integer> hmap;
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        hmap = new HashMap<String, Integer>();
        for(String name : participant){
            hmap.put(name, hmap.getOrDefault(name,0)+1);
        }
        for(String name2 : completion){
            hmap.put(name2, hmap.get(name2) - 1);
        }
        for(String s : hmap.keySet()){
            if(hmap.get(s)!=0){
                answer = s;
            };
        }
        return answer;
    }
}