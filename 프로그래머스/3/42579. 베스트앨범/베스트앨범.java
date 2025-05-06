import java.util.*;
import java.io.*;

class Solution {
    static class Song implements Comparable<Song> {
        int idx;
        int songcnt;
        Song(int idx, int songcnt){
            this.idx = idx;
            this.songcnt = songcnt;
        }
        @Override
        public int compareTo(Song o1){
            if(this.songcnt == o1.songcnt){
                return this.idx - o1.idx;
            }
            return o1.songcnt - this.songcnt;
        }
    }
    static HashMap<String, Integer> hmap;
    static HashMap<String, ArrayList<Song>> hsong;
    public int[] solution(String[] genres, int[] plays) {
        hmap = new HashMap<>();
        hsong = new HashMap<>();
        for(int i=0;i<genres.length; i++){
            if(hmap.containsKey(genres[i]) == true){
                hmap.put(genres[i],hmap.get(genres[i])+plays[i]);
            }else{
                hmap.put(genres[i],plays[i]);
            }
            if(hsong.containsKey(genres[i]) == false){
                    hsong.put(genres[i], new ArrayList<>());
                    hsong.get(genres[i]).add(new Song(i,plays[i]));
                }else{
                    hsong.get(genres[i]).add(new Song(i,plays[i]));
                }
        }
        List<Map.Entry<String, Integer>> hlst = new ArrayList<>(hmap.entrySet());
        Collections.sort(hlst,(o1,o2)->{
            return o2.getValue() - o1.getValue();
        });
        ArrayList<Integer> tempans = new ArrayList<>();
        int anscnt = 0;
        for(int i=0;i<hlst.size();i++){
            System.out.println(hlst.get(i).getKey());
            ArrayList<Song> alst = hsong.get(hlst.get(i).getKey());
            Collections.sort(alst);
            int cnt = 0;
            for(int j=0;j<alst.size();j++){
                if(cnt >= 2){
                    break;
                }
                tempans.add(alst.get(j).idx);
                anscnt++;
                System.out.println(alst.get(j).idx + " " + alst.get(j).songcnt);
                cnt++;
            }
        }
        int[] answer = new int[anscnt];
        for(int i=0;i<anscnt;i++){
            answer[i] = tempans.get(i);
        }
        return answer;
    }
}