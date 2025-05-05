import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<Integer> alist;
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            int b = commands[i][1];
            int a = commands[i][0];
            int k = b - a + 1;
            alist = new ArrayList<>();
            for(int j = a-1;j < b;j++){
                alist.add(array[j]);
            }
            Collections.sort(alist);
            answer[i] = alist.get(commands[i][2]-1);
        }
        return answer;
    }
}