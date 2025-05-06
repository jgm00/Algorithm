import java.util.*;
import java.io.*;

class Solution {
    static HashMap<String, Integer> hmap;
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        hmap = new HashMap<>();
        int idx = 0;
        for(String phone : phone_book){
            hmap.put(phone, idx++);
        }
        for(String str : phone_book){
            for(int i=1;i<str.length(); i++){
                if(hmap.containsKey(str.substring(0,i)) == true){
                    answer = false;
                    break;
                };
            }
        }
        return answer;
    }
}