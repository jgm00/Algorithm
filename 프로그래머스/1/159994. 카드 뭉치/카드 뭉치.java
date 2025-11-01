import java.util.*;
import java.io.*;

class Solution {
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static HashMap<String, Pair> hmap = new HashMap<>();
    static int idx1, idx2;
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        for(int i=0;i<cards1.length;i++){
            String s = cards1[i];
            hmap.put(s,new Pair(1,i));
        }
        for(int i=0;i<cards2.length;i++){
            String s = cards2[i];
            hmap.put(s,new Pair(2,i));
        }
        for(String s : goal){
            if(hmap.get(s).x==1){
                if(idx1==hmap.get(s).y){
                    idx1++;
                }else{
                    return "No";
                }
            }
            if(hmap.get(s).x==2){
                if(idx2==hmap.get(s).y){
                    idx2++;
                }else{
                    return "No";
                }
            }
        }
        return answer;
    }
}