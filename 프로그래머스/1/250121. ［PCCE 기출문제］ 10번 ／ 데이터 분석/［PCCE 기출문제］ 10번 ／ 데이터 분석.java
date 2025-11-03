import java.util.*;
import java.io.*;

class Solution {
    static class Pair{
        int x,y,z,l;
        Pair(int x, int y, int z, int l){
            this.x = x;
            this.y = y;
            this.z = z;
            this.l = l;
        }
    }
    static HashMap<String, Integer> StoI = new HashMap<>();
    static ArrayList<int[]> alist = new ArrayList<>();
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer;
        StoI.put("code",0); StoI.put("date",1); StoI.put("maximum",2); StoI.put("remain",3); 
        for(int i=0;i<data.length;i++){
            int off = StoI.get(ext);
            if(data[i][off] < val_ext){
                alist.add(data[i]);
            }
        }
        int sortby = StoI.get(sort_by);
        alist.sort((o1, o2) -> Integer.compare(o1[sortby], o2[sortby]));
        answer = new int[alist.size()][4];
        for(int i=0;i<alist.size();i++){
            int[] datas = alist.get(i);
            for(int j=0;j<4;j++){
                answer[i][j] = datas[j];
            }
        }
        return answer;
    }
}