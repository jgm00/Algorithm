import java.util.*;
import java.io.*;

class Solution {
    static int MX = Integer.MIN_VALUE;
    static int MN = Integer.MAX_VALUE;
    public String solution(String s) throws IOException{
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            int k = Integer.parseInt(st.nextToken());
            MN = Math.min(MN, k);
            MX = Math.max(MX, k);
        }
        answer += MN;
        answer += " ";
        answer += MX;
        return answer;
    }
}