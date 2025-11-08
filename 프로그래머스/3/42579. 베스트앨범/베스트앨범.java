import java.util.*;
import java.io.*;

class Solution {
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Integer> ans = new ArrayList<>();
    static HashMap<String, Integer> hmap = new HashMap<>();
    static HashMap<String, List<Pair>> hmap2 = new HashMap<>();
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        for(int i=0;i<plays.length;i++){
            hmap.put(genres[i], hmap.getOrDefault(genres[i],0)+plays[i]);
            if(!hmap2.containsKey(genres[i])){
                hmap2.put(genres[i], new ArrayList<>());
            }
            hmap2.get(genres[i]).add(new Pair(i,plays[i]));
        }
        List<Map.Entry<String, Integer>> alst = new ArrayList<>(hmap.entrySet());
        Collections.sort(alst,(o1,o2)->{
            return o2.getValue() - o1.getValue();
        });
        for(int i=0;i<alst.size();i++){
            String s = alst.get(i).getKey();
            Collections.sort(hmap2.get(s), (o1,o2)->{
                return o2.y - o1.y;
            });
        }
        for(int i=0;i<alst.size();i++){
            int idx = 0;
            String s = alst.get(i).getKey();
            for(int j=0;j<hmap2.get(s).size();j++){
                ans.add(hmap2.get(s).get(j).x);
                idx +=1;
                if(idx == 2){
                    break;
                }
            }
        }
        int idxx = 0;
        answer = new int[ans.size()];
        for(int k : ans){
            answer[idxx++] = k;
        }
        return answer;
    }
}