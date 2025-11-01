import java.util.*;
import java.io.*;

class Solution {
    static HashMap<String, Integer> hmap = new HashMap<>();
    public int solution(String[][] clothes) {
        int answer = 0;
        for(int i=0;i<clothes.length;i++){
            String s = clothes[i][1];
            hmap.put(s,hmap.getOrDefault(s,0)+1);
        }
        int sm = 1;
        for(int k : hmap.values()){
            sm *= (k+1);
        }
        return sm-1;
    }
}