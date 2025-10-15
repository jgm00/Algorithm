import java.util.*;
import java.io.*;

class Solution {
    StringBuilder sb = new StringBuilder();
    public String solution(String rny_string) {
        String answer = "";
        for(char c : rny_string.toCharArray()){
            if(c == 'm'){
                sb.append("rn");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}