import java.util.*;
import java.io.*;

class Solution {
    static HashMap<Integer, String> idxToS = new HashMap<>();
    static HashMap<String, Integer> hmap = new HashMap<>();
    static int[] rank;
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        rank = new int[players.length];
        for(int i=0;i<players.length;i++){
            hmap.put(players[i],i);
            idxToS.put(i,players[i]);
            rank[i]=i;
        }
        for(String call:callings){
            int k = hmap.get(call);
            int tmp = rank[k-1];
            rank[k-1] = rank[k];
            rank[k] = tmp;
            hmap.put(idxToS.get(tmp),k);
            hmap.put(call,k-1);
        }
        for(int i=0;i<rank.length;i++){
            answer[i] = idxToS.get(rank[i]);
        }
        return answer;
    }
}