import java.util.*;
import java.io.*;

class Solution {
    static HashMap<String, Integer> hmap = new HashMap<>();
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        for(int i=0;i<participant.length;i++){
            hmap.put(participant[i],hmap.getOrDefault(participant[i],0)+1);
        }
        for(int i=0;i<completion.length;i++){
            hmap.put(completion[i],hmap.get(completion[i])-1);
        }
        for(String key : hmap.keySet()){
            if(hmap.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}