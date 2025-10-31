import java.util.*;
import java.io.*;

class Solution {
    static int[] day = {31,29,31,30,31,30,31,31,30,31,30,31};
    static String[] d = {"FRI", "SAT","SUN","MON","TUE","WED","THU"};
    public String solution(int a, int b) {
        String answer = "";
        int dd = 0;
        for(int i=0;i<a-1;i++){
            dd += day[i];
        }
        dd += b - 1;
        dd %= 7;
        answer = d[dd];
        return answer;
    }
}