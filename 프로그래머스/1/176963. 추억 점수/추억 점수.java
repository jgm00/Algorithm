import java.util.*;
import java.io.*;

class Solution {
    static HashMap<String, Integer> hmap = new HashMap<>();
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        for(int i=0;i<name.length;i++){
            hmap.put(name[i],yearning[i]);
        }
        for(int i = 0; i<photo.length; i++){
            int k = 0;
            for(int j=0;j<photo[i].length; j++){
                if(hmap.containsKey(photo[i][j]))
                {
                    k += hmap.get(photo[i][j]);
                }
            }
            answer[i] = k;
        }
        return answer;
    }
}