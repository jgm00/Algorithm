import java.util.*;
import java.io.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    public String solution(String new_id) {
        String answer = "";
        for(char c : new_id.toCharArray()){
            sb.append(Character.toLowerCase(c));
        }
        String s = sb.toString();
        sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if((c >= 'a' && c <= 'z')|| c == '-' || c == '_' || c == '.' || (c >= '0' && c <= '9')){
               sb.append(c);
            }
        }
        s = sb.toString();
        sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '.'){
                if(sb.length() == 0 || sb.charAt(sb.length()-1) != '.'){
                    sb.append('.');
                }
            }else{
                sb.append(s.charAt(i));
            }
            
        }
        s = sb.toString();
        sb = new StringBuilder();
        for(int i=0;i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '.' && (i == 0 || i == s.length()-1)){
                continue;
            }
            sb.append(c);
        }
        if(sb.length()==0){
            sb.append("a");
        }
        s = sb.toString();
        if(s.length()>=16){
            s = s.substring(0,15);
        }
        if(s.charAt(s.length()-1)=='.'){
           s = s.substring(0,14);
        }
        char cc = s.charAt(s.length()-1);
        StringBuilder sb1 = new StringBuilder(s);
        while(sb1.length()<3){
            sb1.append(cc);
        }
        return sb1.toString();
    }
}