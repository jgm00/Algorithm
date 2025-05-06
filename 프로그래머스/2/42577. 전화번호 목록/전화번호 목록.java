import java.util.*;
import java.io.*;

class Solution {
    static HashSet<String> hset;
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        hset = new HashSet<>();
        for(String str1 : phone_book){
            hset.add(str1);
        }
        for(String str : phone_book){
            for(int i=1;i<str.length();i++){
               String temp = str.substring(0,i);
                if(hset.contains(temp)==true){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}