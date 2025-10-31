import java.util.*;
import java.io.*;

class Solution {
    static HashMap<String, HashSet<String>> hmap = new HashMap<>();
    static HashMap<String, Integer> hmap2 = new HashMap<>();
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        for(int i=0;i<report.length;i++){
            String[] strs = report[i].split(" ");
            String str1 = strs[0];
            String str2 = strs[1];
            if(!hmap.containsKey(str1)){
                hmap.put(str1,new HashSet<>());
            }
            hmap.get(str1).add(str2);
        }
        for(HashSet<String> sets : hmap.values()){
            for(String s : sets){
                hmap2.put(s,hmap2.getOrDefault(s,0)+1);
            }
        }
        int idx = 0;
        for(String s : id_list){
            int ans = 0;
            if(!hmap.containsKey(s)){
                idx++;
                continue;
            }
            for(String s1 : hmap.get(s)){
                if(hmap2.get(s1) >= k){
                    ans += 1;
                }
            }
            answer[idx++] = ans;
        }
        return answer;
    }
}