import java.util.*;
import java.io.*;

class Solution {
    static HashMap<String, Integer> hmap;
    public int solution(String[][] clothes) {
        hmap = new HashMap<>();
        int answer = 0;
        for(int i=0;i<clothes.length;i++){
            hmap.put(clothes[i][1], hmap.getOrDefault(clothes[i][1],0)+1);
        }
        int d = 1;
        for(String key : hmap.keySet()){
            d *= (hmap.get(key) + 1);
        }
        answer = d - 1;
        return answer;
    }
}