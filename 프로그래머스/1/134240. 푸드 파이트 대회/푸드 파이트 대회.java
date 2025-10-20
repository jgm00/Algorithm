import java.util.*;
import java.io.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    public String solution(int[] food) {
        String answer = "";
        for(int i=1;i<food.length;i++){
            int k = food[i]/2;
            for(int j=0;j<k;j++){
                sb.append(i);
            }
        }
        sb.append(0);
        String str = sb.toString();
        for(int i=sb.length()-2;i>=0;i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}