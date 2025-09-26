import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int t=0;t<commands.length;t++){
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];
            int d = (j-i) + 1;
            int[] tmp = new int[d+1];
            int idx = 0;
            for(int tc =(i-1); tc <= (j-1);tc++){
                tmp[idx++] = array[tc];
            }
            Arrays.sort(tmp);
            answer[t] = tmp[k];
        }
        return answer;
    }
}